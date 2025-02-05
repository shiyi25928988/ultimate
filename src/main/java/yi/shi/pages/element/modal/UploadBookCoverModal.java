package yi.shi.pages.element.modal;

import j2html.tags.specialized.DivTag;

import static j2html.TagCreator.*;

public class UploadBookCoverModal {

    public static DivTag singleFileUploadFrame() {
        return div(
                a("上传封面图片").withClass("waves-effect waves-light btn modal-trigger").withHref("#uploadCoverImagemodal"),
                div(
                    div(
                        h4("上传文件"),
                        form(
                            div(
                                div(
                                    span("选择文件"),
                                    input().withType("file").withId("fileInput")
                                ).withClass("btn"),
                                div(
                                    input().withClass("file-path validate").withType("text").withPlaceholder("上传文件")
                                ).withClass("file-path-wrapper")
                            ).withClass("file-field input-field"),
                            div(
                                div().withClass("progress").with(
                                    div().withClass("determinate").withStyle("width: 0%"))
                            ),
                            button("上传").withClass("waves-effect waves-light btn").withType("button").attr("onclick", "handleFileUpload(event)")
                        ).withId("uploadForm").attr("onsubmit", "return false;")
                    ).withClass("modal-content"),
                    div(
                        a("关闭").withHref("#!").withClass("modal-close waves-effect waves-green btn-flat")
                    ).withClass("modal-footer")
                ).withId("uploadCoverImagemodal").withClass("modal"),
                script().withSrc("/js/UploadCoverImage.js")
        );
    }
}
