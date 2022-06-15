package com.example.catatankeuangan;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

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


}
