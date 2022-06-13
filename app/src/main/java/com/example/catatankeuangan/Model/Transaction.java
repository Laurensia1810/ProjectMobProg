package com.example.catatankeuangan.Model;

public class Transaction {
    private String id;
    private String ket;
    private String amount;
    private String date;

    public Transaction(String id, String ket, String amount, String date) {
        this.id = id;
        this.ket = ket;
        this.amount = amount;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
