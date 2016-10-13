package com.xx.spring.transaction.dao;

import com.xx.spring.transaction.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/10/12.
 */

@ContextConfiguration(locations = {"classpath:applicationContext4.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class BookDaoTest {


    @Autowired
    private IBookDao bookDao;

    @Test
    public void testSave() throws Exception {
        Book book = new Book();
        book.setId("1");
        book.setName("Spring in action");
        book.setPrice(76.9d);
        book.setStock(10);
        bookDao.save(book);
    }

    @Test
    public void testGet() throws Exception {
        String id = "1";
        Book book = bookDao.get(id);
        System.out.println(book);
    }

    @Test
    public void testUpdateStockById() throws Exception {

    }
}