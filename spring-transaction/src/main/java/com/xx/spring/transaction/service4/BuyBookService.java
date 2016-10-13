package com.xx.spring.transaction.service4;

import com.xx.spring.transaction.dao.IAccountDao;
import com.xx.spring.transaction.dao.IBookDao;
import com.xx.spring.transaction.entity.Account;
import com.xx.spring.transaction.entity.Book;
import com.xx.spring.transaction.service.IBuyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2016/10/12.
 */

@Service
public class BuyBookService implements IBuyBookService {

    @Autowired
    private IAccountDao accountDao;

    @Autowired
    private IBookDao bookDao;

    @Override
    @Transactional
    public void buyBook(String accountId, String bookId, int num) {
        Book book = bookDao.get(bookId);
        Double bookPrice = book.getPrice();
        if(book.getStock() < num) {
            throw new RuntimeException("书本：" + book.getName() + " 存库不足，无法购买!");
        }
        Account account = accountDao.get(accountId);
        if(account.getMoney() < bookPrice) {
            throw new RuntimeException("账户余额不足，无法购买！");
        }
        bookDao.updateStockById(bookId, num);
        accountDao.out(accountId, bookPrice);
    }
}
