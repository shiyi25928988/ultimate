package yi.shi.service;

import com.google.inject.ImplementedBy;
import yi.shi.db.model.BorrowHistory;
import yi.shi.service.impl.BorrowHistoryServiceImpl;

import java.util.List;

@ImplementedBy(BorrowHistoryServiceImpl.class)
public interface BorrowHistoryService {

    List<BorrowHistory> getAllBorrowHistoryByBookId(Long bookId);

    List<BorrowHistory> getAllBorrowHistoryByBorrowerId(Long borrowerId);

    void addBorrowHistory(BorrowHistory borrowHistory);
}
