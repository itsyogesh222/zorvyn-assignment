package com.finance.dashboard.controller;

import com.finance.dashboard.dto.DashboardResponse;
import com.finance.dashboard.entity.Transaction;
import com.finance.dashboard.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public Transaction create(@RequestBody Transaction transaction) {
        return transactionService.create(transaction);
    }

    @GetMapping
    public List<Transaction> getAll() {
        return transactionService.getAll();
    }
    @PutMapping("/{id}")
    public Transaction update(@PathVariable Long id, @RequestBody Transaction t) {
        return transactionService.update(id, t);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        transactionService.delete(id);
        return "Deleted";
    }

    @GetMapping("/summary")
    public DashboardResponse summary() {
        return transactionService.getSummary();
    }
}