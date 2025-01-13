package yi.shi.pages;

import j2html.tags.specialized.BodyTag;
import j2html.tags.specialized.FooterTag;
import j2html.tags.specialized.HeadTag;
import j2html.tags.specialized.HeaderTag;
import j2html.tags.specialized.HtmlTag;

import static j2html.TagCreator.html;

public abstract class Page {

    protected HtmlTag createHtml() throws Exception{
        return html(createHead(), createHeader(), createBody(), createFooter());
    }

    protected abstract HeadTag createHead() throws Exception;

    protected abstract HeaderTag createHeader() throws Exception;

    protected abstract BodyTag createBody() throws Exception;

    protected abstract FooterTag createFooter() throws Exception;
}
