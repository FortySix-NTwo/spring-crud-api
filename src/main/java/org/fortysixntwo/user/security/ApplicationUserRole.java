package org.fortysixntwo.user.security;

public enum ApplicationUserRole {
  USER_READ("user:read"),
  USER_WRITE("user:write");

  private final String permission;

  ApplicationUserRole(String permission) {
    this.permission = permission;
  }

  public String getPermission() {
    return permission;
  }
}