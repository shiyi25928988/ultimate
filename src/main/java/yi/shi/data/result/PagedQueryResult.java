package yi.shi.data.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PagedQueryResult<T>{
    private int page;
    private int pageSize;
    private long total;
    private int totalPage;
    private List<T> data;
}
