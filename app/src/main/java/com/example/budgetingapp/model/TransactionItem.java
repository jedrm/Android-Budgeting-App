package com.example.budgetingapp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TransactionItem {
    @PrimaryKey(autoGenerate = true)
    public int transaction_id;

    public String datetime;

    public int amount;

    public String merchant_name;

    public TransactionType transaction_type;

    public TransactionItem() {
    }
}
