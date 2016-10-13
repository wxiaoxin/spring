package com.xx.spring.start.service.impl;

import com.xx.spring.start.dao.IAccountDao;
import com.xx.spring.start.dao.IBookDao;
import com.xx.spring.start.service.IBookStoreService;

/**
 * Created by wxiao on 2016.10.13.
 *
 * 购书的实现类 2
 *
 */

public class BookStoreService2 implements IBookStoreService {

    private IBookDao bookDao;

    private IAccountDao accountDao;

    /**
     * 空构造器
     */
    public BookStoreService2() {
    }

    /**
     * 带参构造函数
     *
     * @param bookDao    书本的操作类
     * @param accountDao 账户的操作类
     */
    public BookStoreService2(IBookDao bookDao, IAccountDao accountDao) {
        this.bookDao = bookDao;
        this.accountDao = accountDao;
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

}
