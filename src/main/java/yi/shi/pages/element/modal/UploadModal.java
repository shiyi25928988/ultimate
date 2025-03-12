package yi.shi.pages.element.modal;

import j2html.tags.specialized.DivTag;

public class UploadModal {

    public static DivTag uploadModal() {
        return new DivTag()
                .withId("uploadModal")
                .withClass("modal")
                .with(
                        new DivTag()
                                .withClass("modal-content")
                                .with(
                                        new DivTag()
                                                .withClass("modal-header")
                                                .with(
                                                        new DivTag()
                                                                .withClass("close")
                                                                .withId("closeUploadModal")
                                                )
                                )
                );
    }
}
