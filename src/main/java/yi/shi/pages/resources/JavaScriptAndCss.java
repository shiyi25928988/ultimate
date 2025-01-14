package yi.shi.pages.resources;

import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.MimeType;
import yi.shi.plinth.http.result.BINARY;

@HttpService
public class JavaScriptAndCss {

    @GET
    @HttpPath(value = "/js/SearchBooks.js")
    public BINARY searchBooksJS() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.APPLICATION_JAVASCRIPT);
        result.setData(this.getClass().getResourceAsStream("/js/SearchBooks.js"));
        return result;
    }

    @GET
    @HttpPath(value = "/js/AddNewBook.js")
    public BINARY addNewBookJS() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.APPLICATION_JAVASCRIPT);
        result.setData(this.getClass().getResourceAsStream("/js/AddNewBook.js"));
        return result;
    }

}
