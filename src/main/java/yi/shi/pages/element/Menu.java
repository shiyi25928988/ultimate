package yi.shi.pages.element;

import cn.dev33.satoken.stp.StpUtil;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Menu {
    private static final Map<String, String> USER_MENU = new LinkedHashMap<>();
    private static final Map<String, String> ADMIN_MENU = new LinkedHashMap<>();
    static {
        USER_MENU.put("Home", "/");
        USER_MENU.put("Image", "/page/imageWall");
        USER_MENU.put("Markdown", "/page/markdownEditor");
        USER_MENU.put("Logout", "/api/logout");
    }
    static {
        ADMIN_MENU.put("Home", "/");
        ADMIN_MENU.put("Image", "/page/imageWall");
        ADMIN_MENU.put("Contact", "/contact");
        ADMIN_MENU.put("About", "/about");
        ADMIN_MENU.put("Config", "/about");
        ADMIN_MENU.put("Logout", "/api/logout");
    }
    public static Map<String, String> getMenu() {
//        if (StpUtil.hasRole("admin")) {
//            return ADMIN_MENU;
//        }
        return USER_MENU;
    }
}
