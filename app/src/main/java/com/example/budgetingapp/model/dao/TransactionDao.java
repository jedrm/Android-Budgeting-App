package com.example.budgetingapp.model.dao;

import androidx.room.*;

import com.example.budgetingapp.model.TransactionItem;

@Dao
public interface TransactionDao {
    @Insert
    void insertTransaction(TransactionItem transaction_item);

    @Delete
    void deleteTransaction(TransactionItem transaction_item);
}
