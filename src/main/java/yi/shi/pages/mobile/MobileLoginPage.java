package yi.shi.pages.mobile;

import j2html.tags.specialized.BodyTag;
import j2html.tags.specialized.FooterTag;
import j2html.tags.specialized.HeadTag;
import j2html.tags.specialized.HeaderTag;
import yi.shi.pages.Page;
import yi.shi.plinth.annotation.http.HttpService;

import static j2html.TagCreator.*;
import static j2html.TagCreator.script;

@HttpService
public class MobileLoginPage extends Page {
    @Override
    protected HeadTag createHead() {
        return head(
                meta().withCharset("UTF-8"),
                meta().withName("viewport").withContent("width=device-width, initial-scale=1"),
                title("Sign in - Mobile"),
                link().withRel("stylesheet").withHref("/css/materialize.min.css"),
                link().withRel("stylesheet").withHref("/css/toastify.css"),
                script().withSrc("/js/jquery.min.js"),
                script().withSrc("/js/materialize.min.js"),
                script().withSrc("/js/toastify.js")
        );
    }

    @Override
    protected HeaderTag createHeader() {
        return null;
    }

    @Override
    protected BodyTag createBody() {
        return body(
                div().withClass("container").with(
                        div().withClass("row").with(
                                div().withClass("col s12 m6 offset-m3").with(
                                        div().withClass("card").with(
                                                div().withClass("card-content").with(
                                                        h5().withClass("center").withText("登录"),
                                                        form().withId("loginForm").with(
                                                                div().withClass("input-field").with(
                                                                        input().withType("text").withName("username").withId("username").withClass("validate").withPlaceholder("请输入用户名").attr("autocomplete", "on"),
                                                                        label().withFor("username").withText("用户名")
                                                                ),
                                                                div().withClass("input-field").with(
                                                                        input().withType("password").withName("password").withId("password").withClass("validate").withPlaceholder("请输入密码").attr("autocomplete", "on"),
                                                                        label().withFor("password").withText("密码")
                                                                ),
                                                                div().withClass("center").with(
                                                                        button().withType("button").withClass("btn waves-effect waves-light").withText("登录").withId("loginButton").attr("style", "margin-top: 10px;")
                                                                ),
                                                                br(),
                                                                div().withClass("center").with(
                                                                        a().withHref("/page/userRegistry").withText("没有账号？点我注册").attr("style", "margin-top: 10px; display: block;")
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                ),
                script("document.getElementById('loginButton').addEventListener('click', function() {\n" +
                        "    var username = document.getElementById('username').value;\n" +
                        "    var password = document.getElementById('password').value;\n" +
                        "    var data = {\n" +
                        "        'username': username,\n" +
                        "        'password': password\n" +
                        "    };\n" +
                        "\n" +
                        "    $.ajax({\n" +
                        "        url: '/api/login',\n" +
                        "        type: 'POST',\n" +
                        "        contentType: 'application/json',\n" +
                        "        data: JSON.stringify(data),\n" +
                        "        success: function(response) {\n" +
                        "            Toastify({\n" +
                        "                text: '登录成功！',\n" +
                        "                duration: 3000,\n" +
                        "                close: true,\n" +
                        "                gravity: 'top',\n" +
                        "                position: 'center',\n" +
                        "                backgroundColor: '#4caf50',\n" +
                        "                stopOnFocus: true\n" +
                        "            }).showToast();\n" +
                        "            window.location.href = '/';\n" +
                        "        },\n" +
                        "        error: function(xhr, status, error) {\n" +
                        "            Toastify({\n" +
                        "                text: '登陆失败: 请确认用户名和密码是否正确 ' + xhr.statusText,\n" +
                        "                duration: 3000,\n" +
                        "                close: true,\n" +
                        "                gravity: 'top',\n" +
                        "                position: 'center',\n" +
                        "                backgroundColor: '#f44336',\n" +
                        "                stopOnFocus: true\n" +
                        "            }).showToast();\n" +
                        "        }\n" +
                        "    });\n" +
                        "});")
        );
    }

    @Override
    protected FooterTag createFooter() {
        return null;
    }
}
