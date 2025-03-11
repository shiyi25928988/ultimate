package yi.shi.pages.element.card;

import j2html.tags.specialized.DivTag;
import yi.shi.db.model.Books;

import java.util.List;

import static j2html.TagCreator.*;

public class BookCard {

    /**
     *   <div class="row">
     *     <div class="col s12 m7">
     *       <div class="card">
     *         <div class="card-image">
     *           <img src="images/sample-1.jpg">
     *           <span class="card-title">Card Title</span>
     *         </div>
     *         <div class="card-content">
     *           <p>I am a very simple card. I am good at containing small bits of information.
     *           I am convenient because I require little markup to use effectively.</p>
     *         </div>
     *         <div class="card-action">
     *           <a href="#">This is a link</a>
     *         </div>
     *       </div>
     *     </div>
     *   </div>
     * */
    public static DivTag createBookCard(Books books) {
        return div().with(
                div().withClass("col s12 m6 l4").with(
                        a().withHref("/page/bookDetailPage?id=" + books.getId()).with(
                            div().withClass("card hoverable medium").with(
                                    div().withClass("card-image").with(
                                            img().withSrc(books.getCoverUrl()).withAlt(books.getBookName()),
                                            span().withClass("card-title").withText(books.getBookName())
                                    ),
                                    div().withClass("card-content").with(
                                            p().withText(books.getAuthor()),
                                            p().withText(books.getDigest())
                                    )
                            )
                        )
                )
        );
    }

    public static DivTag createBookCards(List<Books> books) {
        return div().withClass("row").with(
                div().withId("bookContainer").withClass("container section").with(
                        createBookCardsList(books)));
    }
    public static DivTag createBookCardsList(List<Books> books) {
        DivTag[] divTags = new DivTag[books.size()];
        books.forEach(book -> divTags[books.indexOf(book)] = createBookCard(book));
        return div().with(divTags);
    }
}
