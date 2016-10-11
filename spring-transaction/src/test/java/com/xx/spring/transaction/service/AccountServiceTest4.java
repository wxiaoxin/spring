package com.xx.spring.transaction.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by wxiao on 2016.10.12.
 *
 * 基于注解的声明式事务管理的测试
 *
 */

@ContextConfiguration(locations = {"classpath:applicationContext4.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountServiceTest4 {


    @Autowired
    private IAccountService accountService;

    @Test
    public void transfer() throws Exception {
        accountService.transfer("1", "2", 500d);
    }

}