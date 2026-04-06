package com.finance.dashboard.service;

import com.finance.dashboard.dto.DashboardResponse;
import com.finance.dashboard.entity.Transaction;
import com.finance.dashboard.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    // 🔹 Create
    public Transaction create(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    // 🔹 Get All
    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }

    // 🔹 Update
    public Transaction update(Long id, Transaction newData) {
        Transaction existing = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        existing.setAmount(newData.getAmount());
        existing.setType(newData.getType());
        existing.setCategory(newData.getCategory());
        existing.setDate(newData.getDate());
        existing.setNote(newData.getNote());

        return transactionRepository.save(existing);
    }

    // 🔹 Delete
    public void delete(Long id) {
        transactionRepository.deleteById(id);
    }

    // 🔹 Dashboard Summary
    public DashboardResponse getSummary() {
        List<Transaction> list = transactionRepository.findAll();

        double income = 0;
        double expense = 0;

        for (Transaction t : list) {
            if (t.getType() != null && t.getType().name().equals("INCOME")) {
                income += t.getAmount();
            } else if (t.getType() != null && t.getType().name().equals("EXPENSE")) {
                expense += t.getAmount();
            }
        }

        return new DashboardResponse(income, expense, income - expense);
    }
}