package com.example.budgetingapp.model;

import java.util.Objects;

public class Transaction {
    private String date;
    private int amount;
    private String merchantName;
    private TransactionType transactionType;

    public Transaction(int amount, String merchantName, TransactionType transactionType) {
        this.amount = amount;
        this.merchantName = merchantName;
        this.transactionType = transactionType;
    }

    public Transaction(String date, int amount, String merchantName, TransactionType transactionType) {
        this.date = date;
        this.amount = amount;
        this.merchantName = merchantName;
        this.transactionType = transactionType;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public String getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return amount == that.amount && date.equals(that.date) && merchantName.equals(that.merchantName) && transactionType == that.transactionType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount, merchantName, transactionType);
    }
}
