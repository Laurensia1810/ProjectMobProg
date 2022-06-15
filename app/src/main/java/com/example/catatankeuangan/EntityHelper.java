package com.example.catatankeuangan;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.catatankeuangan.Model.Transaction;

import java.util.ArrayList;

public class EntityHelper {
    public Context context;
    public DBHelper dbhelper;
    public SQLiteDatabase db;

    public EntityHelper (Context context) {
        this.context = context;
    }

    public void open() throws SQLException {
        dbhelper = new DBHelper(context);
        db = dbhelper.getWritableDatabase();
    }

    public void close() throws SQLException {
        dbhelper.close();
    }

    public ArrayList<Transaction> getUsers() {
        ArrayList<Transaction> transactions = new ArrayList<>();
        String getTransactions = "SELECT * FROM transactions";
        Cursor cursor = db.rawQuery(getTransactions, null);
        cursor.moveToFirst();

        Transaction t;
        Integer id;
        String ket;
        String amount;
        String date;

        if(cursor.getCount() > 0) {
            do{
                id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                ket = cursor.getString(cursor.getColumnIndexOrThrow("ket"));
                amount = cursor.getString(cursor.getColumnIndexOrThrow("amount"));
                date = cursor.getString(cursor.getColumnIndexOrThrow("date"));

                t = new Transaction(id, ket, amount, date);
                transactions.add(t);
                cursor.moveToNext();
            }while(!cursor.isAfterLast());
        }

        return transactions;
    }

    public void insertTransaction() {

    }
}
