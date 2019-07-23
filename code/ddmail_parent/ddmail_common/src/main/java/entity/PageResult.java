package entity;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: Elves
 * @Description:
 * @Date: Created in 17:28 2019/7/21
 * @Modified By:
 */
public class PageResult<T> implements Serializable {

 private Long total;
 private List<T> rows;

    public PageResult() {
    }

    public PageResult(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
