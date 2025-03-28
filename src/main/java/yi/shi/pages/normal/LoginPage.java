package yi.shi.pages.normal;

import j2html.tags.ContainerTag;
import yi.shi.pages.component.Head;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.result.HTML;

import static j2html.TagCreator.*;

@HttpService
public class LoginPage {

    @GET
    @HttpPath(value = "/page/login")
    public HTML loginPage()
    {
        HTML html = new HTML();
        return html.setHtmlContent(createLoginPage().render());
    }

    public static ContainerTag createLoginPage() {
        return html(
                Head.createHead("login"),
                body(
                        div().withClass("container").with(
                                div().withClass("row").with(
                                        div().withClass("col s12 m6 offset-m3").with(
                                                div().withClass("card").with(
                                                        div().withClass("card-content").with(
                                                                h5().withClass("center").withText("登录"),
                                                                br(),
                                                                form().withId("loginForm").with(
                                                                        div().withClass("input-field").with(
                                                                                input().withType("text")
                                                                                        .withName("username")
                                                                                        .withId("username")
                                                                                        .withClass("validate")
                                                                                        .withPlaceholder("请输入用户名")
                                                                                        .attr("autocomplete", "username"),
                                                                                label().withFor("username").withText("用户名")
                                                                        ),
                                                                        div().withClass("input-field").with(
                                                                                input().withType("password")
                                                                                        .withName("password")
                                                                                        .withId("password")
                                                                                        .withClass("validate")
                                                                                        .withPlaceholder("请输入密码")
                                                                                        .attr("autocomplete", "current-password"),
                                                                                label().withFor("password")
                                                                                        .withText("密码")
                                                                        ),
                                                                        div().withClass("center").with(
                                                                                button().withType("button").withClass("btn waves-effect waves-light").withText("登录").withId("loginButton")
                                                                        ),
                                                                        br(),
                                                                        div().withClass("center").with(
                                                                                a().withHref("/page/userRegistry").withText("没有账号？点我注册")
                                                                        )

                                                                )
                                                        )
                                                )
                                        )
                                )
                        ),
                        script("document.getElementById('loginButton').addEventListener('click', function() {\n" +
                                "                        var username = document.getElementById('username').value;\n" +
                                "                        var password = document.getElementById('password').value;\n" +
                                "                        var data = {\n" +
                                "                            \"username\": username,\n" +
                                "                            \"password\": password\n" +
                                "                        };\n" +
                                "\n" +
                                "                        $.ajax({\n" +
                                "                            url: '/api/login',\n" +
                                "                            type: 'POST',\n" +
                                "                            contentType: 'application/json',\n" +
                                "                            data: JSON.stringify(data),\n" +
                                "                            success: function(response) {\n" +
                                "                                M.toast({\n" +
                                "                                    html: '登录成功！',\n" +
                                "                                })\n" +
                                "                            window.location.href = '/';\n" +
                                "                            },\n" +
                                "                            error: function(xhr, status, error) {\n" +
                                "                                M.toast({\n" +
                                "                                    html: '登陆失败: 请确认用户名和密码是否正确 ' + xhr.statusText,\n" +
                                "                                })\n" +
                                "                            }\n" +
                                "                        });\n" +
                                "                    });")
                ).withStyle("display: flex; min-height: 100vh; align-items: center; justify-content: center;")
        );
    }
}
