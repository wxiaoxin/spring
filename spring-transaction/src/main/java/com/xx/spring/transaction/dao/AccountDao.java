package com.xx.spring.transaction.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by wxiao on 2016.10.12.
 */

@Repository
public class AccountDao implements IAccountDao {

    @Autowired
    private JdbcTemplate jt;

    @Override
    public void out(String id, Double money) {
        String sql = "update t_account set money = money - ? where id = ?";
        jt.update(sql, money, id);
    }

    @Override
    public void in(String id, Double money) {
        String sql = "update t_account set money = money + ? where id = ?";
        jt.update(sql, money, id);
    }
}
