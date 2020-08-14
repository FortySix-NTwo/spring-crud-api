package org.fortysixntwo.user.security;

public enum ApplicationUserRolePermissions {
    USER_READ("user:read"),
    USER_WRITE("user:write");

    private final String permission;

    ApplicationUserRolePermissions(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}