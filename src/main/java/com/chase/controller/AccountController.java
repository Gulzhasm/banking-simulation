package com.chase.controller;

import com.chase.enums.AccountType;
import com.chase.model.Account;
import com.chase.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.UUID;

@Controller
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/index")
    public String getIndexPage(Model model) {
        model.addAttribute("accountList", accountService.listAllAccount());
        return "account/index";
    }

    @GetMapping("/create-form")
    public String getCreateForm(Model model) {
        model.addAttribute("account", Account.builder().build());
        model.addAttribute("accountTypes", AccountType.values());
        return "account/create-account";
    }

    @PostMapping("/create")
    public String saveCreateForm(@ModelAttribute("account") Account account) {
        System.out.println(account);
        accountService.createNewAccount(account.getBalance(), new Date(), account.getAccountType(), account.getUserId());
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String getDeletedAccount(@PathVariable("id") UUID uuid){
        accountService.deleteAccount(uuid);
        return "redirect:/index";
    }

    @GetMapping("/activate/{id}")
    public String getActivatedAccount(@PathVariable("id") UUID uuid){
        accountService.activateAccount(uuid);
        return "redirect:/index";
    }

}
