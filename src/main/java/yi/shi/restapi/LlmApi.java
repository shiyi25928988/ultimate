package yi.shi.restapi;

import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import yi.shi.ai.qianwen.QianwenProxy;
import yi.shi.plinth.annotation.http.HttpParam;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;

@HttpService
public class LlmApi {

    @GET
    @HttpPath("/api/TONGYI/test")
    public String test(@HttpParam("prompt")String prompt) throws NoApiKeyException, InputRequiredException {
        return QianwenProxy.generate(prompt);
    }
}
