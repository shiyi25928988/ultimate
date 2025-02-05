package yi.shi.pages.normal;

import j2html.tags.ContainerTag;
import j2html.tags.specialized.*;
import yi.shi.pages.Page;
import yi.shi.pages.element.Button;
import yi.shi.pages.element.Input;
import yi.shi.pages.component.Ajax;
import yi.shi.pages.component.Head;
import yi.shi.pages.element.Icon;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.result.HTML;

import static j2html.TagCreator.*;

@HttpService
public class UserRegistryPage extends Page {

    @GET
    @HttpPath(value = "/page/userRegistry")
    public HTML userRegistryPage() throws Exception {
        HTML html = new HTML();
        html.setHtmlContent(createHtml().render());
        return html;
    }

    @Override
    protected HeadTag createHead() {
        return Head.createHead("用户注册");
    }

    @Override
    protected HeaderTag createHeader() {
        return null;
    }

    @Override
    protected MainTag createMain() {
        ContainerTag form = form().withId("registrationForm").withClass("col s6").with(
                Input.getInputWithIcon(Input.INPUT_WIDTH_FULL, "username", "用户名", Input.TYPE_TEXT, Icon.icon("account_circle", Icon.PREFIX), false),
                Input.getInputWithIcon(Input.INPUT_WIDTH_FULL, "email", "email", Input.TYPE_TEXT, Icon.icon("email", Icon.PREFIX), false),
                Input.getInput(Input.INPUT_WIDTH_FULL, "password", "密码", Input.TYPE_PASSWORD, false),
                Input.getInput(Input.INPUT_WIDTH_FULL, "confirmPassword", "确认密码", Input.TYPE_PASSWORD, false),
                Button.submitButton("注册")
        );

        MainTag main = main(
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
                        "                    });\n" +
                        "                });")
                ));
        return main;
    }

    @Override
    protected FooterTag createFooter() {
        return null;
    }

}
