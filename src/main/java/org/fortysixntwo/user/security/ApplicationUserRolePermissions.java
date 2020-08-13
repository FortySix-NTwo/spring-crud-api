package org.fortysixntwo.user.security;

import com.google.common.collect.Sets;
import java.util.Set;
import static org.fortysixntwo.user.security.ApplicationUserRole.*;

public enum ApplicationUserRolePermissions {
  USER(Sets.newHashSet()),
  ADMIN(Sets.newHashSet(USER_READ, USER_WRITE));

  public final Set<ApplicationUserRole> permissions;

  ApplicationUserRolePermissions(Set<ApplicationUserRole> permissions) {
    this.permissions = permissions;
  }

  public Set<ApplicationUserRole> getPermissions() {
    return permissions;
  }
}