package com.xx.spring.transaction.service;

/**
 * Created by wxiao on 2016.10.12.
 */
public interface IAccountService {

    /**
     * 转账
     * @param out   转出账户的id
     * @param in    转入账号的id
     * @param money 金额
     */
    void transfer(String out, String in, Double money);

}
