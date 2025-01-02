package yi.shi.pages.normal;

import j2html.tags.specialized.*;
import yi.shi.pages.Page;
import yi.shi.pages.element.Footer;
import yi.shi.pages.element.Menu;
import yi.shi.pages.responsive.ResponsiveCard;
import yi.shi.pages.responsive.ResponsiveContainer;
import yi.shi.pages.responsive.ResponsiveNav;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.result.HTML;

import static j2html.TagCreator.*;

import java.util.HashMap;
import java.util.Map;

@HttpService
public class HomePage extends Page {

    @GET
    @HttpPath(value = "/home")
    public HTML homePage() {
        HTML html = new HTML();
        html.setHtmlContent(createHtml().render());
        return html;
    }

    @Override
    protected HeadTag createHead() {
        return head(
                meta().withCharset("UTF-8"),
                meta().withName("viewport").withContent("width=device-width, initial-scale=1"),
                title("HOME"),
                link().withRel("stylesheet").withHref("/css/materialize.min.css"),
                link().withRel("stylesheet").withHref("/css/toastify.css"),
                script().withSrc("/js/jquery.min.js"),
                script().withSrc("/js/materialize.min.js"),
                script().withSrc("/js/toastify.js")
        );
    }

    @Override
    protected HeaderTag createHeader() {
        return header().withClass("top-bar");
    }

    @Override
    protected BodyTag createBody() {
        return body(
            ResponsiveNav.create("logo", "title", Menu.getMenu()),
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
