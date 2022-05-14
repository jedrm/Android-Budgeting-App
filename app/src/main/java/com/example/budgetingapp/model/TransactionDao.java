package com.example.budgetingapp.model;

import androidx.room.*;

import java.util.List;

/*
Data Access Object Class
    - Queries for the database are inside this class
 */
@Dao
public interface TransactionDao {
    @Insert
    void insertTransaction(Transaction transaction);

    @Delete
    void deleteTransaction(Transaction transaction);

    @Query("SELECT * FROM transactions ORDER BY date, transaction_id DESC")
    List<Transaction> getTransactions();

    // TODO: A map of the existing categories and how many transactions
    @Query("SELECT transactionType, COUNT(transaction_id) FROM transactions GROUP BY transactionType")
    List<TransactionCount> getCounts();
}
