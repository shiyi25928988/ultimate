package yi.shi.pages.resources;

import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.MimeType;
import yi.shi.plinth.http.result.BINARY;

@HttpService
public class HighLightResources {

    public static final String HIGHLIGHT_JS = "/META-INF/resources/webjars/highlightjs/11.10.0/highlight.js";

    public static final String HIGHLIGHT_MIN_JS = "/META-INF/resources/webjars/highlightjs/11.10.0/highlight.min.js";

    @GET
    @HttpPath(value = HIGHLIGHT_JS)
    public BINARY highlightJs() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.APPLICATION_JAVASCRIPT);
        result.setData(this.getClass().getResourceAsStream(HIGHLIGHT_JS));
        return result;
    }

    @GET
    @HttpPath(value = HIGHLIGHT_MIN_JS)
    public BINARY highlightMinJs() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.TEXT_CSS);
        result.setData(this.getClass().getResourceAsStream(HIGHLIGHT_MIN_JS));
        return result;
    }
}
