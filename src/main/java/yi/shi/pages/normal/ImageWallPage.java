package yi.shi.pages.normal;

import cn.dev33.satoken.stp.StpUtil;
import com.google.inject.Inject;
import j2html.tags.specialized.*;
import yi.shi.db.model.UserAccount;
import yi.shi.pages.Page;
import yi.shi.pages.element.card.ImageCard;
import yi.shi.pages.component.Footer;
import yi.shi.pages.component.Head;
import yi.shi.pages.component.Header;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.result.HTML;
import yi.shi.service.ImageService;
import yi.shi.service.UserService;

import java.util.List;

import static j2html.TagCreator.*;

@HttpService
public class ImageWallPage extends Page {

    @Inject
    ImageService imageService;

    @Inject
    UserService userService;

    @GET
    //@AUTH(authUrl = "/page/login")
    @HttpPath(value = "/page/imageWall")
    public HTML imageWallPage() throws Exception {
        HTML html = new HTML();
        html.setHtmlContent(createHtml().render());
        return html;
    }

    @Override
    protected HeadTag createHead() throws Exception {
        return Head.createHead("图片墙");
    }

    @Override
    protected MainTag createMain() throws Exception {
        List<String> imageUrls = imageService.getImageList();
        return main().with(
                div(
                    div(div().withId("image-wall").withClass("row").with(
                        ImageCard.createImageCards(imageUrls)
                    ))
                ).withClass("container section"),
                script().withSrc("/js/ImageWall.js")
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
