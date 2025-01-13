package yi.shi.pages.resources;

import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.MimeType;
import yi.shi.plinth.http.result.BINARY;

@HttpService
public class MaterializeResources {

    public static final String MATERIALIZE_JS = "/META-INF/resources/webjars/materializecss/1.0.0/js/materialize.js";
    public static final String MATERIALIZE_MIN_JS = "/META-INF/resources/webjars/materializecss/1.0.0/js/materialize.min.js";
    public static final String MATERIALIZE_CSS = "/META-INF/resources/webjars/materializecss/1.0.0/css/materialize.css";
    public static final String MATERIALIZE_MIN_CSS = "/META-INF/resources/webjars/materializecss/1.0.0/css/materialize.min.css";

    public static final String ICON_CSS = "/css/icon/icon.css";

    public static final String FLUHRQ6TZZCLQEJ_VDG_IUIADSNC_WOFF2 = "/css/fonts/flUhRq6tzZclQEJ-Vdg-IuiaDsNc.woff2";

    @GET
    @HttpPath(value = MATERIALIZE_JS)
    public BINARY materializeJs() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.APPLICATION_JAVASCRIPT);
        result.setData(this.getClass().getResourceAsStream(MATERIALIZE_JS));
        return result;
    }

    @GET
    @HttpPath(value = MATERIALIZE_MIN_JS)
    public BINARY materializeMinJs() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.APPLICATION_JAVASCRIPT);
        result.setData(this.getClass().getResourceAsStream(MATERIALIZE_MIN_JS));
        return result;
    }

    @GET
    @HttpPath(value = MATERIALIZE_CSS)
    public BINARY materializeCss() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.TEXT_CSS);
        result.setData(this.getClass().getResourceAsStream(MATERIALIZE_CSS));
        return result;
    }

    @GET
    @HttpPath(value = MATERIALIZE_MIN_CSS)
    public BINARY materializeMinCss() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.TEXT_CSS);
        result.setData(this.getClass().getResourceAsStream(MATERIALIZE_MIN_CSS));
        return result;
    }

    @GET
    @HttpPath(value = ICON_CSS)
    public BINARY iconCss() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.TEXT_CSS);
        result.setData(this.getClass().getResourceAsStream(ICON_CSS));
        return result;
    }

    @GET
    @HttpPath(value = FLUHRQ6TZZCLQEJ_VDG_IUIADSNC_WOFF2)
    public BINARY fontWoff2() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.ALL);
        result.setData(this.getClass().getResourceAsStream(FLUHRQ6TZZCLQEJ_VDG_IUIADSNC_WOFF2));
        return result;
    }

}
