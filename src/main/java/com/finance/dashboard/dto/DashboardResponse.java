package com.finance.dashboard.dto;

public class DashboardResponse {

    private Double totalIncome;
    private Double totalExpense;
    private Double balance;

    public DashboardResponse(Double totalIncome, Double totalExpense, Double balance) {
        this.totalIncome = totalIncome;
        this.totalExpense = totalExpense;
        this.balance = balance;
    }

    public Double getTotalIncome() {
        return totalIncome;
    }

    public Double getTotalExpense() {
        return totalExpense;
    }

    public Double getBalance() {
        return balance;
    }
}