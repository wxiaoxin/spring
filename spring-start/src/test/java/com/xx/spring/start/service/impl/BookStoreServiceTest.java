package com.xx.spring.start.service.impl;

import com.xx.spring.start.service.BaseTest;
import com.xx.spring.start.service.IBookStoreService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by wxiao on 2016.10.13.
 */

public class BookStoreServiceTest extends BaseTest {

    @Test
    public void buyBook() throws Exception {
        IBookStoreService bookStoreService = context.getBean("bookStoreService", IBookStoreService.class);
        bookStoreService.buyBook("钱穆", "国史大纲", 10);
    }

}