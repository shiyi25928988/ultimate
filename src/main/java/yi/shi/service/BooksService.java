package yi.shi.service;

import com.google.inject.ImplementedBy;
import yi.shi.db.model.Books;
import yi.shi.service.impl.BooksServiceImpl;

import java.util.List;

@ImplementedBy(BooksServiceImpl.class)
public interface BooksService {

    Books addBooks(Books books);

    List<Books> getAllBooks();

    Books getBooksById(Long id);

    List<Books> getBooksByName(String name);

    List<Books> getBooksByAuthor(String author);

    List<Books> getBooksByOwnerId(Long ownerId);

    List<Books> getBooksByHolderId(Long holderId);

}
