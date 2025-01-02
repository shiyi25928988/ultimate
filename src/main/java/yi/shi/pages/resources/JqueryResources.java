package yi.shi.pages.resources;

import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.MimeType;
import yi.shi.plinth.http.result.BINARY;

@HttpService
public class JqueryResources {

    public static final String JQUERY_JS = "/META-INF/resources/webjars/jquery/3.7.1/dist/jquery.js";
    public static final String JQUERY_MIN_JS = "/META-INF/resources/webjars/jquery/3.7.1/dist/jquery.min.js";
    public static final String JQUERY_SLIM_JS = "/META-INF/resources/webjars/jquery/3.7.1/dist/jquery.slim.js";
    public static final String JQUERY_SLIM_MIN_JS = "/META-INF/resources/webjars/jquery/3.7.1/dist/jquery.slim.min.js";

    @GET
    @HttpPath(value = JQUERY_JS)
    public BINARY jqueryJs() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.APPLICATION_JAVASCRIPT);
        result.setData(this.getClass().getResourceAsStream(JQUERY_JS));
        return result;
    }

    @GET
    @HttpPath(value = JQUERY_MIN_JS)
    public BINARY jqueryMinJs() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.APPLICATION_JAVASCRIPT);
        result.setData(this.getClass().getResourceAsStream(JQUERY_MIN_JS));
        return result;
    }

    @GET
    @HttpPath(value = JQUERY_SLIM_JS)
    public BINARY jquerySlimJs() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.APPLICATION_JAVASCRIPT);
        result.setData(this.getClass().getResourceAsStream(JQUERY_SLIM_JS));
        return result;
    }

    @GET
    @HttpPath(value = JQUERY_SLIM_MIN_JS)
    public BINARY jquerySlimMinJs() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.APPLICATION_JAVASCRIPT);
        result.setData(this.getClass().getResourceAsStream(JQUERY_SLIM_MIN_JS));
        return result;
    }

}
