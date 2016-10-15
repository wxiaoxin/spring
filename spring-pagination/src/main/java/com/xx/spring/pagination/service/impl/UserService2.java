package com.xx.spring.pagination.service.impl;

import com.xx.spring.pagination.base.LimitParam;
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
public class UserService2 implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public Page<User> list(int pageNumber, int pageSize) {
        // 获取总记录条数
        int totalRecord = userDao.count();
        // 计算limit参数
        LimitParam limitParam = new LimitParam(pageNumber, pageSize, totalRecord);
        // 查询记录
        List<User> userList = userDao.listAll(limitParam);
        // 封装page对象
        Page<User> page = new Page<>(pageNumber, pageSize, totalRecord, userList);
        return page;
    }

    @Override
    public List<User> list() {
        return userDao.listAll();
    }
}
