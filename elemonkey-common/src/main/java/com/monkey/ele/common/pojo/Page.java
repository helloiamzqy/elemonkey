package com.monkey.ele.common.pojo;

import java.util.List;

public class Page<T> {

    private Integer pageIndex;
    private Integer pageCount;
    private List<T> items;
    private Integer pageTotal;
    private Integer itemTotal;

    public Page(Integer pageIndex, Integer pageCount, List<T> items, Integer itemTotal) {
        this.pageIndex = pageIndex;
        this.pageCount = pageCount;
        this.items = items;
        this.itemTotal = itemTotal;
        this.pageTotal = (this.itemTotal + this.pageCount - 1 ) / this.pageCount;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public Integer getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(Integer itemTotal) {
        this.itemTotal = itemTotal;
    }

}
