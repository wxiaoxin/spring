package com.xx.spring.start.dao.impl;

import com.xx.spring.start.dao.IBookDao;

/**
 * Created by wxiao on 2016.10.13.
 *
 * 书的操作类
 */

public class BookDao implements IBookDao {

    @Override
    public Double getPriceByBookName(String bookName) {
        System.out.println("查询：" + bookName + " 的价格是 10 元");
        return 10d;
    }

    @Override
    public void increase(String bookName, int number) {
        System.out.println("书本：" + bookName + " 增加了 " + number + " 本");
    }

    @Override
    public void decrease(String bookName, int number) {
        System.out.println("书本：" + bookName + " 减少了 " + number + " 本");
    }
}
