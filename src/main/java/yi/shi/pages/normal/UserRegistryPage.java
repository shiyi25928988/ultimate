package yi.shi.pages.normal;

import j2html.tags.ContainerTag;
import yi.shi.pages.component.Input;
import yi.shi.pages.element.Ajax;
import yi.shi.pages.element.Head;
import yi.shi.pages.element.Icon;
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
                Input.getInputWithIcon(Input.INPUT_WIDTH_FULL, "username", "用户名", Input.TYPE_TEXT, Icon.icon("account_circle", Icon.PREFIX), false),
                Input.getInputWithIcon(Input.INPUT_WIDTH_FULL, "email", "email", Input.TYPE_TEXT, Icon.icon("email", Icon.PREFIX), false),
                Input.getInput(Input.INPUT_WIDTH_FULL, "password", "密码", Input.TYPE_PASSWORD, false),
                Input.getInput(Input.INPUT_WIDTH_FULL, "confirmPassword", "确认密码", Input.TYPE_PASSWORD, false),
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
