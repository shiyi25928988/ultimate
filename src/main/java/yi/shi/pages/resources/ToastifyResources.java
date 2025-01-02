package yi.shi.pages.resources;

import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.MimeType;
import yi.shi.plinth.http.result.BINARY;

@HttpService
public class ToastifyResources {

    public static final String TOASTIFY_JS = "/META-INF/resources/webjars/toastify-js/src/toastify.js";
    public static final String TOASTIFY_CSS = "/META-INF/resources/webjars/toastify-js/src/toastify.css";

    @GET
    @HttpPath(value = TOASTIFY_JS)
    public BINARY toastifyJs() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.APPLICATION_JAVASCRIPT);
        result.setData(this.getClass().getResourceAsStream(TOASTIFY_JS));
        return result;
    }

    @GET
    @HttpPath(value = TOASTIFY_CSS)
    public BINARY toastifyMinCss() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.TEXT_CSS);
        result.setData(this.getClass().getResourceAsStream(TOASTIFY_CSS));
        return result;
    }
}
