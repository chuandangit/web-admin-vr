package com.project.capstone.virtualmobileapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class TransactionRequestWrapper implements Serializable {

    @SerializedName("transaction")
    @Expose
    private Transaction transaction;

    @SerializedName("details")
    @Expose
    private List<TransactionDetail> details;


    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public List<TransactionDetail> getDetails() {
        return details;
    }

    public void setDetails(List<TransactionDetail> details) {
        this.details = details;
    }

    public TransactionRequestWrapper(Transaction transaction, List<TransactionDetail> details) {
        this.transaction = transaction;
        this.details = details;
    }
}
