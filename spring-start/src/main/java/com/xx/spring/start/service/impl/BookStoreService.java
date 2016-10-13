package com.xx.spring.start.service.impl;

import com.xx.spring.start.service.IBookStoreService;

/**
 * Created by wxiao on 2016.10.13.
 *
 * 购书的实现类-1
 */

public class BookStoreService implements IBookStoreService {

    public BookStoreService() {
        System.out.println(hashCode());
    }

    @Override
    public void buyBook(String accountName, String bookName, int number) {
        System.out.println(accountName + "，购买：" + number + " 本 " + bookName);
    }

}
