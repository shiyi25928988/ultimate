package yi.shi.pages.element;

import j2html.tags.ContainerTag;
import j2html.tags.specialized.*;

import java.util.Map;

import static j2html.TagCreator.*;

public class SideBar {
    public static DivTag generateSidebar(Map<String, String> buttons) {
        // 创建一个 div 容器，用于包裹整个侧边栏
        DivTag sidebar = div().withClass("sidebar");

        // 创建一个按钮，用于切换侧边栏的显示状态
        ButtonTag toggleButton = button("☰").withClass("toggle-button").attr("onclick", "toggleSidebar()");

        // 创建一个 ul 列表，用于存放按钮
        UlTag buttonList = ul().withClass("button-list");

        // 遍历 map，为每个键值对生成一个按钮
        buttons.forEach((key, value) -> {
            LiTag buttonItem = li(
                    a(value).withHref(key)
            ).withClass("button-item");
            buttonList.with(buttonItem);
        });

        // 将按钮列表添加到侧边栏容器中
        sidebar.with(toggleButton, buttonList).withStyle("/* 基本样式 */\n" +
                ".sidebar {\n" +
                "    height: 100%;\n" +
                "    width: 0;\n" +
                "    position: fixed;\n" +
                "    z-index: 1;\n" +
                "    top: 0;\n" +
                "    left: 0;\n" +
                "    background-color: #111;\n" +
                "    overflow-x: hidden;\n" +
                "    transition: 0.5s;\n" +
                "    padding-top: 60px;\n" +
                "}\n" +
                "\n" +
                ".sidebar .button-list {\n" +
                "    list-style-type: none;\n" +
                "    padding: 0;\n" +
                "}\n" +
                "\n" +
                ".sidebar .button-item {\n" +
                "    padding: 8px 8px 8px 32px;\n" +
                "    text-decoration: none;\n" +
                "    font-size: 25px;\n" +
                "    color: #818181;\n" +
                "    display: block;\n" +
                "    transition: 0.3s;\n" +
                "}\n" +
                "\n" +
                ".sidebar .button-item:hover {\n" +
                "    color: #f1f1f1;\n" +
                "}\n" +
                "\n" +
                ".toggle-button {\n" +
                "    position: absolute;\n" +
                "    top: 20px;\n" +
                "    left: 20px;\n" +
                "    font-size: 30px;\n" +
                "    cursor: pointer;\n" +
                "}\n");

        return sidebar;
    }

}
