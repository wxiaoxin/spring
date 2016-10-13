package com.xx.spring.transaction.service;

import com.xx.spring.transaction.dao.IAccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Created by wxiao on 2016.10.12.
 */

@Service
public class AccountService implements IAccountService {


    @Autowired
    private IAccountDao accountDao;

    @Autowired
    private TransactionTemplate transactionTemplate;


    /**
     * 转账
     *
     * @param out   转出账户的id
     * @param in    转入账号的id
     * @param money 金额
     */
    @Override
    public void transfer(final String out, final String in, final Double money) {

        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                accountDao.out(out, money);
//                int i = 1 / 0;
                accountDao.in(in, money);
            }
        });

    }
}
