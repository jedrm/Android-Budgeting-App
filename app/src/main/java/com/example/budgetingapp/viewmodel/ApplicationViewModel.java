package com.example.budgetingapp.viewmodel;

import com.example.budgetingapp.model.BudgetingAppDatabase;
import com.example.budgetingapp.model.Transaction;

import android.content.Context;

import java.util.List;

/*
Create a view model instance and use these methods to work with the database
 */
public class ApplicationViewModel {
    public void insertToDatabase(Transaction transaction, Context context) {
        BudgetingAppDatabase.getInstance(context.getApplicationContext())
                .transaction_dao()
                .insertTransaction(transaction);
    }

    public void removeFromDatabase(Transaction transaction, Context context) {
        BudgetingAppDatabase.getInstance(context.getApplicationContext())
                .transaction_dao()
                .deleteTransaction(transaction);
    }

    public List<Transaction> getAllTransactions(Context context) {
        return BudgetingAppDatabase.getInstance(context.getApplicationContext())
                .transaction_dao()
                .getTransactions();
    }
}
