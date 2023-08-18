package org.example.exos.jdbc2.model;

public enum TransactionType {
    DEPOSIT("dépôt"),
    WITHDRAWAL("retrait");

    final String text;

    TransactionType(String text) {
        this.text = text;
    }
}
