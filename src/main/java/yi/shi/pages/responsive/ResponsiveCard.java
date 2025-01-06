package yi.shi.pages.responsive;

import static j2html.TagCreator.*;

import j2html.tags.specialized.ATag;
import j2html.tags.specialized.DivTag;
import yi.shi.db.model.MarkdownFiles;

public class ResponsiveCard {
    
    
    public static ATag create(MarkdownFiles markdownFiles) {
        return a().withHref("/page/markdown?id=" + markdownFiles.getId())
                .with(div().withClass("card").with(
                        div().withClass("card-content")
                                .with(
                                        span().withClass("card-title").withText(markdownFiles.getTitle()),
                                        img().withSrc(markdownFiles.getCoverUrl()).withStyle("width: 130px; height: auto;"),
                                        p().withText(markdownFiles.getContent())
                                )
                )).withTarget("_blank");
    }
}
