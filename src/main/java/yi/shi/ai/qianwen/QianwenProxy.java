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

public class QianwenProxy {

    public static String generate(String prompt) throws NoApiKeyException, InputRequiredException {
        Generation gen = new Generation();
        Message systemMsg = Message.builder()
                .role(Role.SYSTEM.getValue())
                .content("You are a helpful assistant.")
                .build();
        Message userMsg = Message.builder()
                .role(Role.USER.getValue())
                .content(prompt)
                .build();
        GenerationParam param = GenerationParam.builder()
                // 若没有配置环境变量，请用百炼API Key将下行替换为：.apiKey("sk-xxx")
                .apiKey(KeyUtil.deobfuscateApiKey("EglOc3JzUAYLVAECciRwBVMFUltWIycmB1ZQAwMFJXtxCAo="))
                // 模型列表：https://help.aliyun.com/zh/model-studio/getting-started/models
                .model("qwen-plus")
                .messages(Arrays.asList(systemMsg, userMsg))
                .resultFormat(GenerationParam.ResultFormat.MESSAGE)
                .build();
        return gen.call(param).getOutput().getChoices().get(0).getMessage().getContent();
    }

}
