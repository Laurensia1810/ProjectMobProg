package com.example.catatankeuangan;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    //buat databasenya
    public DBHelper(@Nullable Context context) {
        super(context, "CatatanKeuangan", null, 1);
    }

    @Override
    //create table transactions
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTransactionTableQuery = "CREATE TABLE transactions (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE, ket, amount, date)";
        sqLiteDatabase.execSQL(createTransactionTableQuery);
    }

    @Override
    //on upgrade
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS transactions");
        onCreate(sqLiteDatabase);
    }
}
