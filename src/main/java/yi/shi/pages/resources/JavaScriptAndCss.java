package yi.shi.pages.resources;

import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.MimeType;
import yi.shi.plinth.http.result.BINARY;

@HttpService
public class JavaScriptAndCss {

    private static final String JQUERY_JS = "/META-INF/resources/webjars/jquery/3.7.1/dist/jquery.js";
    private static final String JQUERY_MIN_JS = "/META-INF/resources/webjars/jquery/3.7.1/dist/jquery.min.js";
    private static final String JQUERY_MIN_MAP = "/META-INF/resources/webjars/jquery/3.7.1/dist/jquery.min.map";
    private static final String JQUERY_SLIM_JS = "/META-INF/resources/webjars/jquery/3.7.1/dist/jquery.slim.js";
    private static final String JQUERY_SLIM_MIN_JS = "/META-INF/resources/webjars/jquery/3.7.1/dist/jquery.slim.min.js";
    private static final String JQUERY_SLIM_MIN_MAP = "/META-INF/resources/webjars/jquery/3.7.1/dist/jquery.slim.min.map";
    private static final String MATERIALIZE_JS = "/META-INF/resources/webjars/materializecss/1.0.0/js/materialize.js";
    private static final String MATERIALIZE_MIN_JS = "/META-INF/resources/webjars/materializecss/1.0.0/js/materialize.min.js";
    private static final String MATERIALIZE_CSS = "/META-INF/resources/webjars/materializecss/1.0.0/css/materialize.css";
    private static final String MATERIALIZE_MIN_CSS = "/META-INF/resources/webjars/materializecss/1.0.0/css/materialize.min.css";
    private static final String TOASTIFY_JS = "/META-INF/resources/webjars/toastify-js/src/toastify.js";
    private static final String TOASTIFY_CSS = "/META-INF/resources/webjars/toastify-js/src/toastify.css";

    @GET
    @HttpPath(value = "/js/jquery.min.js")
    public BINARY jqueryMinJs() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.APPLICATION_JAVASCRIPT);
        result.setData(this.getClass().getResourceAsStream(JQUERY_MIN_JS));
        return result;
    }

    @GET
    @HttpPath(value = "/js/materialize.min.js")
    public BINARY materializeMinJs() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.APPLICATION_JAVASCRIPT);
        result.setData(this.getClass().getResourceAsStream(MATERIALIZE_MIN_JS));
        return result;
    }

    @GET
    @HttpPath(value = "/js/toastify.js")
    public BINARY toastifyJs() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.APPLICATION_JAVASCRIPT);
        result.setData(this.getClass().getResourceAsStream(TOASTIFY_JS));
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
    @HttpPath(value = "/css/materialize.min.css")
    public BINARY materializeMinCss() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.TEXT_CSS);
        result.setData(this.getClass().getResourceAsStream(MATERIALIZE_MIN_CSS));
        return result;
    }

    @GET
    @HttpPath(value = "/css/toastify.css")
    public BINARY toastifyMinCss() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.TEXT_CSS);
        result.setData(this.getClass().getResourceAsStream(TOASTIFY_CSS));
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
