package br.com.DriveGo.drivego.core.enums;

public enum PaymentStatus {
    PENDING("PENDING"),
    PAID("PAID"),
    FAILED("FAILED");

    private final String label;

    PaymentStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
