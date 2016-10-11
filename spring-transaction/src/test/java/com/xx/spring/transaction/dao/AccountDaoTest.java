package com.xx.spring.transaction.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by wxiao on 2016.10.12.
 */

@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountDaoTest {

    @Autowired
    private IAccountDao accountDao;

    @Test
    public void out() throws Exception {
        accountDao.out("1", 500.0);
    }

    @Test
    public void in() throws Exception {
        accountDao.in("2", 200.0);
    }

}