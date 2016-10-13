package com.xx.spring.start.dao;

/**
 * Created by wxiao on 2016.10.13.
 *
 * 账户操作接口
 */

public interface IAccountDao {

    /**
     * 账户收入金额
     *
     * @param accountName 账户名称
     * @param money       收入金额
     */
    void in(String accountName, double money);

    /**
     * 账户支出金额
     *
     * @param accountName 账户名称
     * @param money       支出金额
     */
    void out(String accountName, double money);

}
