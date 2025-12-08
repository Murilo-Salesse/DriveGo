package br.com.DriveGo.drivego.core.enums;

public enum Roles {
    ADMIN("ADMIN"),
    OPERATOR("OPERADOR"),
    CLIENT("CLIENT"),
    INSTRUCTOR("INSTRUCTOR");

    private final String label;

    Roles(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}

