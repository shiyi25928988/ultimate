package yi.shi.pages.resources;

import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.MimeType;
import yi.shi.plinth.http.result.BINARY;

@HttpService
public class BootstrapResources {
    public static final String BOOTSTRAP_CSS = "/css/bootstrap/bootstrap.css";
    public static final String BOOTSTRAP_RTL_CSS = "/css/bootstrap/bootstrap.rtl.css";
    public static final String BOOTSTRAP_GRID_CSS = "/css/bootstrap/bootstrap-grid.css";

    public static final String BOOTSTRAP_JS = "/js/bootstrap/bootstrap.js";
    public static final String BOOTSTRAP_BUNDLE_JS = "/js/bootstrap/bootstrap.bundle.js";
    public static final String BOOTSTRAP_ESM_JS = "/js/bootstrap/bootstrap.esm.js";

    @GET
    @HttpPath(value = BOOTSTRAP_CSS)
    public BINARY bootstrapCss() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.TEXT_CSS);
        result.setData(this.getClass().getResourceAsStream(BOOTSTRAP_CSS));
        return result;
    }

    @GET
    @HttpPath(value = BOOTSTRAP_RTL_CSS)
    public BINARY bootstrapRtlCss() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.TEXT_CSS);
        result.setData(this.getClass().getResourceAsStream(BOOTSTRAP_RTL_CSS));
        return result;
    }

    @GET
    @HttpPath(value = BOOTSTRAP_GRID_CSS)
    public BINARY bootstrapGridCss() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.TEXT_CSS);
        result.setData(this.getClass().getResourceAsStream(BOOTSTRAP_GRID_CSS));
        return result;
    }

    @GET
    @HttpPath(value = BOOTSTRAP_JS)
    public BINARY bootstrapJs() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.APPLICATION_JAVASCRIPT);
        result.setData(this.getClass().getResourceAsStream(BOOTSTRAP_JS));
        return result;
    }

    @GET
    @HttpPath(value = BOOTSTRAP_BUNDLE_JS)
    public BINARY bootstrapBundleJs() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.APPLICATION_JAVASCRIPT);
        result.setData(this.getClass().getResourceAsStream(BOOTSTRAP_BUNDLE_JS));
        return result;
    }

    @GET
    @HttpPath(value = BOOTSTRAP_ESM_JS)
    public BINARY bootstrapEsmJs() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.APPLICATION_JAVASCRIPT);
        result.setData(this.getClass().getResourceAsStream(BOOTSTRAP_ESM_JS));
        return result;
    }
}
