package com.xx.spring.pagination.service;

import com.xx.spring.pagination.base.Page;
import com.xx.spring.pagination.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2016/10/14.
 */
public interface IUserService {

    Page<User> list(int pageNumber, int pageSize);

    List<User> list();

}
