package com.chase.service.impl;

import com.chase.enums.AccountStatus;
import com.chase.enums.AccountType;
import com.chase.model.Account;
import com.chase.repository.AccountRepository;
import com.chase.service.AccountService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createNewAccount(BigDecimal balance, Date createDate, AccountType accountType, Long userId) {
        //we need to create Account object
        Account account = Account.builder().id(UUID.randomUUID()).userId(userId)
                .balance(balance).accountType(accountType).creationDate(createDate)
                .accountStatus(AccountStatus.ACTIVE).build();
        //save into the database(repository)
        //return the object created
        return accountRepository.save(account);
    }

    @Override
    public List<Account> listAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    public void deleteAccount(UUID uuid) {
        Account account = accountRepository.findById(uuid);
        account.setAccountStatus(AccountStatus.DELETED);
    }

    @Override
    public void activateAccount(UUID uuid) {
        Account account = accountRepository.findById(uuid);
        account.setAccountStatus(AccountStatus.ACTIVE);
    }
}
