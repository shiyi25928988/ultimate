package yi.shi.pages.resources;

import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.MimeType;
import yi.shi.plinth.http.result.BINARY;

@HttpService
public class Css {

    @GET
    @HttpPath(value = "/css/styles.css")
    public BINARY styles() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.TEXT_CSS);
        result.setData(this.getClass().getResourceAsStream("/static/css/styles.css"));
        return result;
    }
    @GET
    @HttpPath(value = "/css/materialize.min.css")
    public BINARY materialize() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.TEXT_CSS);
        result.setData(this.getClass().getResourceAsStream("/static/css/materialize.min.css"));
        return result;
    }
}
