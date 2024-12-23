package yi.shi.restapi;

import com.google.inject.Inject;
import yi.shi.db.model.UserAccount;
import yi.shi.plinth.annotation.http.HttpBody;
import yi.shi.plinth.annotation.http.HttpParam;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.annotation.http.Method.POST;
import yi.shi.plinth.http.result.JSON;
import yi.shi.result.Result;
import yi.shi.service.UserService;
import yi.shi.utils.PasswordEncryptor;

import java.util.Date;

@HttpService
public class UserApi {

    @Inject
    UserService userService;

    @POST
    @HttpPath("/api/user/add")
    public JSON<Result<Integer>> addUser(@HttpBody UserAccount userAccount) {
        if(userService.checkIfUserExist(userAccount.getUsername())){
            return new JSON<>(Result.fail("用户名已存在"));
        }
        userAccount.setRole("user");
        int res = userService.addNewUser(userAccount);
        Result result =Result.success(res);
        result.setMessage("用户注册成功");
        return new JSON<>(result);
    }

}
