package yi.shi.pages.normal;

import cn.dev33.satoken.stp.StpUtil;
import com.google.inject.Inject;
import j2html.tags.ContainerTag;
import j2html.tags.specialized.FooterTag;
import j2html.tags.specialized.HeadTag;
import j2html.tags.specialized.HeaderTag;
import j2html.tags.specialized.MainTag;
import yi.shi.db.model.UserAccount;
import yi.shi.pages.Page;
import yi.shi.pages.component.Head;
import yi.shi.pages.element.Button;
import yi.shi.pages.element.Icon;
import yi.shi.pages.element.Input;
import yi.shi.plinth.annotation.auth.AUTH;
import yi.shi.plinth.annotation.http.HttpParam;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.result.HTML;
import yi.shi.service.UserService;

import static j2html.TagCreator.*;
import static j2html.TagCreator.h4;

@HttpService
public class MyProfilePage extends Page {

    private static ThreadLocal<UserAccount> userAccountThreadLocal = new ThreadLocal<>();

    @Inject
    UserService userService;

    @GET
    @AUTH(authUrl = "/page/login")
    @HttpPath(value = "/page/myProfile")
    public HTML myProfilePage() throws Exception {

        String id = String.valueOf(StpUtil.getLoginId());
        UserAccount userAccount =userService.getUserById(Long.parseLong(id));
        userAccountThreadLocal.set(userAccount);

        HTML html = new HTML();
        html.setHtmlContent(createHtml().render());
        return html;
    }

    @Override
    protected HeadTag createHead() throws Exception {
        return Head.createHead("个人资料");
    }

    @Override
    protected HeaderTag createHeader() throws Exception {
        return null;
    }

    @Override
    protected MainTag createMain() throws Exception {
        UserAccount userAccount = userAccountThreadLocal.get();
        ContainerTag form = form().withId("myProfileForm").withClass("col s6").with(
                Input.getInputWithIcon(Input.INPUT_WIDTH_FULL, "email", "email", Input.TYPE_TEXT, Icon.icon("email", Icon.PREFIX), false).withText(userAccount.getEmail()),
                Input.getInput(Input.INPUT_WIDTH_FULL, "nickname", "昵称", Input.TYPE_TEXT, false),
                Button.submitButton("注册")
        );

        MainTag main = main(
                div().withClass("container").with(
                        h4().withClass("center-align").withText("用户注册"),
                        form
                ));
        return main;
    }

    @Override
    protected FooterTag createFooter() throws Exception {
        return null;
    }
}
