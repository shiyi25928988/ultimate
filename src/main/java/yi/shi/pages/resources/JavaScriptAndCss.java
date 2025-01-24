package yi.shi.pages.resources;

import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.MimeType;
import yi.shi.plinth.http.result.BINARY;

@HttpService
public class JavaScriptAndCss {

    @GET
    @HttpPath(value = "/js/SideNav.js")
    public BINARY sideNavJS() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.APPLICATION_JAVASCRIPT);
        result.setData(this.getClass().getResourceAsStream("/js/SideNav.js"));
        return result;
    }

    @GET
    @HttpPath(value = "/js/ImageWall.js")
    public BINARY materializeCSS() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.APPLICATION_JAVASCRIPT);
        result.setData(this.getClass().getResourceAsStream("/js/ImageWall.js"));
        return result;
    }
    @GET
    @HttpPath(value = "/js/Carousel.js")
    public BINARY carouselJS() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.APPLICATION_JAVASCRIPT);
        result.setData(this.getClass().getResourceAsStream("/js/Carousel.js"));
        return result;
    }
    @GET
    @HttpPath(value = "/js/Init.js")
    public BINARY init() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.APPLICATION_JAVASCRIPT);
        result.setData(this.getClass().getResourceAsStream("/js/Init.js"));
        return result;
    }

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

    @GET
    @HttpPath(value = "/js/UploadCoverImage.js")
    public BINARY uploadCoverImage() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.APPLICATION_JAVASCRIPT);
        result.setData(this.getClass().getResourceAsStream("/js/UploadCoverImage.js"));
        return result;
    }

}
