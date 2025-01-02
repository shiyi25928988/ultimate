package yi.shi.pages.resources;

import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.MimeType;
import yi.shi.plinth.http.result.BINARY;

@HttpService
public class SimplemdeResources {

    public static final String SIMPLEMDE_JS = "/META-INF/resources/webjars/simplemde/1.11.2/dist/simplemde.min.js";
    public static final String SIMPLEMDE_CSS = "/META-INF/resources/webjars/simplemde/1.11.2/dist/simplemde.min.css";

    @GET
    @HttpPath(value = SIMPLEMDE_CSS)
    public BINARY simplemdeCss() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.TEXT_CSS);
        result.setData(this.getClass().getResourceAsStream(SIMPLEMDE_CSS));
        return result;
    }

    @GET
    @HttpPath(value = SIMPLEMDE_JS)
    public BINARY simplemdeJs() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.APPLICATION_JAVASCRIPT);
        result.setData(this.getClass().getResourceAsStream(SIMPLEMDE_JS));
        return result;
    }
}
