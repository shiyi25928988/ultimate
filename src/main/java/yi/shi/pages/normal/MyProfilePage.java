package yi.shi.pages.normal;

import cn.dev33.satoken.stp.StpUtil;
import com.google.inject.Inject;
import j2html.tags.specialized.FooterTag;
import j2html.tags.specialized.HeadTag;
import j2html.tags.specialized.HeaderTag;
import j2html.tags.specialized.MainTag;
import yi.shi.db.model.UserAccount;
import yi.shi.pages.Page;
import yi.shi.pages.component.Footer;
import yi.shi.pages.component.Head;
import yi.shi.pages.component.Header;
import yi.shi.pages.element.Input;
import yi.shi.pages.element.image.ImageUploadAndPreview;
import yi.shi.plinth.annotation.auth.AUTH;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.result.HTML;
import yi.shi.service.UserService;

import static j2html.TagCreator.*;

@HttpService
public class MyProfilePage extends Page {

    @Inject
    UserService userService;

    @GET
    @AUTH(authUrl = "/page/login")
    @HttpPath(value = "/page/myProfile")
    public HTML myProfilePage() throws Exception {
        HTML html = new HTML();
        html.setHtmlContent(createHtml().render());
        return html;
    }

    @Override
    protected HeadTag createHead() throws Exception {
        return Head.createHead("个人资料").with(
                script().withSrc("/js/MyProfilePage.js")
        );
    }

    @Override
    protected MainTag createMain() throws Exception {
        UserAccount userAccount = userService.getCurrentUser();

        return main().withClass("container").with(
                div().withClass("row").with(
                        div().withClass("col s12").with(
                                h4().withClass("center-align").withText("个人资料"),
                                ImageUploadAndPreview.imageUploadAndPreview("avatar", "头像", "150px", "150px", userAccount.getAvatar()),
                                Input.getInput(Input.INPUT_WIDTH_FULL, "nickName", "昵称", Input.TYPE_TEXT, false),
                                Input.getInput(Input.INPUT_WIDTH_FULL, "email", "电子邮件", Input.TYPE_EMAIL, false)

                        )
                )
        );

    }

    @Override
    protected String getThemeColor() throws Exception {
        if(StpUtil.isLogin()){
            return userService.getCurrentUser().getThemeColor();
        }
        return "";
    }

}
