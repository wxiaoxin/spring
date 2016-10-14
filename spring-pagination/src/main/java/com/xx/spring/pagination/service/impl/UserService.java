package com.xx.spring.pagination.service.impl;

import com.xx.spring.pagination.base.Page;
import com.xx.spring.pagination.dao.IUserDao;
import com.xx.spring.pagination.entity.User;
import com.xx.spring.pagination.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/10/14.
 */

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public Page<User> list(int pageNumber, int pageSize) {
        List<User> userList = userDao.listAll();
        Page<User> page = new Page<>(pageNumber, pageSize, userList);
        return page;
    }
}
