package com.xx.spring.pagination.dao.impl;

import com.xx.spring.pagination.dao.IUserDao;
import com.xx.spring.pagination.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/10/14.
 */

@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTest {

    @Autowired
    private IUserDao userDao;

    @Test
    public void testSave() throws Exception {
        User user = new User();
        user.setId("3");
        user.setName("c");
        user.setPwd("c-c");
        userDao.save(user);
    }

    @Test
    public void testDel() throws Exception {
        String id = "1";
        userDao.del(id);
    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testGet() throws Exception {
        String id = "1";
        User user = userDao.get(id);
        System.out.println(user);
    }

    @Test
    public void testListAll() throws Exception {
        List<User> userList = userDao.listAll();
        System.out.println(userList);
    }
}