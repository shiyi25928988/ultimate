package yi.shi.utils;

import yi.shi.data.PagedParam;
import yi.shi.data.PagedResult;

import java.util.List;

public class PageUtil {

    public static PagedResult page(List list, PagedParam pagedParam){
        int page = pagedParam.getPage();
        int pageSize = pagedParam.getPageSize();
        int total = list.size();
        int totalPage = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
        return new PagedResult(page, pageSize, total, totalPage, list.subList((page - 1) * pageSize, page * pageSize));
    }
}
