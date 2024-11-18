package yi.shi.pages;

import j2html.tags.Tag;
import j2html.tags.specialized.HtmlTag;
import yi.shi.pages.element.Head;
import yi.shi.pages.element.Header;
import yi.shi.pages.element.SideBar;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.result.HTML;

import java.util.HashMap;
import java.util.Map;

import static j2html.TagCreator.*;

@HttpService
public class HomePage {
    @GET
    @HttpPath(value = "/home")
    public static HTML homePage()
    {
        HTML html = new HTML();
        html.setHtmlContent(generateHomePage().render());
        return html;
    }

    private static Tag generateHomePage(){
            // 创建 HTML 结构
        Map<String, String> map = new HashMap<>();
        map.put("/", "Home");
        map.put("/page/markdownpage?id=0", "Markdown");
        map.put("/page/imagewallpage", "Image Wall");
        map.put("/page/uploadpage", "Upload");
        map.put("/api/logout", "Logout");

        HtmlTag html = html(
                Head.createHead("HOME"),
                Header.createHeader(),
                body(
                        SideBar.generateSidebar(map)
                )
        );
        return html;
    }

}
