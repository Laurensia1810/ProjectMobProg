package com.example.catatankeuangan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class AddTransaction extends AppCompatActivity {
    private final EntityHelper th = new EntityHelper(this);
    EditText keterangan, jumlah;
    Button income, expense;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction);

        income = findViewById(R.id.income);
        expense = findViewById(R.id.expense);
        keterangan = findViewById(R.id.keterangan);
        jumlah = findViewById(R.id.jumlah);

        String ket = keterangan.getText().toString();
        String amt = jumlah.getText().toString();
        Integer amtInt = Integer.parseInt(amt);
        Date today = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
        String todayStr = dateFormat.format(today);

        income.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                th.open();
                th.insertTransaction(ket, amtInt, todayStr);
                th.close();
                Intent intent = new Intent(AddTransaction.this, MainActivity.class);
            }
        });

        expense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                th.open();
                th.insertTransaction(ket, -1 * amtInt, todayStr);
                th.close();
                Intent intent = new Intent(AddTransaction.this, MainActivity.class);
            }
        });
    }
}