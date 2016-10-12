package com.xx.spring.transaction.dao;

import com.xx.spring.transaction.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/10/12.
 */

@Repository
public class BookDao implements IBookDao {

    @Autowired
    private JdbcTemplate jt;

    @Override
    public void save(Book book) {
        String sql = "insert into t_book values(?, ?, ?, ?)";
        jt.update(sql, book.getId(), book.getName(), book.getPrice(), book.getStock());
    }

    @Override
    public Book get(String id) {
        String sql = "select * from t_book where id=?";
        return jt.query(sql, new Object[]{id}, new ResultSetExtractor<Book>() {
            @Override
            public Book extractData(ResultSet rs) throws SQLException, DataAccessException {
                if(rs.next()) {
                    Book book = new Book();
                    book.setId(rs.getString("id"));
                    book.setName(rs.getString("name"));
                    book.setPrice(rs.getDouble("price"));
                    book.setStock(rs.getInt("stock"));
                    return book;
                } else {
                    return null;
                }
            }
        });
    }

    @Override
    public void updateStockById(String id, int num) {
        String sql = "update t_book set stock = stock - ? where id = ?";
        jt.update(sql, num, id);
    }
}
