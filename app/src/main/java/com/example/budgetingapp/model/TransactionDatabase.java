package com.example.budgetingapp.model;

import java.util.Objects;

public class TransactionDatabase {
    private String url;

    // TODO: Connect the program to the database in the constructor
    public TransactionDatabase(String url) {
        this.url = url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "TransactionDatabase{" +
                "url='" + url + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionDatabase that = (TransactionDatabase) o;
        return url.equals(that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url);
    }
}
