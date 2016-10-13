package com.xx.spring.transaction.dao;

import com.xx.spring.transaction.entity.Book;

/**
 * Created by Administrator on 2016/10/12.
 */
public interface IBookDao {

    /**
     * 保存一本书
     * @param book
     */
    void save(Book book);


    /**
     * 根据编码获取书的信息
     * @param id 书编码
     * @return
     */
    Book get(String id);


    /**
     * 更新书库存
     * @param id 书编码
     * @param num 数量
     */
    void updateStockById(String id, int num);

}
