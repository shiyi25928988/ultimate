package yi.shi.pages;

import j2html.tags.Tag;
import j2html.tags.specialized.BodyTag;
import j2html.tags.specialized.FooterTag;
import j2html.tags.specialized.HeadTag;
import j2html.tags.specialized.HeaderTag;

import static j2html.TagCreator.html;

public abstract class Page {

    protected Tag createHtml() {
        return html(createHead(), createHeader(), createBody(), createFooter());
    }

    protected abstract HeadTag createHead();

    protected abstract HeaderTag createHeader();

    protected abstract BodyTag createBody();

    protected abstract FooterTag createFooter();
}
