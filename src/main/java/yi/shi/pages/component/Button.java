package yi.shi.pages.component;

import j2html.tags.specialized.ATag;
import j2html.tags.specialized.DivTag;
import j2html.tags.specialized.ITag;

import static j2html.TagCreator.*;

public class Button {

    public static ATag normalButton(String buttonText, String onClickFunction) {
        return a().withClass("btn waves-effect waves-light").withText(buttonText).attr("onclick", onClickFunction);
    }

    public static ATag iconButton(String buttonText, ITag icon) {
        return a().withClass("btn waves-effect waves-light").withText(buttonText).with(icon);
    }

    public static DivTag submitButton(String text) {
        return div().withClass("row").with(
                button()
                .withType("submit")
                .withClass("btn waves-effect waves-light").withName("action").withText(text).with(
                        Icon.icon("send", Icon.RIGHT)
                )
            );
    }
}
