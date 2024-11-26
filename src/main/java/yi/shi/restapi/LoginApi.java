package yi.shi.restapi;

import cn.dev33.satoken.stp.StpUtil;
import com.google.inject.Inject;
import lombok.extern.log4j.Log4j;
import yi.shi.data.LoginResult;
import yi.shi.data.LoginUser;
import yi.shi.plinth.annotation.http.HttpBody;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.annotation.http.Method.POST;
import yi.shi.plinth.auth.AuthHelper;
import yi.shi.plinth.http.HttpErrorRespHelper;
import yi.shi.plinth.http.result.JSON;
import yi.shi.plinth.servlet.ServletHelper;
import yi.shi.service.UserService;

import java.io.IOException;

@HttpService
@Log4j
public class LoginApi {

    @Inject
    UserService userService;

    @POST
    @HttpPath(value = "/api/login")
    public JSON<LoginResult> login(@HttpBody LoginUser loginUser) throws IOException {
        if(userService.checkUser(loginUser.getUsername(), loginUser.getPassword())){
            String role = userService.getRoleByUsername(loginUser.getUsername());
            Long userId = userService.getUserIdByUsername(loginUser.getUsername());
            AuthHelper.login(userId, role.split(","));
            LoginResult result = new LoginResult("LOGIN SUCCESS!");
            return new JSON<>(result);
        }
        HttpErrorRespHelper.send401();
        return null;
    }

    @GET
    @HttpPath(value = "/api/logout")
    public void logout() throws IOException {
        AuthHelper.logout();
        ServletHelper.getResponse().sendRedirect("/page/login");
    }
}
