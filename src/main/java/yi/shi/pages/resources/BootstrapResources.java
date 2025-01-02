package yi.shi.pages.resources;

import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.MimeType;
import yi.shi.plinth.http.result.BINARY;

@HttpService
public class BootstrapResources {
    public static final String BOOTSTRAP_CSS = "/META-INF/resources/webjars/bootstrap/5.3.3/css/bootstrap.css";
    public static final String BOOTSTRAP_MIN_CSS = "/META-INF/resources/webjars/bootstrap/5.3.3/css/bootstrap.min.css";
    public static final String BOOTSTRAP_GRID_CSS = "/META-INF/resources/webjars/bootstrap/5.3.3/css/bootstrap-grid.css";
    public static final String BOOTSTRAP_GRID_MIN_CSS = "/META-INF/resources/webjars/bootstrap/5.3.3/css/bootstrap-grid.min.css";
    public static final String BOOTSTRAP_REBOOT_CSS = "/META-INF/resources/webjars/bootstrap/5.3.3/css/bootstrap-reboot.css";
    public static final String BOOTSTRAP_REBOOT_MIN_CSS = "/META-INF/resources/webjars/bootstrap/5.3.3/css/bootstrap-reboot.min.css";
    public static final String BOOTSTRAP_UTILITIES_CSS = "/META-INF/resources/webjars/bootstrap/5.3.3/css/bootstrap-utilities.css";
    public static final String BOOTSTRAP_UTILITIES_MIN_CSS = "/META-INF/resources/webjars/bootstrap/5.3.3/css/bootstrap-utilities.min.css";
    public static final String BOOTSTRAP_JS = "/META-INF/resources/webjars/bootstrap/5.3.3/js/bootstrap.js";
    public static final String BOOTSTRAP_MIN_JS = "/META-INF/resources/webjars/bootstrap/5.3.3/js/bootstrap.min.js";
    public static final String BOOTSTRAP_BUNDLE_JS = "/META-INF/resources/webjars/bootstrap/5.3.3/js/bootstrap.bundle.js";
    public static final String BOOTSTRAP_BUNDLE_MIN_JS = "/META-INF/resources/webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js";
    public static final String BOOTSTRAP_ESM_JS = "/META-INF/resources/webjars/bootstrap/5.3.3/js/bootstrap.esm.js";
    public static final String BOOTSTRAP_ESM_MIN_JS = "/META-INF/resources/webjars/bootstrap/5.3.3/js/bootstrap.esm.min.js";

    @GET
    @HttpPath(value = BOOTSTRAP_CSS)
    public BINARY bootstrapCss() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.TEXT_CSS);
        result.setData(this.getClass().getResourceAsStream(BOOTSTRAP_CSS));
        return result;
    }

    @GET
    @HttpPath(value = BOOTSTRAP_MIN_CSS)
    public BINARY bootstrapMinCss() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.TEXT_CSS);
        result.setData(this.getClass().getResourceAsStream(BOOTSTRAP_MIN_CSS));
        return result;
    }

    @GET
    @HttpPath(value = BOOTSTRAP_REBOOT_CSS)
    public BINARY bootstrapRebootCss() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.TEXT_CSS);
        result.setData(this.getClass().getResourceAsStream(BOOTSTRAP_REBOOT_CSS));
        return result;
    }

    @GET
    @HttpPath(value = BOOTSTRAP_REBOOT_MIN_CSS)
    public BINARY bootstrapRebootMinCss() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.TEXT_CSS);
        result.setData(this.getClass().getResourceAsStream(BOOTSTRAP_REBOOT_MIN_CSS));
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
    @HttpPath(value = BOOTSTRAP_GRID_MIN_CSS)
    public BINARY bootstrapGridMinCss() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.TEXT_CSS);
        result.setData(this.getClass().getResourceAsStream(BOOTSTRAP_GRID_MIN_CSS));
        return result;
    }

    @GET
    @HttpPath(value = BOOTSTRAP_UTILITIES_CSS)
    public BINARY bootstrapUtilitiesCss() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.TEXT_CSS);
        result.setData(this.getClass().getResourceAsStream(BOOTSTRAP_UTILITIES_CSS));
        return result;
    }

    @GET
    @HttpPath(value = BOOTSTRAP_UTILITIES_MIN_CSS)
    public BINARY bootstrapUtilitiesMinCss() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.TEXT_CSS);
        result.setData(this.getClass().getResourceAsStream(BOOTSTRAP_UTILITIES_MIN_CSS));
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
    @HttpPath(value = BOOTSTRAP_MIN_JS)
    public BINARY bootstrapMinJs() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.APPLICATION_JAVASCRIPT);
        result.setData(this.getClass().getResourceAsStream(BOOTSTRAP_MIN_JS));
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
    @HttpPath(value = BOOTSTRAP_BUNDLE_MIN_JS)
    public BINARY bootstrapBundleMinJs() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.APPLICATION_JAVASCRIPT);
        result.setData(this.getClass().getResourceAsStream(BOOTSTRAP_BUNDLE_MIN_JS));
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

    @GET
    @HttpPath(value = BOOTSTRAP_ESM_MIN_JS)
    public BINARY bootstrapEsmMinJs() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.APPLICATION_JAVASCRIPT);
        result.setData(this.getClass().getResourceAsStream(BOOTSTRAP_ESM_MIN_JS));
        return result;
    }
}
