package com.xx.spring.transaction.dao;

import com.xx.spring.transaction.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by wxiao on 2016.10.12.
 */

@Repository
public class AccountDao implements IAccountDao {

    @Autowired
    private JdbcTemplate jt;

    @Override
    public Account get(String id) {
        String sql = "select * from t_account where id=? ";
        return jt.query(sql, new Object[]{id}, new ResultSetExtractor<Account>() {
            @Override
            public Account extractData(ResultSet rs) throws SQLException, DataAccessException {
                if(rs.next()) {
                    Account account = new Account();
                    account.setId(rs.getString("id"));
                    account.setName(rs.getString("name"));
                    account.setMoney(rs.getDouble("money"));
                    return account;
                 } else {
                    return null;
                }
            }
        });
    }

    @Override
    public void out(String id, Double money) {
        String sql = "update t_account set money = money-? where id=?";
        jt.update(sql, money, id);
    }

    @Override
    public void in(String id, Double money) {
        String sql = "update t_account set money = money+? where id=?";
        jt.update(sql, money, id);
    }
}
