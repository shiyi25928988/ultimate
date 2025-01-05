package yi.shi.pages.resources;


import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.MimeType;
import yi.shi.plinth.http.result.BINARY;

@HttpService
public class MarkdownResources {

    public static final String FONT_AWESOME_CSS = "/css/markdown/font-awesome.min.css";

    public static final String GITHUB_GIST_CSS = "/css/markdown/github-gist.min.css";
    public static final String FONTAWESOME_WEBFONT_TTF = "/css/fonts/fontawesome-webfont.ttf";
    public static final String FONTAWESOME_WEBFONT_WOFF = "/css/fonts/fontawesome-webfont.woff";
    public static final String FONTAWESOME_WEBFONT_WOFF2 = "/css/fonts/fontawesome-webfont.woff2";

    @GET
    @HttpPath(value = FONTAWESOME_WEBFONT_TTF)
    public BINARY fontawesome_webfont_ttf() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.ALL);
        result.setData(this.getClass().getResourceAsStream(FONTAWESOME_WEBFONT_TTF));
        return result;
    }
    @GET
    @HttpPath(value = FONTAWESOME_WEBFONT_WOFF)
    public BINARY fontawesome_webfont_woff() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.ALL);
        result.setData(this.getClass().getResourceAsStream(FONTAWESOME_WEBFONT_WOFF));
        return result;
    }
    @GET
    @HttpPath(value = FONTAWESOME_WEBFONT_WOFF2)
    public BINARY fontawesome_webfont_woff2() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.ALL);
        result.setData(this.getClass().getResourceAsStream(FONTAWESOME_WEBFONT_WOFF2));
        return result;
    }

    @GET
    @HttpPath(value = FONT_AWESOME_CSS)
    public BINARY fontAwesomeCss() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.TEXT_CSS);
        result.setData(this.getClass().getResourceAsStream(FONT_AWESOME_CSS));
        return result;
    }

    @GET
    @HttpPath(value = GITHUB_GIST_CSS)
    public BINARY githubGistCss() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.TEXT_CSS);
        result.setData(this.getClass().getResourceAsStream(GITHUB_GIST_CSS));
        return result;
    }

    @GET
    @HttpPath(value = "/css/typora.css")
    public BINARY typoraCss() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.TEXT_CSS);
        result.setData(this.getClass().getResourceAsStream("/static/css/typora.css"));
        return result;
    }

    @GET
    @HttpPath(value = "/css/typo.css")
    public BINARY typoCss() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.TEXT_CSS);
        result.setData(this.getClass().getResourceAsStream("/static/css/typo.css"));
        return result;
    }

    @GET
    @HttpPath(value = "/css/MathJax_Main.woff2.ttf")
    public BINARY MathJax_Main() throws Exception {
        BINARY result = new BINARY();
        result.setMimeType(MimeType.ALL);
        result.setData(this.getClass().getResourceAsStream("/static/css/MathJax_Main.woff2.ttf"));
        return result;
    }
}
