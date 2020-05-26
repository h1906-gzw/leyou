package com.leyou.common;

import java.util.List;

public class PageResult<T> {
    private Long total;

    private List<T> items;

    public PageResult(Long total) {
        this.total = total;
    }

    public PageResult(Long total, List<T> items) {
        this.total = total;
        this.items = items;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
