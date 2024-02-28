package org.example.model;

public enum TransactionType {
    DEPOSIT("dépôt"),
    WITHDRAWAL("retrait");

    private final String label;

    TransactionType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }
}
