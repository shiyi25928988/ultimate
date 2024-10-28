package yi.shi.restapi;

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

import java.io.IOException;

@HttpService
public class LoginApi {

    @POST
    @HttpPath(value = "/api/login")
    public JSON<LoginResult> login(@HttpBody LoginUser loginUser) {
        AuthHelper.login(loginUser, "user");
        LoginResult result = new LoginResult("ok");
        return new JSON<>(result);
    }

    @GET
    @HttpPath(value = "/api/logout")
    public void logout() throws IOException {
        AuthHelper.logout();
        ServletHelper.getResponse().sendRedirect("/login");
    }
}
