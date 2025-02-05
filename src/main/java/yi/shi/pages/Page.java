package yi.shi.pages;

import j2html.tags.specialized.*;
import yi.shi.db.model.UserAccount;
import yi.shi.pages.component.Footer;
import yi.shi.pages.component.Header;
import yi.shi.pages.element.BusyIndicator;

import static j2html.TagCreator.*;

public abstract class Page {

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

    protected String getThemeColor() throws Exception {
        return "";
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
