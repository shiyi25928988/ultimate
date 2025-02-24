package yi.shi.utils;

import yi.shi.data.query.PagedQueryParam;
import yi.shi.data.result.PagedQueryResult;

import java.util.List;

public class PageUtil {

    public static PagedQueryResult page(List list, PagedQueryParam pagedParam){
        int page = pagedParam.getPageNum();
        int pageSize = pagedParam.getPageSize();
        int total = list.size();
        int totalPage = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
        return new PagedQueryResult(page, pageSize, total, totalPage, list.subList((page - 1) * pageSize, page * pageSize));
    }
}
