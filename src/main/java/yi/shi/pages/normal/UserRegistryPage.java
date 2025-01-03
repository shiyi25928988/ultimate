package yi.shi.pages.normal;

import j2html.tags.ContainerTag;
import yi.shi.pages.element.Ajax;
import yi.shi.pages.element.Head;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.result.HTML;

import static j2html.TagCreator.*;

@HttpService
public class UserRegistryPage {

    @GET
    @HttpPath(value = "/page/userRegistry")
    public HTML userRegistryPage() throws Exception {
        HTML html = new HTML();
        html.setHtmlContent(createUserRegistryPage().render());
        return html;
    }

    public static ContainerTag createUserRegistryPage() {
        ContainerTag head = Head.createHead("用户注册");

        ContainerTag form = form().withId("registrationForm").withClass("col s12").with(
                div().withClass("row").with(
                        div().withClass("input-field col s12").with(
                                input().withId("username").withType("text").withClass("validate"),
                                label().withFor("username").withText("用户名")
                        )
                ),
                div().withClass("row").with(
                        div().withClass("input-field col s12").with(
                                input().withId("email").withType("email").withClass("validate"),
                                label().withFor("email").withText("邮箱")
                        )
                ),
                div().withClass("row").with(
                        div().withClass("input-field col s12").with(
                                input().withId("password").withType("password").withClass("validate"),
                                label().withFor("password").withText("密码")
                        )
                ),
                div().withClass("row").with(
                        div().withClass("input-field col s12").with(
                                input().withId("confirmPassword").withType("password").withClass("validate"),
                                label().withFor("confirmPassword").withText("确认密码")
                        )
                ),
                div().withClass("row").with(
                        button().withClass("btn waves-effect waves-light").withType("submit").withName("action").withText("注册").with(
                                i().withClass("material-icons right").withText("send")
                        )
                )
        );

        ContainerTag body = body(
                div().withClass("container").with(
                        h4().withClass("center-align").withText("用户注册"),
                        form
                ),
                script(("$(document).ready(function() {\n" +
                        "                    $('#registrationForm').submit(function(event) {\n" +
                        "                        event.preventDefault();\n" +
                        "                        var username = $('#username').val();\n" +
                        "                        var email = $('#email').val();\n" +
                        "                        var password = $('#password').val();\n" +
                        "                        var confirmPassword = $('#confirmPassword').val();\n" +
                        "\n" +
                        "                        if (password !== confirmPassword) {\n" +
                        "                            alert('密码不匹配');\n" +
                        "                            return;\n" +
                        "                        }\n" +
                        "\n" +
                        "                        // 发送 AJAX 请求\n" + Ajax.getAjax("/api/user/add", "{username: username, email: email, passwd: password}") +
//                        "                        $.ajax({\n" +
//                        "                            url: '/api/user/add',\n" +
//                        "                            type: 'POST',\n" +
//                        "                            contentType: 'application/json',\n" +
//                        "                            data: JSON.stringify({\n" +
//                        "                                username: username,\n" +
//                        "                                email: email,\n" +
//                        "                                passwd: password\n" +
//                        "                            }),\n" +
//                        "                            success: function(response) {\n" +
//                        "                                alert('用户注册成功！');\n" +
//                        "                                console.log(response);\n" +
//                        "                                window.location.href = '/';" +
//                        "                            },\n" +
//                        "                            error: function(error) {\n" +
//                        "                                alert('用户注册失败：' + error.responseText);\n" +
//                        "                                console.error(error);\n" +
//                        "                            }\n" +
//                        "                        });\n" +
                        "                    });\n" +
                        "                });")
        ));
        return  html(head, body);
    }
}
