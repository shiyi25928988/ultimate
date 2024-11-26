package yi.shi.pages;

import j2html.tags.Tag;
import j2html.tags.specialized.BodyTag;
import j2html.tags.specialized.FooterTag;
import j2html.tags.specialized.HeadTag;
import j2html.tags.specialized.HeaderTag;

import static j2html.TagCreator.html;

public abstract class Page {

    Tag createHtml() {
        return html(createHead(), createHeader(), createBody(), createFooter());
    }

    abstract HeadTag createHead();

    abstract HeaderTag createHeader();

    abstract BodyTag createBody();

    abstract FooterTag createFooter();
}
