package com.xx.spring.pagination.base;

/**
 * Created by Administrator on 2016/10/15.
 */
public class LimitParam {

    public int offset;

    public int rowCount;

    public LimitParam(int offset, int rowCount) {
        this.offset = offset;
        this.rowCount = rowCount;
    }

    public LimitParam(int pageNumber, int pageSize, int totalRecord) {
        int x = (pageNumber - 1) * pageSize;
        this.offset = x >= totalRecord ? totalRecord - 1: x;
        this.rowCount = pageSize;
    }

}
