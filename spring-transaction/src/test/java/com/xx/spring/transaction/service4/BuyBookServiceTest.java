package com.xx.spring.transaction.service4;

import com.xx.spring.transaction.service.IBuyBookService;
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
public class BuyBookServiceTest {


    @Autowired
    private IBuyBookService buyBookService;

    @Test
    public void testBuyBook() throws Exception {
        String accountId = "1";
        String bookId = "1";
        int num = 2;
        buyBookService.buyBook(accountId, bookId, num);
    }
}