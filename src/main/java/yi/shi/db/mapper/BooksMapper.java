package yi.shi.db.mapper;

import org.apache.ibatis.annotations.*;
import yi.shi.db.model.Books;

import java.util.List;

@Mapper
public interface BooksMapper {

    @Select("SELECT MAX(id) FROM books")
    long selectMaxId();

    @Insert("insert into books(id,book_name,isbn,digest,author,about_author,price,cover_url,owner_id,holder_id,create_time) " +
            "values(#{id},#{bookName},#{isbn},#{digest},#{author},#{aboutAuthor},#{price},#{coverUrl},#{ownerId},#{holderId},#{createTime})")
    int insert(Books books);

    @Update("update books set book_name=#{bookName},isbn=#{isbn},digest=#{digest},author=#{author},about_author=#{aboutAuthor},price=#{price},cover_url=#{coverUrl},owner_id=#{ownerId},holder_id=#{holderId},create_time=#{createTime} where id=#{id}")
    int update(Books books);

    @Select("select * from books where book_name like concat('%',#{bookName},'%')")
    List<Books> selectBooksByName(String bookName);

    @Select("select * from books where author like concat('%',#{author},'%')")
    List<Books> selectBooksByAuthor(String author);

    @Select("select * from books where owner_id=#{ownerId}")
    List<Books> selectBooksByOwnerId(Long ownerId);

    @Select("select * from books where holder_id=#{holderId}")
    List<Books> selectBooksByHolderId(Long holderId);

    @Select("select * from books where id=#{id}")
    Books selectBooksById(Long id);

    @Select("select * from books oder by id desc")
    List<Books> selectAllBooks();

    @Select("select * from books limit #{page},#{pageSize}")
    List<Books> selectBooksByPage(int page, int pageSize);

    @Select("select count(*) from books")
    Long selectBooksCount();

    @Delete("delete from books where id=#{id}")
    int deleteBooksById(Long id);
}
