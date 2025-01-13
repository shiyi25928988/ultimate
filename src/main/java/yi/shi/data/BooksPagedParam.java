package yi.shi.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BooksPagedParam {
    private int page;
    private int pageSize;
    private String bookName;
}
