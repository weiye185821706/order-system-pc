package com.sys.order.vo;

/**
 * 封装请求vo
 *
 * @param <T>
 */
public class RequestVo<T> {
    private int page, size;

    private T params;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public T getParams() {
        return params;
    }

    public void setParams(T params) {
        this.params = params;
    }
}
