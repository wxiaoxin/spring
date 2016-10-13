package com.xx.spring.start.dao.impl;

import com.xx.spring.start.dao.IAccountDao;

/**
 * Created by wxiao on 2016.10.13.
 *
 * 账户实体操作类
 */

public class AccountDao implements IAccountDao {

    @Override
    public void in(String accountName, double money) {
        System.out.println("账户：" + accountName + " 收入了 " + money + " 元");
    }

    @Override
    public void out(String accountName, double money) {
        System.out.println("账户：" + accountName + " 支出了 " + money + " 元");
    }
}
