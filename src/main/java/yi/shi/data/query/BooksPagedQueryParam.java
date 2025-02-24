package yi.shi.data.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BooksPagedQueryParam extends PagedQueryParam {
    private String bookName;
}
