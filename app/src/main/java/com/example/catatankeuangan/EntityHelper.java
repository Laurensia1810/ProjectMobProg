package com.example.catatankeuangan;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.catatankeuangan.Model.Transaction;

import java.util.ArrayList;
import java.util.Vector;

public class EntityHelper {
    public Context context;
    public DBHelper dbhelper;
    public SQLiteDatabase db;

    //connect context
    public EntityHelper (Context context) {
        this.context = context;
    }

    //buat open ketika mau akses db
    public void open() throws SQLException {
        dbhelper = new DBHelper(context);
        db = dbhelper.getWritableDatabase();
    }

    //buat close ketika mau selesai akses db
    public void close() throws SQLException {
        dbhelper.close();
    }

    //buat tampilin keseluruhan transaksi
    public Vector<Transaction> getTransaction() {
        Vector<Transaction> transactions = new Vector<>();
        String getTransactions = "SELECT * FROM transactions";
        Cursor cursor = db.rawQuery(getTransactions, null);
        cursor.moveToFirst();

        Transaction t;
        Integer id;
        String ket;
        Integer amount;
        String date;

        if(cursor.getCount() > 0) {
            do{
                id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                ket = cursor.getString(cursor.getColumnIndexOrThrow("ket"));
                amount = cursor.getInt(cursor.getColumnIndexOrThrow("amount"));
                date = cursor.getString(cursor.getColumnIndexOrThrow("date"));

                t = new Transaction(id, ket, amount, date);
                transactions.add(t);
                cursor.moveToNext();
            }while(!cursor.isAfterLast());
        }

        return transactions;
    }

    //buat masukin transaksi baru
    public void insertTransaction(String ket, Integer amount, String date) {
        String insertTransactionQuery = "INSERT INTO transactions (ket, amount, date) VALUES (" + ket + "', '" + amount + "', '" + date + "')";
        db.execSQL(insertTransactionQuery);
    }

    //buat tampilin tabungan tersisa
    public Integer sumAmount() {
        String sumAmountQuery = "SELECT * FROM transactions";
        Cursor cursor = db.rawQuery(sumAmountQuery, null);
        cursor.moveToFirst();

        Integer sumAmount = 0;

        if(cursor.getCount() > 0) {
            do{
                sumAmount = sumAmount + cursor.getInt(cursor.getColumnIndexOrThrow("amount"));
                cursor.moveToNext();
            }while(!cursor.isAfterLast());
        }

        return sumAmount;
    }
}
