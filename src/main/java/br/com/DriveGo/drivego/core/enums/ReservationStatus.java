package br.com.DriveGo.drivego.core.enums;

public enum ReservationStatus {
    PENDING("PENDING"),
    CONFIRMED("CONFIRMED"),
    CANCELLED("CANCELLED"),
    COMPLETED("COMPLETED");

    private final String label;

    ReservationStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
