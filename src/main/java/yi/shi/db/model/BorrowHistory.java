package yi.shi.db.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowHistory {
    private Long id;
    private Long bookId;
    private Long borrowerId;
    private Date borrowTime;
    private Date returnTime;
}
