package yi.shi.pages.component;

import j2html.tags.specialized.ATag;
import j2html.tags.specialized.DivTag;
import j2html.tags.specialized.ITag;

import static j2html.TagCreator.*;

public class Input {

    public static final String INPUT_WIDTH_FULL = "input-field col s12";
    public static final String INPUT_WIDTH_HALF = "input-field col s6";
    public static final String INPUT_WIDTH_QUARTER = "input-field col s3";

    public static final String TYPE_TEXT = "text";
    public static final String TYPE_NUMBER = "number";
    public static final String TYPE_PASSWORD = "password";
    public static final String TYPE_EMAIL = "email";
    public static final String TYPE_URL = "url";
    public static final String TYPE_TIME = "time";
    public static final String TYPE_DATE = "date";
    public static final String TYPE_DATETIME = "datetime";
    public static final String TYPE_DATETIME_LOCAL = "datetime-local";
    public static final String TYPE_TEL = "tel";
    public static final String TYPE_SEARCH = "search";

    public static DivTag getTextArea(String id, String label, boolean isDisabled) {
        if(isDisabled) {
            return div().withClass("row").with(
                    div().withClass("input-field col s12").with(
                            textarea().isDisabled().withId(id).withClass("materialize-textarea"),
                            label().withFor(id).withText(label)
                    )
            );
        }
        return div().withClass("row").with(
                div().withClass("input-field col s12").with(
                        textarea().withId(id).withClass("materialize-textarea"),
                        label().withFor(id).withText(label)
                )
        );
    }

    public static DivTag getInputWithButton(String width, String id, String label, String type, ATag button, boolean isDisabled) {
        if(isDisabled) {
            return div().withClass("row").with(
                    div().withClass(width).with(
                            input().isDisabled().withId(id).withType(type).withClass("validate"),
                            label().withFor(id).withText(label),
                            button
                    )
            );
        }
        return div().withClass("row").with(
                div().withClass(width).with(
                        input().withId(id).withType(type).withClass("validate"),
                        label().withFor(id).withText(label),
                        button
                )
        );
    }

    public static DivTag getInput(String width, String id, String label, String type, boolean isDisabled) {
        if(isDisabled) {
            return div().withClass("row").with(
                    div().withClass(width).with(
                            input().isDisabled().withId(id).withType(type).withClass("validate"),
                            label().withFor(id).withText(label)
                    )
            );
        }
        return div().withClass("row").with(
                div().withClass(width).with(
                        input().withId(id).withType(type).withClass("validate"),
                        label().withFor(id).withText(label)
                )
        );
    }

    public static DivTag getInputWithIcon(String width, String id, String label, String type, ITag icon, boolean isDisabled) {
        if(isDisabled) {
            return div().withClass("row").with(
                    div().withClass(width).with(
                            icon,
                            input().isDisabled().withId(id).withType(type).withClass("validate"),
                            label().withFor(id).withText(label)
                    )
            );
        }
        return div().withClass("row").with(
                div().withClass(width).with(
                        icon,
                        input().withId(id).withType(type).withClass("validate"),
                        label().withFor(id).withText(label)
                )
        );

    }

}
