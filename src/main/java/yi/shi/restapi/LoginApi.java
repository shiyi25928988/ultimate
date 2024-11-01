package yi.shi.restapi;

import com.google.inject.Inject;
import yi.shi.data.LoginResult;
import yi.shi.data.LoginUser;
import yi.shi.plinth.annotation.http.HttpBody;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.annotation.http.Method.POST;
import yi.shi.plinth.auth.AuthHelper;
import yi.shi.plinth.http.result.JSON;
import yi.shi.plinth.servlet.ServletHelper;
import yi.shi.service.UserService;

import java.io.IOException;

@HttpService
public class LoginApi {

    @Inject
    UserService userService;

    @POST
    @HttpPath(value = "/api/login")
    public JSON<LoginResult> login(@HttpBody LoginUser loginUser) {
        if(userService.checkUser(loginUser.getUsername(), loginUser.getPassword())){
            AuthHelper.login(loginUser, "user");
            LoginResult result = new LoginResult("LOGIN SUCCESS!");
            return new JSON<>(result);
        }
        LoginResult result = new LoginResult("LOGIN FAILED!");
        return new JSON<>(result);
    }

    @GET
    @HttpPath(value = "/api/logout")
    public void logout() throws IOException {
        AuthHelper.logout();
        ServletHelper.getResponse().sendRedirect("/page/login");
    }
}
