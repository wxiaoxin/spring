package com.xx.spring.transaction.dao;

/**
 * Created by wxiao on 2016.10.12.
 */

public interface IAccountDao {

    void out(String id, Double money);

    void in(String id, Double money);

}
