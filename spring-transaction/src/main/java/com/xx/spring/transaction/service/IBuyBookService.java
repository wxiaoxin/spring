package com.xx.spring.transaction.service;

/**
 * Created by Administrator on 2016/10/12.
 */
public interface IBuyBookService {

    /**
     * 购书
     * @param accountId 账户id
     * @param bookId 书本id
     * @param num 书本数量
     */
    void buyBook(String accountId, String bookId, int num);

}
