package com.xx.spring.pagination.service.impl;

import com.xx.spring.pagination.base.Page;
import com.xx.spring.pagination.entity.User;
import com.xx.spring.pagination.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/10/14.
 */

@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

    @Autowired
    private IUserService userService;

    @Test
    public void testList() throws Exception {
        int pageNumber = 5;
        int pageSize = 3;
        Page<User> page = userService.list(pageNumber, pageSize);
        System.out.println(page);
    }
}