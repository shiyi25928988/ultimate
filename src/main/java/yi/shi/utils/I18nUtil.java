package yi.shi.utils;

import cn.dev33.satoken.stp.StpUtil;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import yi.shi.plinth.servlet.ServletHelper;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;
@Slf4j
public class I18nUtil {

    private static Map<String, String> localeMap =  new ConcurrentHashMap<>();

    public static void setLocale(String locale){
        if(!StpUtil.isLogin()){
            return;
        }
        localeMap.put(String.valueOf(StpUtil.getLoginId()), locale);
    }


    public static String getMessage(String key){
        Locale locale = null;
        if(!StpUtil.isLogin()){
            locale = getDefaultLocale();
        }else{
            String localeStr = localeMap.get(String.valueOf(StpUtil.getLoginId()));
            if(Strings.isNullOrEmpty(localeStr)){
                locale = getDefaultLocale();
            }else{
                switch (localeStr){
                    case "zh":
                        locale = Locale.CHINA;
                        break;
                    case "en":
                        locale = Locale.ENGLISH;
                        break;
                    case "ja":
                        locale = Locale.JAPAN;
                        break;
                    case "ko":
                        locale = Locale.KOREA;
                        break;
                    case "it":
                        locale = Locale.ITALY;
                        break;
                    case "de":
                        locale = Locale.GERMANY;
                        break;
                    case "fr":
                        locale = Locale.FRANCE;
                        break;
                    default:
                        locale = getDefaultLocale();
                        break;
                }
            }
        }
        try {
//            log.info(ResourceBundle.getBundle("messages", locale).getString(key));
//            String res = new String(ResourceBundle.getBundle("messages", locale).getString(key).getBytes("ISO-8859-1"), "UTF8");
//            log.info("key:{},value:{}", key, res);
            return ResourceBundle.getBundle("messages", locale).getString(key);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Locale getDefaultLocale(){
        return ServletHelper.getRequest().getLocale();
    }


}
