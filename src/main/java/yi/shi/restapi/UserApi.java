package yi.shi.restapi;

import com.google.inject.Inject;
import yi.shi.db.model.UserAccount;
import yi.shi.plinth.annotation.http.HttpBody;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.POST;
import yi.shi.plinth.http.result.JSON;
import yi.shi.result.ResponseWrapper;
import yi.shi.service.UserService;

@HttpService
public class UserApi {

    @Inject
    UserService userService;

    @POST
    @HttpPath("/api/user/add")
    public JSON<ResponseWrapper<Integer>> addUser(@HttpBody UserAccount userAccount) {
        if(userService.checkIfUserExist(userAccount.getUsername())){
            return new JSON<>(ResponseWrapper.fail("用户名已存在"));
        }
        userAccount.setRole("user");
        int res = userService.addNewUser(userAccount);
        ResponseWrapper result = ResponseWrapper.success(res);
        result.setMessage("用户注册成功");
        return new JSON<>(result);
    }

}
