package io.acellab.official.service.web.app.startline.Config.Security;

public enum UserRole {
    STARTUP("startup_user", "ROLE_STARTUP_USER"),
    COMPANY("company_user", "ROLE_COMPANY_USER"),
    UNKNOWN("unknown", "ROLE_UNKNOWN");

    private final String databaseValue;
    private final String authorityName;

    UserRole(String databaseValue, String authorityName) {
        this.databaseValue = databaseValue;
        this.authorityName = authorityName;
    }

    public static String getAuthorityName(String databaseValue) {
        for (UserRole role : values()) {
            if (role.databaseValue.equals(databaseValue)) {
                return role.authorityName;
            }
        }
        return UNKNOWN.authorityName;
    }
}
