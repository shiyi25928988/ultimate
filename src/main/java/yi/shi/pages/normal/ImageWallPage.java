package yi.shi.pages.normal;

import j2html.tags.Tag;
import j2html.tags.specialized.HtmlTag;
import j2html.tags.specialized.ScriptTag;
import yi.shi.pages.element.Footer;
import yi.shi.pages.element.Head;
import yi.shi.pages.element.Header;
import yi.shi.plinth.annotation.auth.AUTH;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.result.HTML;

import static j2html.TagCreator.*;

@HttpService
public class ImageWallPage {

    @GET
    //@AUTH(authUrl = "/page/login")
    @HttpPath(value = "/page/imageWall")
    public HTML imageWallPage() throws Exception {
        HTML html = new HTML();
        html.setHtmlContent(page().render());
        return html;
    }

    private Tag page(){

        return createImageWallPage();
    }

    public static HtmlTag createImageWallPage() {
        // 创建 HTML 结构
        HtmlTag html = html(
                Head.createHead("图片墙"),
                Header.createHeader(),
                body(
                        div(
                                //h1("Image Wall"),
                                div(div().withId("image-wall").withClass("row"))
                        ).withClass("container section"),
                        createScript()
                ).withClass("grey lighten-4"),
                Footer.createFooter()
        );

        return html;
    }
    private static ScriptTag createScript() {
        return script("$(document).ready(function() {\n" +
                "                // 调用 /api/getImages 接口\n" +
                "                $.ajax({\n" +
                "                    url: '/api/getImages',\n" +
                "                    method: 'GET',\n" +
                "                    success: function(data) {\n" +
                "                        // 清空现有的图片墙\n" +
                "                        $('#image-wall').empty();\n" +
                "\n" +
                "                        // 生成图片墙\n" +
                "                        data.forEach(function(image) {\n" +
                "                            var imgHtml = '<div class=\"col s12 m6 l4\">' +\n" +
                "                                          '  <img src=\"' + image.url + '\" class=\"responsive-img materialboxed\" />' +\n" +
                "                                          '</div>';\n" +
                "                            $('#image-wall').append(imgHtml);\n" +
                "                        });\n" +
                "\n" +
                "                        // 初始化 Materialize 的图片放大功能\n" +
                "                        $('.materialboxed').materialbox();\n" +
                "                    },\n" +
                "                    error: function(error) {\n" +
                "                        console.error('Error fetching images:', error);\n" +
                "                    }\n" +
                "                });\n" +
                "            });");
    }
}
