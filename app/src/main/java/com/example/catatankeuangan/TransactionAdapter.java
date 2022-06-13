package com.example.catatankeuangan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.catatankeuangan.Model.Transaction;

import java.util.Vector;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.ViewHolder>{
    private Context ctx;
    private Vector<Transaction> transactions;

    public TransactionAdapter(Context ctx) {
        this.ctx = ctx;
    }

    public void setTransactions(Vector<Transaction> transactions) {
        this.transactions = transactions;
    }

    @NonNull

    @Override
    public TransactionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.list_history, parent,false );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionAdapter.ViewHolder holder, int position) {
        holder.tvket.setText(transactions.get(position).getKet());
        holder.tvdate.setText(transactions.get(position).getDate());
        holder.tvamount.setText(transactions.get(position).getAmount());
    }

    @Override
    public int getItemCount() {
        return transactions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvket, tvdate, tvamount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvket = itemView.findViewById(R.id.text_ket);
            tvdate = itemView.findViewById(R.id.date);
            tvamount = itemView.findViewById(R.id.amount);
        }
    }
}
