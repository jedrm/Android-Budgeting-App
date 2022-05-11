package com.example.budgetingapp.model;

import android.content.Context;

import androidx.room.*;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/*
Database class
    - Creates the database
 */
@Database(entities = {Transaction.class}, version=1)
@TypeConverters({Converters.class})
public abstract class BudgetingAppDatabase extends RoomDatabase {
    public abstract TransactionDao transaction_dao();

    private static volatile BudgetingAppDatabase INSTANCE;

    public static BudgetingAppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (BudgetingAppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            BudgetingAppDatabase.class, "transactions")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
