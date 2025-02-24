package yi.shi.restapi;

import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import com.google.common.base.Strings;
import com.google.inject.Inject;
import yi.shi.ai.qianwen.AiBookInfoGenerator;
import yi.shi.data.query.BooksPagedQueryParam;
import yi.shi.data.query.PagedQueryParam;
import yi.shi.data.result.PagedQueryResult;
import yi.shi.db.model.Books;
import yi.shi.pages.element.card.BookCard;
import yi.shi.plinth.annotation.http.HttpBody;
import yi.shi.plinth.annotation.http.HttpParam;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.DELETE;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.annotation.http.Method.POST;
import yi.shi.plinth.http.result.JSON;
import yi.shi.data.ResponseWrapper;
import yi.shi.service.BooksService;
import yi.shi.utils.PageUtil;

import java.io.IOException;
import java.util.List;

@HttpService
public class BooksApi {

    @Inject
    BooksService booksService;

    @GET
    @HttpPath("/api/books/getBooksByName")
    public JSON<ResponseWrapper<List<Books>>> getBooksByName(@HttpParam("bookname")String bookName) {
        return new JSON<>(ResponseWrapper.success(booksService.getBooksByName(bookName)));
    }

    @GET
    @HttpPath("/api/books/getBooksDivByName")
    public JSON<ResponseWrapper<String>> getBooksDivByName(@HttpParam("bookname")String bookName) {
        List<Books> list;
        if(Strings.isNullOrEmpty(bookName)){
            list = booksService.getAllBooks();
        }else {
            list = booksService.getBooksByName(bookName);
        }
        return new JSON<>(ResponseWrapper.success(BookCard.createBookCardsList(list).render()));
    }

    @GET
    @HttpPath("/api/books/getAllBooks")
    public JSON<ResponseWrapper<List<Books>>> getAllBooks() {
        return new JSON<>(ResponseWrapper.success(booksService.getAllBooks()));
    }

    @POST
    @HttpPath("/api/books/addBooks")
    public JSON<ResponseWrapper<Books>> addBooks(@HttpBody Books books) {
        return new JSON<>(ResponseWrapper.success(booksService.addBooks(books)));
    }


    @GET
    @HttpPath("/api/AI/queryInfoByBookName")
    public JSON<ResponseWrapper<Books>> queryInfoByBookName(@HttpParam("bookname")String bookName) throws NoApiKeyException, InputRequiredException, IOException {
        Books books = AiBookInfoGenerator.queryBookInfo(bookName);
        return new JSON<>(ResponseWrapper.success(books));
    }

    @GET
    @HttpPath("/api/books/getBooksCount")
    public JSON<ResponseWrapper<Long>> getBooksCount() {
        return new JSON<>(ResponseWrapper.success(booksService.getBooksCount()));
    }

    @GET
    @HttpPath("/api/books/getBooksById")
    public JSON<ResponseWrapper<Books>> getBooksById(@HttpParam("id") Long id) {
        return new JSON<>(ResponseWrapper.success(booksService.getBooksById(id)));
    }

    @DELETE
    @HttpPath("/api/books/deleteBooksById")
    public JSON<ResponseWrapper<Integer>> deleteBooksById(@HttpParam("id") Long id) {
        return new JSON<>(ResponseWrapper.success(booksService.deleteBooksById(id)));
    }

    @POST
    @GET
    @HttpPath("/api/books/getBooksByPage")
    public JSON<ResponseWrapper<PagedQueryResult<List<Books>>>> getBooksByPage(@HttpBody BooksPagedQueryParam booksPageParam) {
        List<Books> books;
        if(!Strings.isNullOrEmpty(booksPageParam.getBookName())){
            books = booksService.getBooksByName(booksPageParam.getBookName());
        }else {
            books = booksService.getAllBooks();
        }
        PagedQueryParam pageParam = new PagedQueryParam(booksPageParam.getPageNum(), booksPageParam.getPageSize());
        return new JSON<>(ResponseWrapper.success(PageUtil.page(books, pageParam)));
    }

}
