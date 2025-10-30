package yi.shi.view.pages;

import j2html.tags.ContainerTag;
import j2html.tags.specialized.*;
import lombok.extern.slf4j.Slf4j;
import yi.shi.view.Page;
import yi.shi.view.element.Button;
import yi.shi.view.element.Input;
import yi.shi.view.component.Ajax;
import yi.shi.view.component.Head;
import yi.shi.view.element.Icon;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.result.HTML;

import static j2html.TagCreator.*;

@Slf4j
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
                Input.getInputWithIcon(Input.INPUT_WIDTH_FULL, "username", "用户名", Input.TYPE_TEXT, Icon.prefixIcon("account_circle"), false),
                Input.getInputWithIcon(Input.INPUT_WIDTH_FULL, "email", "email", Input.TYPE_TEXT, Icon.prefixIcon("email"), false),
                Input.getInput(Input.INPUT_WIDTH_FULL, "password", "密码", Input.TYPE_PASSWORD, false),
                Input.getInput(Input.INPUT_WIDTH_FULL, "confirmPassword", "确认密码", Input.TYPE_PASSWORD, false),
                Button.submitButton("注册")
        );

        MainTag main = main(
                div().withClass("container").with(
                        h4().withClass("center-align").withText("用户注册"),
                        form
                ),
                script("""
                        $(document).ready(function() {
                            $('#registrationForm').submit(function(event) {
                                event.preventDefault();
                                var username = $('#username').val();
                                var email = $('#email').val();
                                var password = $('#password').val();
                                var confirmPassword = $('#confirmPassword').val();
                                if (username == null || username == ''){
                                    M.toast({
                                        html: '用户名不能为空',
                                    });
                                    return;
                                }
                                if (password == null || password == ''){
                                    M.toast({
                                        html: '密码不能为空',
                                    });
                                    return;
                                }
                                if (password !== confirmPassword) {
                                    M.toast({
                                        html: '两次输入密码不一致',
                                    });
                                    return;
                                }
                                %s
                        });});
                        """.formatted(Ajax.postAjax("/api/user/add", "{username: username, email: email, passwd: password}", "/page/login"))
                )
        );
        return main;
    }

    @Override
    protected FooterTag createFooter() {
        return null;
    }

}
