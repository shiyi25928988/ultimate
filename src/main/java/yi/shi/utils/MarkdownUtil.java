package yi.shi.utils;

import j2html.tags.specialized.LiTag;
import org.commonmark.Extension;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.ext.heading.anchor.HeadingAnchorExtension;
import org.commonmark.ext.heading.anchor.IdGenerator;
import org.commonmark.ext.heading.anchor.internal.HeadingIdAttributeProvider;
import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.AttributeProvider;
import org.commonmark.renderer.html.AttributeProviderContext;
import org.commonmark.renderer.html.AttributeProviderFactory;
import org.commonmark.renderer.html.HtmlRenderer;

import java.util.*;

import static j2html.TagCreator.*;

public class MarkdownUtil {

    public static String generateToc(String markdown) {
        List<Extension> extensionList = Arrays.asList(TablesExtension.create(),HeadingAnchorExtension.create());
        Parser parser = Parser.builder()
                .extensions(extensionList)
                .build();
        Node document = parser.parse(markdown);
        List<Heading> headings = new ArrayList<>();
        document.accept(new AbstractVisitor() {
            @Override
            public void visit(Heading heading) {
                headings.add(heading);
                super.visit(heading);
            }
        });
        return ulTag(headings);
    }

    private static String ulTag(List<Heading> headings){
        return ul().with(liTags(headings)).render();
    }

    private static LiTag[] liTags(List<Heading> headings) {
        LiTag[] liTags = new LiTag[headings.size()];
        IdGenerator idGenerator = IdGenerator.builder().defaultId("anchor").prefix("").suffix("").build();
        for (int i = 0; i < headings.size(); i++) {
            int level = headings.get(i).getLevel();
            String id = idGenerator.generateId(headings.get(i).getFirstChild().toString()).replace("textliteral", "");
            LiTag liTag = li().with(a().withText(id).withHref("#" + id)).withClass("md-toc-h" + level);
            liTags[i] = liTag;
        }
        return liTags;
    }

    public static String renderMarkdown(String markdown){
        List<Extension> extensionList = Arrays.asList(TablesExtension.create(),HeadingAnchorExtension.create());
        Parser parser = Parser.builder()
                .extensions(extensionList)
                .build();
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder()
                .extensions(extensionList)
                .attributeProviderFactory(attributeProviderContext -> HeadingIdAttributeProvider.create("anchor", "", ""))
                .build();
        return renderer.render(document);
    }


    public static String sharedTokenGenerate(){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 16; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }


}
