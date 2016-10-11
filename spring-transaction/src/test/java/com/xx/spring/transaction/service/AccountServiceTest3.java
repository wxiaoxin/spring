package com.xx.spring.transaction.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by wxiao on 2016.10.12.
 *
 * 基于AOP和XML形式配置事务管理器的测试
 *
 */

@ContextConfiguration(locations = {"classpath:applicationContext3.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountServiceTest3 {


    @Autowired
    private IAccountService accountService;

    @Test
    public void transfer() throws Exception {
        accountService.transfer("1", "2", 500d);
    }

}