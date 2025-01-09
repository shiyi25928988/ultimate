package yi.shi.restapi;

import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import com.google.inject.Inject;
import yi.shi.ai.qianwen.AiBookInfoGenerator;
import yi.shi.db.model.Books;
import yi.shi.plinth.annotation.http.HttpBody;
import yi.shi.plinth.annotation.http.HttpParam;
import yi.shi.plinth.annotation.http.HttpPath;
import yi.shi.plinth.annotation.http.HttpService;
import yi.shi.plinth.annotation.http.Method.GET;
import yi.shi.plinth.annotation.http.Method.POST;
import yi.shi.plinth.http.result.JSON;
import yi.shi.data.result.ResponseWrapper;
import yi.shi.service.BooksService;

import java.io.IOException;
import java.util.List;

@HttpService
public class BooksApi {

    @Inject
    BooksService booksService;

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
}
