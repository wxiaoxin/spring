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
 * 基于代理的声明式事务管理测试类
 *
 */

@ContextConfiguration(locations = {"classpath:applicationContext2.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountServiceTest2 {


    @Resource(name = "accountServiceProxy")
    private IAccountService accountService;

    @Test
    public void transfer() throws Exception {
        accountService.transfer("1", "2", 500d);
    }

}