package com.xx.spring.pagination.base;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/10/14.
 *
 * 分页
 */

public class Page<T> implements Serializable {

    /**
     * 总记录行数
     */
    private int totalRecord;

    /**
     * 总页数
     */
    private int totalPage;

    /**
     * 页面记录行数
     */
    private int pageSize;

    /**
     * 当前页码
     */
    private int pageNumber;

    /**
     * 数据
     */
    private List<T> dataList;

    public Page() {
    }

    public Page(int pageNumber, int pageSize, List<T> dataList) {
        // 记录总数为记录集合的大小
        this.totalRecord = dataList.size();
        // 记录总页数
        this.totalPage = totalRecord / pageSize;
        if (totalRecord % pageSize != 0) {
            totalPage = totalPage + 1;
        }
        // 如果分页页码多于总页数，则分页页码为总页数
        this.pageNumber = pageNumber > totalPage ? totalPage : pageNumber;
        // 分页大小
        this.pageSize = pageSize;

        int fromIndex = (this.pageNumber - 1) * pageSize;
        int toIndex = pageNumber >= totalPage ? totalRecord : pageNumber * pageSize;
        this.dataList = dataList.subList(fromIndex, toIndex);
    }


    @Override
    public String toString() {
        return "Page{" +
                "totalRecord=" + totalRecord +
                ", totalPage=" + totalPage +
                ", pageSize=" + pageSize +
                ", pageNumber=" + pageNumber +
                ", dataList=" + dataList +
                '}';
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
