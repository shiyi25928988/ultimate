package yi.shi.view;

import j2html.tags.specialized.*;
import yi.shi.view.base.Footer;
import yi.shi.view.base.Header;
import yi.shi.view.element.BusyIndicator;

import static j2html.TagCreator.*;

public abstract class Page {

    protected String themeColor = "";

    protected void setThemeColor(String themeColor) {
        this.themeColor = themeColor;
    }

    protected HtmlTag createHtml() throws Exception{
        return html(createHead(), createBody());
    }

    protected abstract HeadTag createHead() throws Exception;

    protected HeaderTag createHeader() throws Exception{
        return Header.createHeader(getThemeColor());
    }

    protected abstract MainTag createMain() throws Exception;

    protected FooterTag createFooter() throws Exception{
        return Footer.createFooter(getThemeColor());
    }

    private String getThemeColor() throws Exception {
        return themeColor;
    }

    protected BodyTag createBody() throws Exception{
        return body().with(
                BusyIndicator.getBusyIndicator(),
                script().withSrc("/js/Init.js"),
                createHeader(),
                createMain(),
                createFooter()
        ).with(
                style("  body {\n" +
                        "    display: flex;\n" +
                        "    min-height: 100vh;\n" +
                        "    flex-direction: column;\n" +
                        "  }\n" +
                        "\n" +
                        "  main {\n" +
                        "    flex: 1 0 auto;\n" +
                        "  }")
        );
    }
}
