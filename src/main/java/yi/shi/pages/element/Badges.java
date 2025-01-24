package yi.shi.pages.element;

import j2html.tags.specialized.DivTag;

import java.util.Map;
import java.util.Objects;

import static j2html.TagCreator.div;

public class Badges {

    public static DivTag getCollections(Map<String, String> collections) {
        if (Objects.isNull(collections)) {
            return div();
        }

        return div();
    }
}
