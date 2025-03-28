package com.example.portal.entity;


import lombok.Data;

@Data
public class Result<T> {
    private T data;
    private long total;
    private int currentPage;
    private int totalPages;
    private int pageSize;


}