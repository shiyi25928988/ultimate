package yi.shi.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PagedResult <T>{
    private int page;
    private int pageSize;
    private long total;
    private int totalPage;
    private List<T> data;
}
