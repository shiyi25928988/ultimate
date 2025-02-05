package yi.shi.pages.normal;

import cn.dev33.satoken.stp.StpUtil;
import com.google.inject.Inject;
import j2html.tags.specialized.*;
import yi.shi.db.model.MarkdownFiles;
import yi.shi.db.model.UserAccount;
import yi.shi.pages.Page;
import yi.shi.pages.component.Footer;
import yi.shi.pages.component.Head;
import yi.shi.pages.component.Header;
import yi.shi.pages.element.card.MarkDownCard;
import yi.shi.pages.component.Container;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.result.HTML;
import yi.shi.service.MarkdownFilesService;
import yi.shi.service.UserService;

import java.util.ArrayList;
import java.util.List;

import static j2html.TagCreator.*;

@HttpService
public class HomePage extends Page {

    @Inject
    MarkdownFilesService markdownFilesService;

    @Inject
    UserService userService;

    @GET
    @HttpPath(value = "/")
    public HTML homePage() throws Exception {
        HTML html = new HTML();
        html.setHtmlContent(createHtml().render());
        return html;
    }

    @Override
    protected HeadTag createHead() {
        return Head.createHead("Home");
    }

    @Override
    protected MainTag createMain() {
        return main(
            //ResponsiveNav.create("logo", "title", Menu.getMenu()),
            Container.create(getCardsArray())
        ).withClass("grey lighten-4");
                // 初始化移动端侧边栏的脚本
                //script().withText("document.addEventListener('DOMContentLoaded', function() { var elems = document.querySelectorAll('.sidenav'); var instances = M.Sidenav.init(elems); });"));
    }

    private ATag[] getCardsArray(){
        ATag[] cards = new ATag[0];
        List<ATag> list = new ArrayList<>();
        List<MarkdownFiles> mdList = this.markdownFilesService.getAllMarkdownFiles();
        mdList.forEach(markdownFiles -> {
            list.add(MarkDownCard.create(markdownFiles));
        });
        return list.toArray(cards);
    }

    @Override
    protected String getThemeColor() throws Exception {
        if(StpUtil.isLogin()){
            return userService.getCurrentUser().getThemeColor();
        }
        return "";
    }
}
