package com.xx.spring.start.service.impl;

import com.xx.spring.start.service.BaseTest;
import com.xx.spring.start.service.IBookStoreService;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wxiao on 2016.10.13.
 */
public class BookStoreService2Test extends BaseTest {


    @Test
    public void buyBook() throws Exception {
        IBookStoreService bookStoreService2 = context.getBean("bookStoreService2", IBookStoreService.class);
        bookStoreService2.buyBook("钱穆", "国史大纲", 10);
    }

}