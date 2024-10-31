package yi.shi.pages.resources;

import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.MimeType;
import yi.shi.plinth.http.result.BINARY;

@HttpService
public class JavaScript {

    @GET
    @HttpPath(value = "/js/jquery.min.js")
    public BINARY jquery() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.TEXT_CSS);
        result.setData(this.getClass().getResourceAsStream("/static/js/jquery.min.js"));
        return result;
    }

    @GET
    @HttpPath(value = "/js/materialize.min.js")
    public BINARY materialize() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.TEXT_CSS);
        result.setData(this.getClass().getResourceAsStream("/static/js/materialize.min.js"));
        return result;
    }
}
