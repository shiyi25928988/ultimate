package yi.shi.pages.gen;

import j2html.tags.Tag;
import j2html.tags.specialized.HeadTag;
import yi.shi.pages.resources.BootstrapResources;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static j2html.TagCreator.*;

public class HeadGen {

    public static HeadTag generateDefaultHead(String title) {
        return generateHead(title,
                new String[]{BootstrapResources.BOOTSTRAP_CSS},
                new String[]{BootstrapResources.BOOTSTRAP_BUNDLE_JS});
    }
    public static HeadTag generateHead(String title, String[] cssPaths, String[] jsPaths) {
        return head(
                generateHeadTag(title, cssPaths, jsPaths)
        );
    }

    private static Tag[] generateHeadTag(String title, String[] cssPaths, String[] jsPaths) {
        List<Tag> headTags = new ArrayList<>();
        headTags.add(meta().withCharset("UTF-8"));
        headTags.add(meta().withName("viewport").withContent("width=device-width, initial-scale=1"));
        headTags.add(title(title));
        headTags.addAll(generateLinks(cssPaths));
        headTags.addAll(generateScripts(jsPaths));
        return headTags.toArray(new Tag[0]);
    }

    /**
     * 生成多个 <link> 标签。
     *
     * @param cssPaths CSS 文件路径列表
     * @return 生成的 <link> 标签列表
     */
    private static List<Tag> generateLinks(String[] cssPaths) {
        List<Tag> linkTags = new ArrayList<>(cssPaths.length);
        Stream.of(cssPaths).forEach(path -> linkTags.add(link().withRel("stylesheet").withHref(path)));
        return linkTags;
    }

    /**
     * 生成多个 <script> 标签。
     *
     * @param jsPaths JavaScript 文件路径列表
     * @return 生成的 <script> 标签列表
     */
    private static List<Tag> generateScripts(String[] jsPaths) {
        List<Tag> scriptTags = new ArrayList<>(jsPaths.length);
        Stream.of(jsPaths).forEach(path -> scriptTags.add(script().withSrc(path)));
        return scriptTags;
    }
}
