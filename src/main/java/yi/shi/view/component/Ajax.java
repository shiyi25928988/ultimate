package yi.shi.view.component;

import lombok.extern.slf4j.Slf4j;
import yi.shi.plinth.utils.JsonUtils;

@Slf4j
public class Ajax {

    public static String getAjax(String url, Object  data){
        return getAjaxFunction(url, "GET", JsonUtils.toJson(data));
    }
    public static String getAjax(String url, String  data){
        return getAjaxFunction(url, "GET", data);
    }

    public static String postAjax(String url, Object  data){
        return getAjaxFunction(url, "POST", JsonUtils.toJson(data));
    }

    public static String postAjax(String url, String  data){
        return getAjaxFunction(url, "POST", data);
    }

    public static String getAjax(String url, Object  data, String callbackUrl){
        return getAjaxFunction(url, "GET", JsonUtils.toJson(data), callbackUrl);
    }
    public static String getAjax(String url, String  data, String callbackUrl){
        return getAjaxFunction(url, "GET", data, callbackUrl);
    }

    public static String postAjax(String url, Object  data, String callbackUrl){
        return getAjaxFunction(url, "POST", JsonUtils.toJson(data), callbackUrl);
    }

    public static String postAjax(String url, String  data, String callbackUrl){
        return getAjaxFunction(url, "POST", data, callbackUrl);
    }

    private static String getAjaxFunction(String url, String method, String data){
        String ajax =
                """
                    $.ajax({
                    url: '%s',
                    method: '%s',
                    data: JSON.stringify(%s),
                    success: function(response) {
                        if (response.code === 1) {
                            M.toast({
                                html: response.message,
                             });
                        } else if (response.code === 0) {
                             M.toast({
                                 html: response.message,
                             });
                        }
                    },
                    error: function(xhr, status, error) {
                             M.toast({
                                 html: xhr.statusText,
                             });
                        console.error('请求失败:', error);
                    }
                });
                """.formatted(url, method, data);
        return ajax;
    }

    private static String getAjaxFunction(String url, String method, String data, String callbackUrl){
        String ajax =
                """
                    $.ajax({
                    url: '%s',
                    method: '%s',
                    data: JSON.stringify(%s),
                    success: function(response) {
                        if (response.code === 1) {
                            M.toast({
                                html: response.message,
                             });
                             setTimeout(function() {
                                window.location.href = '%s';
                             }, 1000);
                        } else if (response.code === 0) {
                             M.toast({
                                 html: response.message,
                             });
                        }
                    },
                    error: function(xhr, status, error) {
                             M.toast({
                                 html: xhr.statusText,
                             });
                        console.error('请求失败:', error);
                    }
                });
                """.formatted(url, method, data, callbackUrl);
        return ajax;
    }
}
