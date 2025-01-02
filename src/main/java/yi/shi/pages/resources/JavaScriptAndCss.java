package yi.shi.pages.resources;

import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.MimeType;
import yi.shi.plinth.http.result.BINARY;

@HttpService
public class JavaScriptAndCss {







    @GET
    @HttpPath(value = "/js/sidebar.js")
    public BINARY sidebarjs() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.APPLICATION_JAVASCRIPT);
        result.setData(this.getClass().getResourceAsStream("/static/js/sidebar.js"));
        return result;
    }

    @GET
    @HttpPath(value = "/css/styles.css")
    public BINARY stylesCss() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.TEXT_CSS);
        result.setData(this.getClass().getResourceAsStream("/static/css/styles.css"));
        return result;
    }




    @GET
    @HttpPath(value = "/css/typora.css")
    public BINARY typoraCss() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.TEXT_CSS);
        result.setData(this.getClass().getResourceAsStream("/static/css/typora.css"));
        return result;
    }
}
