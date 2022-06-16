package com.example.catatankeuangan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.catatankeuangan.Model.Transaction;

import java.util.ArrayList;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    private final EntityHelper th = new EntityHelper(this);
    TextView budget;
    Button add_income;
    RecyclerView rv_history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connect widget ke id dan variabel
        budget = findViewById(R.id.budget);
        add_income = findViewById(R.id.add_income);
        rv_history = findViewById(R.id.rv_history);

        //akses db untuk ambil sisa tabungan
        th.open();
        Integer amount = th.sumAmount();
        th.close();

        //value dari db ditampilin
        budget.setText(amount);

        //ambil list transaksi dari db
        th.open();
        Vector<Transaction> tr = th.getTransaction();
        th.close();

        //tampilin data history
        TransactionAdapter adapter = new TransactionAdapter(MainActivity.this);
        adapter.setTransactions(tr);
        rv_history.setAdapter(adapter);
        rv_history.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        //intent buat pindah ke activity add transaction kalau mau tambah data
        add_income.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddTransaction.class);
                startActivity(intent);
            }
        });
    }
}