package br.com.DriveGo.drivego.core.enums;

public enum UserStatus {

    PENDING("PENDING"),
    ACTIVE("ACTIVE"),
    BLOCKED("BLOCKED");

    private final String label;

    UserStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
