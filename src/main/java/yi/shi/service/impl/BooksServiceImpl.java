package yi.shi.service.impl;

import com.google.inject.Inject;
import yi.shi.db.mapper.BooksMapper;
import yi.shi.db.model.Books;
import yi.shi.service.BooksService;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BooksServiceImpl implements BooksService {

    private static Lock lock = new ReentrantLock();

    @Inject
    private BooksMapper booksMapper;

    @Override
    public Books addBooks(Books books) {
        lock.lock();
        try {
            if (Objects.isNull(books.getId())) {
                long id = booksMapper.selectMaxId() + 1;
                books.setId(id);
                booksMapper.insert(books);
            } else {
                booksMapper.update(books);
            }
            return books;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public List<Books> getAllBooks() {
        return booksMapper.selectAllBooks();
    }

    @Override
    public Books getBooksById(Long id) {
        return booksMapper.selectBooksById(id);
    }

    @Override
    public List<Books> getBooksByName(String name) {
        return booksMapper.selectBooksByName(name);
    }

    @Override
    public List<Books> getBooksByAuthor(String author) {
        return booksMapper.selectBooksByAuthor(author);
    }

    @Override
    public List<Books> getBooksByOwnerId(Long ownerId) {
        return booksMapper.selectBooksByOwnerId(ownerId);
    }

    @Override
    public List<Books> getBooksByHolderId(Long holderId) {
        return booksMapper.selectBooksByHolderId(holderId);
    }

    @Override
    public List<Books> getBooksByPage(int page, int pageSize) {
        return booksMapper.selectBooksByPage(page, pageSize);
    }

    @Override
    public Long getBooksCount() {
        return booksMapper.selectBooksCount();
    }

    @Override
    public int deleteBooksById(Long id) {
        return booksMapper.deleteBooksById(id);
    }

}
