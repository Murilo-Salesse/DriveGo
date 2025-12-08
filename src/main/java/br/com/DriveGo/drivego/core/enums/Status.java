package br.com.DriveGo.drivego.core.enums;

public enum Status {
    AVAILABLE("AVAILABLE"),
    RENTED("RENTED"),
    MAINTENANCE("MAINTENANCE"),
    RESERVED("RESERVED");

    private final String label;

    Status(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
