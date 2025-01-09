package yi.shi.ai.qianwen;

import com.alibaba.dashscope.aigc.generation.Generation;
import com.alibaba.dashscope.aigc.generation.GenerationParam;
import com.alibaba.dashscope.common.Message;
import com.alibaba.dashscope.common.Role;
import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import yi.shi.db.model.Books;
import yi.shi.plinth.utils.json.JsonUtils;
import yi.shi.utils.KeyUtil;

import java.io.IOException;
import java.util.Arrays;

public class AiBookInfoGenerator {

    private static final String template = "{\"bookName\":null,\"isbn\":null,\"digest\":null,\"author\":null,\"aboutAuthor\":null,\"price\":null,\"coverUrl\":null}";

    public static Books queryBookInfo(String bookName) throws NoApiKeyException, InputRequiredException, IOException {
        Generation gen = new Generation();
        Message systemMsg = Message.builder()
                .role(Role.SYSTEM.getValue())
                .content("You are a helpful librarian.")
                .build();
        Message userMsg = Message.builder()
                .role(Role.USER.getValue())
                .content("Query the book information of " + bookName + " and return the information as follow format: " + template)
                .build();
        GenerationParam param = GenerationParam.builder()
                .apiKey(KeyUtil.deobfuscateApiKey("EglOc3JzUAYLVAECciRwBVMFUltWIycmB1ZQAwMFJXtxCAo="))
                .model("qwen-plus")
                .messages(Arrays.asList(systemMsg, userMsg))
                .resultFormat(GenerationParam.ResultFormat.MESSAGE)
                .build();
        String res = gen.call(param).getOutput().getChoices().get(0).getMessage().getContent();
        System.out.println(res);
        return JsonUtils.fromJson(escapeJson(res).getBytes("UTF-8"), Books.class);
    }

    public static String escapeJson(String input) {
        if (input == null) {
            return null;
        }
        String _input = input.substring(input.indexOf("{"), input.lastIndexOf("}")+1);
        System.out.println(_input);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < _input.length(); i++) {
            char c = _input.charAt(i);
            if (c >= 32) {
                sb.append(c);
            }
        }
        return sb.toString();
    }


}
