package yi.shi.pages.component.input;

import j2html.tags.specialized.FormTag;

import static j2html.TagCreator.*;

public class SearchInput {

    public static FormTag searchForm(){
        return form().withClass("right").with(
                div().withClass("input-field").with(
                        input().withType("search").withId("search").withPlaceholder("Search books...").attr("aria-label", "Search"),
                        label().withFor("search").with(
                                i().withClass("material-icons").withText("search")
                        ),
                        i().withClass("material-icons").withText("search").attr("onclick", "searchBooks()")
                ),
                script().withSrc("/js/SearchBooks.js")
        );
    }

}
