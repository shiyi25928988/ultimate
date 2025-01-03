package yi.shi.pages.normal;

import j2html.tags.specialized.*;
import yi.shi.pages.Page;
import yi.shi.pages.element.Footer;
import yi.shi.pages.element.Head;
import yi.shi.pages.element.Header;
import yi.shi.pages.responsive.ResponsiveCard;
import yi.shi.pages.responsive.ResponsiveContainer;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.result.HTML;

import static j2html.TagCreator.*;

@HttpService
public class HomePage extends Page {

    @GET
    @HttpPath(value = "/")
    public HTML homePage() {
        HTML html = new HTML();
        html.setHtmlContent(createHtml().render());
        return html;
    }

    @Override
    protected HeadTag createHead() {
        return Head.createHead("Home");
    }

    @Override
    protected HeaderTag createHeader() {
        return Header.createHeader();
    }

    @Override
    protected BodyTag createBody() {
        return body(
            //ResponsiveNav.create("logo", "title", Menu.getMenu()),
            ResponsiveContainer.create(
                    ResponsiveCard.create("title", "content"),
                    ResponsiveCard.create("title", "content")
                ),
                // 初始化移动端侧边栏的脚本
                script().withText("document.addEventListener('DOMContentLoaded', function() { var elems = document.querySelectorAll('.sidenav'); var instances = M.Sidenav.init(elems); });"));
    }

    @Override
    protected FooterTag createFooter() {
        return Footer.createFooter();
    }
}
