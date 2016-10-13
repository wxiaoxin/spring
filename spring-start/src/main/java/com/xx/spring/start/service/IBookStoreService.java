package com.xx.spring.start.service;

/**
 * Created by wxiao on 2016.10.13.
 * 购书的接口
 */

public interface IBookStoreService {

    /**
     * 购书操作
     * @param accountName   账户名称
     * @param bookName      书名
     * @param number        数量
     */
    void buyBook(String accountName, String bookName, int number);

}
