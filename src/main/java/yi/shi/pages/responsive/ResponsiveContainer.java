package yi.shi.pages.responsive;

import static j2html.TagCreator.div;

import j2html.tags.DomContent;
import j2html.tags.specialized.DivTag;

public class ResponsiveContainer {

    public static DivTag create(DomContent...content) {
        return div().withClass("container section")
                .with(
                    div().withClass("row")
                        .with(
                            // 手机端12列，平板6列，桌面4列
                            div().withClass("col s12 m6 l4")
                                .with(content)
                        )
                );
    }

}
