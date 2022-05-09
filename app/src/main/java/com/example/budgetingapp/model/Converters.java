package com.example.budgetingapp.model;

import androidx.room.TypeConverter;
import java.util.Date;

/*
Converter class for converting date into DATETIME for SQLite
 */
public class Converters {
    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
