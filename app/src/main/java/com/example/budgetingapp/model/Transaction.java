package com.example.budgetingapp.model;

import java.util.Objects;
import java.util.Date;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

/*
Create a transaction object when dealing with transactions
 */
@Entity(tableName = "transactions")
@TypeConverters(Converters.class)
public class Transaction {

    @PrimaryKey(autoGenerate = true)
    private int transaction_id;

    @TypeConverters({Converters.class})
    private Date date;

    private int amount;

    private String merchantName;

    private String transactionType;

    public Transaction(Date date, int amount, String merchantName, String transactionType) {
        this.date = date;
        this.amount = amount;
        this.merchantName = merchantName;
        this.transactionType = transactionType;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return transaction_id == that.transaction_id && amount == that.amount && date.equals(that.date) && merchantName.equals(that.merchantName) && transactionType.equals(that.transactionType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transaction_id, date, amount, merchantName, transactionType);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transaction_id=" + transaction_id +
                ", date=" + date +
                ", amount=" + amount +
                ", merchantName='" + merchantName + '\'' +
                ", transactionType='" + transactionType + '\'' +
                '}';
    }
}
