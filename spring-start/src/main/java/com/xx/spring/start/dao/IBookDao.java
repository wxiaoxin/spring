package com.xx.spring.start.dao;

/**
 * Created by wxiao on 2016.10.13.
 *
 * 管理书的接口
 */

public interface IBookDao {

    /**
     * 获取书本价格
     * @param bookName  书名
     * @return          书本价格
     */
    Double getPriceByBookName(String bookName);

    /**
     * 增加书本的数量
     *
     * @param bookName 书名
     * @param number   数量
     */
    void increase(String bookName, int number);

    /**
     * 减少书本的数量
     *
     * @param bookName 书名
     * @param number   数量
     */
    void decrease(String bookName, int number);


}
