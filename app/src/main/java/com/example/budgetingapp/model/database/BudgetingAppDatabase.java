package com.example.budgetingapp.model.database;

import androidx.room.*;

import com.example.budgetingapp.model.TransactionItem;
import com.example.budgetingapp.model.dao.TransactionDao;

@Database(entities = {TransactionItem.class}, version=1)
public abstract class BudgetingAppDatabase {
    public abstract TransactionDao transaction_dao();
}
