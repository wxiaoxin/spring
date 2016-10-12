package com.xx.spring.transaction.dao;

import com.xx.spring.transaction.entity.Account;

/**
 * Created by wxiao on 2016.10.12.
 */

public interface IAccountDao {

    Account get(String id);

    void out(String id, Double money);

    void in(String id, Double money);

}
