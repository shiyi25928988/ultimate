package yi.shi.data.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PagedQueryParam {
    private int pageNum;
    private int pageSize;
}
