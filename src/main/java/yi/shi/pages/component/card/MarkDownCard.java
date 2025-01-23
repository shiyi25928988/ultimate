package yi.shi.pages.component.card;

import static j2html.TagCreator.*;

import com.google.common.base.Strings;
import j2html.tags.specialized.ATag;
import yi.shi.db.model.MarkdownFiles;

public class MarkDownCard {
    
    
    public static ATag create(MarkdownFiles markdownFiles) {
        ATag aTag;
        String content = "";
        if(!Strings.isNullOrEmpty(markdownFiles.getContent())){
            content = stripMarkdown(markdownFiles.getContent());
            if(content.length() > 100){
                content = content.substring(0, 100) + "...";
            }
        }

        if(Strings.isNullOrEmpty(markdownFiles.getCoverUrl())){
            aTag = a().withHref("/page/markdown?id=" + markdownFiles.getId())
                    .with(div().withClass("card").with(
                            div().withClass("card-content")
                                    .with(
                                            span().withClass("card-title").withText(markdownFiles.getTitle()),
                                            p().withText(content)
                                    )
                    )).withTarget("_blank");
        }else{
            aTag = a().withHref("/page/markdown?id=" + markdownFiles.getId())
                    .with(div().withClass("card").with(
                            div().withClass("card-content")
                                    .with(
                                            span().withClass("card-title").withText(markdownFiles.getTitle()),
                                            img().withSrc(markdownFiles.getCoverUrl()).withStyle("width: 130px; height: auto;"),
                                            p().withText(content)
                                    )
                    )).withTarget("_blank");
        }
        return aTag;
    }

    private static String stripMarkdown(String markdown) {
        if (markdown == null) {
            return "";
        }
        // 去除标题
        markdown = markdown.replaceAll("#+\\s+", "");
        // 去除列表
        markdown = markdown.replaceAll("(^|\\s)([*+-]|\\d+\\.)\\s+", "");
        // 去除链接
        markdown = markdown.replaceAll("\\[([^\\]]+)\\]\\([^\\)]+\\)", "$1");
        // 去除图片
        markdown = markdown.replaceAll("!\\[([^\\]]+)\\]\\([^\\)]+\\)", "$1");
        // 去除粗体和斜体
        markdown = markdown.replaceAll("[*_]{1,2}([^*_]+)[*_]{1,2}", "$1");
        // 去除代码块
        markdown = markdown.replaceAll("(.*?)", "$1");
        // 去除行内代码
        markdown = markdown.replaceAll("`([^`]+)`", "$1");
        // 去除水平线
        markdown = markdown.replaceAll("\\s*[-_\\*]{3,}\\s*", "");
        // 去除块引用
        markdown = markdown.replaceAll(">\\s+", "");

        return markdown;
    }
}
