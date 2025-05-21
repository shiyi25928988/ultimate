package yi.shi.utils;


import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

public class HttpUtil {

    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private static final Gson gson = new Gson();
    private static final OkHttpClient client = new OkHttpClient();

    /**
     * 发送一个 GET 请求并返回指定类型的响应结果。
     *
     * @param url 请求的目标 URL。
     * @param headers HTTP 请求头信息，可以为空。
     * @param responseType 返回值类型。
     * @param <T> 返回值的类型。
     * @return 指定类型的响应结果。
     * @throws IOException 如果请求失败。
     */
    public static <T> T get(String url, Map<String, String> headers, Class<T> responseType) throws IOException {
        Request.Builder requestBuilder = new Request.Builder().url(url);

        if (headers != null && !headers.isEmpty()) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                requestBuilder.addHeader(entry.getKey(), entry.getValue());
            }
        }

        Request request = requestBuilder.build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            String responseBody = response.body().string();
            return gson.fromJson(responseBody, responseType);
        }
    }

    /**
     * 发送一个 POST 请求并返回指定类型的响应结果。
     *
     * @param url 请求的目标 URL。
     * @param requestBody 请求体，可以为任意对象。
     * @param headers HTTP 请求头信息，可以为空。
     * @param responseType 返回值类型。
     * @param <T> 返回值的类型。
     * @return 指定类型的响应结果。
     * @throws IOException 如果请求失败。
     */
    public static <T> T post(String url, Object requestBody, Map<String, String> headers, Class<T> responseType) throws IOException {
        String json = gson.toJson(requestBody);
        RequestBody body = RequestBody.create(json, JSON);

        Request.Builder requestBuilder = new Request.Builder()
                .url(url)
                .post(body);

        if (headers != null && !headers.isEmpty()) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                requestBuilder.addHeader(entry.getKey(), entry.getValue());
            }
        }

        Request request = requestBuilder.build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            String responseBody = response.body().string();
            return gson.fromJson(responseBody, responseType);
        }
    }
}