package com.xx.spring.start.service.impl;

import com.xx.spring.start.dao.IAccountDao;
import com.xx.spring.start.dao.IBookDao;
import com.xx.spring.start.service.IBookStoreService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wxiao on 2016.10.13.
 *
 * 购书的实现类 3
 */

public class BookStoreService3 implements IBookStoreService {

    private IBookDao bookDao;

    private IAccountDao accountDao;

    /**
     * 空构造器
     */
    public BookStoreService3() {
    }


    @Override
    public void buyBook(String accountName, String bookName, int number) {
        // 获取书本价格
        Double price = bookDao.getPriceByBookName(bookName);
        // 减少书本数量
        bookDao.decrease(bookName, number);

        // 计算总金额
        double money = price * number;
        // 扣除账户金额
        accountDao.out(accountName, money);
    }

    public void setBookDao(IBookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
