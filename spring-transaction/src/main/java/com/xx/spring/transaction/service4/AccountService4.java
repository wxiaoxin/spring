
package com.xx.spring.transaction.service4;

import com.xx.spring.transaction.dao.IAccountDao;
import com.xx.spring.transaction.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Created by wxiao on 2016.10.12.
 */

@Service
public class AccountService4 implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    /*
     *  propagation 事务传播行为
     *  isolation   事务隔离级别
     *  readOnly    只读操作
     *  timeout     超时
     *  rollbackFor
     *  rollbackForClassName
     *  noRollbackFor
     *  noRollbackForClassName
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public void transfer(final String out, final String in, final Double money) {
        accountDao.out(out, money);
        int i = 1 / 0;
        accountDao.in(in, money);
    }
}
