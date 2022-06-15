package com.example.catatankeuangan.Model;

public class Transaction {
    private Integer id;
    private String ket;
    private String amount;
    private String date;

    public Transaction(Integer id, String ket, String amount, String date) {
        this.id = id;
        this.ket = ket;
        this.amount = amount;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
