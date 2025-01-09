package yi.shi.db.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import yi.shi.db.model.BorrowHistory;

import java.util.List;

@Mapper
public interface BorrowHistoryMapper {

    @Select("select * from borrow_history where book_id = #{bookId} order by id")
    List<BorrowHistory> selectBorrowHistoryByBookId(Long bookId);

    @Insert("insert into borrow_history(book_id, borrower_id, borrow_time, return_time) values(#{bookId}, #{borrowerId}, #{borrowTime}, #{returnTime})")
    int insertBorrowHistory(BorrowHistory borrowHistory);
}
