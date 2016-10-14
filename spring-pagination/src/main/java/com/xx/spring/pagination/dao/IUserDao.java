package com.xx.spring.pagination.dao;

import com.xx.spring.pagination.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2016/10/14.
 */
public interface IUserDao {

    void save(User user);

    void del(String id);

    void update(User user);

    User get(String id);

    List<User> listAll();


}
