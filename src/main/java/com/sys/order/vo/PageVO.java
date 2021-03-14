package com.sys.order.vo;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.ArrayList;
import java.util.List;

public class PageVO<T> {

    private Long page, size;
    private long total;
    private List<T> data;
    private boolean success;
    private String message;
    public PageVO() {
        this.page = 1L;
        this.size = 10L;
        this.total = 0L;
        this.data = new ArrayList<>();
        this.success = true;
    }

    public PageVO(IPage<T> page) {
        this.page = page.getCurrent();
        this.size = page.getSize();
        this.data = page.getRecords();
        this.total = page.getTotal();
        this.success = true;
    }

    public PageVO(Long page, Long size, Long count, List<T> data) {
        this.page = page;
        this.size = size;
        this.data = data;
        this.total = count;
        this.success = true;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
