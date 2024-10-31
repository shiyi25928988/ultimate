package yi.shi.restapi;

import com.google.inject.Inject;
import yi.shi.db.mapper.UserAccountMapper;
import yi.shi.db.model.UserAccount;
import yi.shi.plinth.annotation.http.HttpBody;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.POST;
import yi.shi.plinth.http.result.JSON;
import yi.shi.result.Result;

@HttpService
public class UserApi {

    @Inject
    UserAccountMapper userAccountMapper;

    @POST
    @HttpPath("/api/user/add")
    public JSON<Result<Integer>> addUser(@HttpBody UserAccount userAccount) {
        int res = userAccountMapper.insert(userAccount);
        return new JSON<>(Result.success(res));
    }
}
