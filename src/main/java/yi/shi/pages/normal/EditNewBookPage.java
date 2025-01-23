package yi.shi.pages.normal;

import j2html.tags.ContainerTag;
import j2html.tags.specialized.*;
import yi.shi.pages.Page;
import yi.shi.pages.component.Button;
import yi.shi.pages.component.Input;
import yi.shi.pages.component.modal.UploadModal;
import yi.shi.pages.element.Footer;
import yi.shi.pages.element.Head;
import yi.shi.pages.element.Header;
import yi.shi.plinth.annotation.auth.AUTH;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.http.result.HTML;

import static j2html.TagCreator.*;

@HttpService
public class EditNewBookPage extends Page {

    @GET
    @HttpPath(value = "/page/editNewBook")
    @AUTH(authUrl = "/page/login")
    public HTML editNewBookPage() throws Exception {
        HTML html = new HTML();
        html.setHtmlContent(createHtml().render());
        return html;
    }

    @Override
    protected HeadTag createHead() {
        return Head.createHead("新增书籍");
    }

    @Override
    protected HeaderTag createHeader() {
        return Header.createHeader();
    }

    @Override
    protected MainTag createMain() throws Exception {

        ContainerTag form = form().withId("bookForm").with(
                Input.getInputWithButton(Input.INPUT_WIDTH_FULL, "bookName", "书名", Input.TYPE_TEXT, Button.normalButton("获取图书信息","queryBookInfo()"),false),
                Input.getInput(Input.INPUT_WIDTH_FULL, "isbn", "ISBN", Input.TYPE_TEXT, false),
                Input.getTextArea("digest", "摘要", false),
                Input.getInput(Input.INPUT_WIDTH_FULL, "author", "作者", Input.TYPE_TEXT, false),
                Input.getTextArea("aboutAuthor", "关于作者", false),
                Input.getInput(Input.INPUT_WIDTH_FULL, "price", "价格", Input.TYPE_TEXT, false),
                Input.getInput(Input.INPUT_WIDTH_FULL, "coverUrl", "封面URL", Input.TYPE_TEXT, false),
                UploadModal.singleFileUploadFrame(),
                Button.normalButton("添加", "addNewBook()")
        );
        MainTag main = main(
                div().withClass("container").with(
                        h4().withClass("center-align").withText("新增书籍"),
                        form
                ),
                script().withSrc("/js/AddNewBook.js")
        );
        return main;
    }

    @Override
    protected FooterTag createFooter() {
        return Footer.createFooter();
    }
}
