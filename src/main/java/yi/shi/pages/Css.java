package yi.shi.pages;

import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.MimeType;
import yi.shi.plinth.http.result.BINARY;

@HttpService
public class Css {

    @GET
    @HttpPath(value = "/styles.css")
    public BINARY styles() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.TEXT_CSS);
        result.setData(this.getClass().getResourceAsStream("/static/css/styles.css"));
        return result;
    }
}
