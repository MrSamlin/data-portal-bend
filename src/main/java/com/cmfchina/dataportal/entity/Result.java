package com.cmfchina.dataportal.entity;


import lombok.Data;

@Data
public class Result<T> {
    private T data;
    private long total;
    private int currentPage;
    private int totalPages;
    private int pageSize;

    /**
     * 构建分页结果
     *
     * @param data 数据列表
     * @param total 总记录数
     * @param currentPage 当前页码
     * @param pageSize 每页大小
     * @return 构建好的Result对象
     */
    public Result<T> buildPageResult(T data, int total, int currentPage, int pageSize) {
        this.data = data;
        this.total = total;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        // 计算总页数
        double temp = (double) total / pageSize;
        this.totalPages = (int) Math.ceil(temp);
        return this;
    }
}