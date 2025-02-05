package yi.shi.pages.element.image;

import j2html.tags.specialized.*;

import static j2html.TagCreator.*;

public class ImageUploadAndPreview {
    public static DivTag imageUploadAndPreview(String id, String label, String width, String height, String imageUrl) {
        InputTag fileInput = input()
                .withType("file")
                .withId(id + "-file")
                .withClass("file-path validate")
                .withStyle("display: none;");

        ImgTag imgTag = img()
                .withSrc(imageUrl)
                .withAlt("Avatar")
                .withClass("circle responsive-img")
                .withStyle("width: " + width + "; height: " + height + "; cursor: pointer;")
                .attr("onclick","document.getElementById('" + id + "-file').click();");

        LabelTag labelTag = label()
                .withClass("active")
                .withText(label);

        return div().withClass("row").with(
                div().withClass("col s12 m6").with(
                        labelTag
                ),
                div().withClass("col s12 m12 l12").with(
                        div().withClass("file-field input-field").with(
                                div().withClass("btn").with(
                                        fileInput
                                ).withStyle("display: none;"),
                                div().withClass("file-path-wrapper").with(
                                        imgTag
                                )
                        )
                )
        );
    }
}