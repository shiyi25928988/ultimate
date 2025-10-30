package yi.shi.view.element.button;

import j2html.tags.specialized.DivTag;
import yi.shi.view.element.Icon;

import static j2html.TagCreator.*;

public class FloatingActionButton {

    public static DivTag createFloatingActionButton() {
        return div().withClass("fixed-action-btn").with(
            a().withClass("btn-floating btn-large waves-effect waves-light red").with(
                i().withClass("large material-icons").withText("add")
            ),//.attr("onclick", onClickFunction),
            ul().with(
                li().with(
                    a().withClass("btn-floating waves-effect waves-light red").with(Icon.icon("insert_chart"))
                )
            )
        ).with(script(
                """
                    document.addEventListener('DOMContentLoaded', function() {
                        var elems = document.querySelectorAll('.fixed-action-btn');
                        var instances = M.FloatingActionButton.init(elems, {
                            direction: 'left',
                            hoverEnabled: false
                        });
                    });
                """));
    }
}
