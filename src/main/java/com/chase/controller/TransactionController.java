package com.chase.controller;

import com.chase.model.Transaction;
import com.chase.service.AccountService;
import com.chase.service.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TransactionController {

    private final AccountService accountService;
    private final TransactionService transactionService;

    public TransactionController(AccountService accountService, TransactionService transactionService) {
        this.accountService = accountService;
        this.transactionService = transactionService;
    }


    @GetMapping("/make-transfer")
    public String getMakeTransfer(Model model) {
        model.addAttribute("transaction", Transaction.builder().build());
        model.addAttribute("accounts", accountService.listAllAccount());
        model.addAttribute("lastTransactions", transactionService.last10Transactions());
        return "transaction/make-transfer";
    }

    @PostMapping("/make-transfer")
    public String saveTransfer(@ModelAttribute("transactions") Transaction transaction, Model model) {
        model.addAttribute("transaction", Transaction.builder().build());
        model.addAttribute("accounts", accountService.listAllAccount());
        model.addAttribute("lastTransactions", transactionService.last10Transactions());
        return "transaction/make-transfer";
    }
}
