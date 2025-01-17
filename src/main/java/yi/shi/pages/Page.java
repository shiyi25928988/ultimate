package yi.shi.pages;

import j2html.tags.specialized.*;
import yi.shi.pages.component.BusyIndicator;

import static j2html.TagCreator.*;

public abstract class Page {

    protected HtmlTag createHtml() throws Exception{
        return html(createHead(), createBody());
    }

    protected abstract HeadTag createHead() throws Exception;

    protected abstract HeaderTag createHeader() throws Exception;

    protected abstract MainTag createMain() throws Exception;

    protected abstract FooterTag createFooter() throws Exception;


    protected BodyTag createBody() throws Exception{
        return body().with(
                BusyIndicator.getBusyIndicator(),
                script().withSrc("/js/Init.js"),
                createHeader(),
                createMain(),
                createFooter()
        );
    }
}
