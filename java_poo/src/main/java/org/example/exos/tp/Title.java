package org.example.exos.tp;

public enum Title {
    MRS("Mme"),
    MS("Mlle"),
    MR("M."),
    MX("Mx");

    private final String value;

    Title(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
