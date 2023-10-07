package com.chase.service;

import com.chase.model.Account;
import com.chase.model.Transaction;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface TransactionService {

    Transaction makeTransfer(Account sender, Account receiver, BigDecimal amount, Date creationDate, String message);

    List<Transaction> findAllTransaction();

    List<Transaction> last10Transactions();
}
