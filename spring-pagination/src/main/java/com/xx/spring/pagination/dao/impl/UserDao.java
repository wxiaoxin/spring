package com.xx.spring.pagination.dao.impl;

import com.xx.spring.pagination.base.LimitParam;
import com.xx.spring.pagination.dao.IUserDao;
import com.xx.spring.pagination.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2016/10/14.
 * <p/>
 * 用户操作类
 */

@Repository
public class UserDao implements IUserDao {

    @Autowired
    private JdbcTemplate jt;

    @Override
    public void save(User user) {
        String sql = "insert into t_user values(?, ?, ?)";
        jt.update(sql, user.getId(), user.getName(), user.getPwd());
    }

    @Override
    public void del(String id) {
        String sql = " delete from t_user where id=? ";
        jt.update(sql, id);
    }

    @Override
    public void update(User user) {
        // TODO
    }

    @Override
    public User get(String id) {
        String sql = " select * from t_user where id=? ";
        return jt.query(sql, new Object[]{id}, new ResultSetExtractor<User>() {
            @Override
            public User extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    User user = new User();
                    user.setId(rs.getString("id"));
                    user.setName(rs.getString("name"));
                    user.setPwd(rs.getString("pwd"));
                    return user;
                }
                return null;
            }
        });
    }

    @Override
    public int count() {
        String sql = "select count(*) as count from t_user";
        return jt.queryForObject(sql, Integer.class);
    }

    @Override
    public List<User> listAll() {
        String sql = " select * from t_user ";
        return jt.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setPwd(rs.getString("pwd"));
                return user;
            }
        });
    }

    @Override
    public List<User> listAll(LimitParam limitParam) {
        String sql = " select * from t_user limit ?,? ";
        return jt.query(sql,new Object[]{limitParam.offset, limitParam.rowCount}, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setPwd(rs.getString("pwd"));
                return user;
            }
        });
    }
}
