package yi.shi.service.impl;

import com.google.inject.Inject;
import yi.shi.db.mapper.BorrowHistoryMapper;
import yi.shi.db.model.BorrowHistory;
import yi.shi.service.BorrowHistoryService;

import java.util.List;

public class BorrowHistoryServiceImpl implements BorrowHistoryService {

    @Inject
    private BorrowHistoryMapper borrowHistoryMapper;

    @Override
    public List<BorrowHistory> getAllBorrowHistoryByBookId(Long bookId) {
        return borrowHistoryMapper.selectBorrowHistoryByBookId(bookId);
    }

    @Override
    public List<BorrowHistory> getAllBorrowHistoryByBorrowerId(Long borrowerId) {
        return borrowHistoryMapper.selectBorrowHistoryByBorrowerId(borrowerId);
    }

    @Override
    public void addBorrowHistory(BorrowHistory borrowHistory) {
        borrowHistoryMapper.insertBorrowHistory(borrowHistory);
    }
}
