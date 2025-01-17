package yi.shi.pages.component;

import j2html.tags.specialized.DivTag;
import j2html.tags.specialized.UlTag;

import java.util.Map;

import static j2html.TagCreator.*;

public class Dropdown {

    public static DivTag getMenuDropdown(String name, String icon, Map<String, String> dropdownItems) {
        return div().with(
                a().withClass("dropdown-trigger").withText(name).withHref("#").attr("data-target", "dropdown").with(
                        i().withClass("material-icons right").withText(icon)
                ),
                getDropdownItems(dropdownItems),
                script("$('.dropdown-trigger').dropdown()")
        );
    }

    private static UlTag getDropdownItems(Map<String, String> dropdownItems) {
        UlTag dropdownItemsTag = ul().withClass("dropdown-content").withId("dropdown");
        for (Map.Entry<String, String> entry : dropdownItems.entrySet()) {
            dropdownItemsTag.with(
                    li().with(
                            a().withHref(entry.getValue()).withText(entry.getKey())
                    )
            );
        }
        return dropdownItemsTag;
    }

}
