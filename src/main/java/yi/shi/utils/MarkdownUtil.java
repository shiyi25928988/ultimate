package yi.shi.utils;

import org.commonmark.Extension;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.ext.heading.anchor.HeadingAnchorExtension;
import org.commonmark.node.Code;
import org.commonmark.node.Link;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.AttributeProvider;
import org.commonmark.renderer.html.AttributeProviderContext;
import org.commonmark.renderer.html.AttributeProviderFactory;
import org.commonmark.renderer.html.HtmlRenderer;

import java.util.*;

public class MarkdownUtil {

    public static String markdownToHtml(String markdown){
        Parser parser = Parser.builder().build();
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        return renderer.render(document);
    }

    public static String markdownToHtmlExtensitons(String markdown){
        //h标题生成id
        Set<Extension> headingAnchorExtensions = Collections.singleton(HeadingAnchorExtension.create());
        //转换table的HTML
        List<Extension> tableExtension = Arrays.asList(TablesExtension.create());
        Parser parser = Parser.builder()
                .extensions(tableExtension)
                .build();
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder()
                .extensions(headingAnchorExtensions)
                .extensions(tableExtension)
                .attributeProviderFactory(attributeProviderContext -> new CustomAttributeProvider())
                .build();
        return renderer.render(document);
    }

    static class CustomAttributeProvider implements AttributeProvider {
        @Override
        public void setAttributes(Node node, String s, Map<String, String> attributes) {
            //改变a标签的target
//            if (node instanceof Link){
//                //attributes.put("class","_blank");
//            }
//            if (node instanceof TableBlock){
//                attributes.put("class","ui celled table");
//            }
            if (node instanceof Code){
                attributes.put("class","code");
            }
        }
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
