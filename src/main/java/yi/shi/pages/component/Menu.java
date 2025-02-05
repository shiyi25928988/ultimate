package yi.shi.pages.component;

import cn.dev33.satoken.stp.StpUtil;

import java.util.LinkedHashMap;
import java.util.Map;

public class Menu {
    private static final Map<String, String> USER_MENU = new LinkedHashMap<>();
    private static final Map<String, String> ADMIN_MENU = new LinkedHashMap<>();
    static {
        USER_MENU.put("Home", "/");
        USER_MENU.put("Books", "/page/booksQueryPage");
        USER_MENU.put("Add Book", "/page/editNewBook");
        USER_MENU.put("editor", "/page/markdownEditor");
        USER_MENU.put("images", "/page/imageWall");
        USER_MENU.put("Profile", "/page/myProfile");

        //USER_MENU.put("Logout", "/api/logout");
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
        if(StpUtil.isLogin()){
            USER_MENU.put("SignOut", "/api/logout");
            USER_MENU.remove("SignIn");
        }else{
            USER_MENU.put("SignIn", "/page/login");
            USER_MENU.remove("SignOut");
        }
//        if (StpUtil.hasRole("admin")) {
//            return ADMIN_MENU;
//        }
        return USER_MENU;
    }
}
