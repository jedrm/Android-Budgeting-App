package com.example.budgetingapp.model;

import androidx.room.*;

import com.example.budgetingapp.model.TransactionItem;
import com.example.budgetingapp.model.TransactionDao;

@Database(entities = {TransactionItem.class}, version=1)
public abstract class BudgetingAppDatabase {
    public abstract TransactionDao transaction_dao();
}
