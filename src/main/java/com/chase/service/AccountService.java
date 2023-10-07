package com.chase.service;

import com.chase.enums.AccountType;
import com.chase.model.Account;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface AccountService {

    Account createNewAccount(BigDecimal balance, Date createDate, AccountType accountType, Long userId);

    List<Account> listAllAccount();

    void deleteAccount(UUID uuid);

    void activateAccount(UUID uuid);
}
