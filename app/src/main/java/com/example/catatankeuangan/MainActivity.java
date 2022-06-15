package com.example.catatankeuangan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final EntityHelper th = new EntityHelper(this);
    TextView budget;
    Button add_income;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        budget = findViewById(R.id.budget);
        add_income = findViewById(R.id.add_income);

        th.open();
        Integer amount = th.sumAmount();
        th.close();

        budget.setText(amount);

        add_income.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddTransaction.class);
                startActivity(intent);
            }
        });
    }
}