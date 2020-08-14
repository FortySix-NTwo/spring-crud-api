package org.fortysixntwo.user.security;

import static org.fortysixntwo.user.security.ApplicationUserRolePermissions.USER_READ;
import static org.fortysixntwo.user.security.ApplicationUserRolePermissions.USER_WRITE;

import java.util.Set;
import java.util.stream.Collectors;
import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum ApplicationUserRole {
  USER(Sets.newHashSet(USER_READ, USER_WRITE)),
  ADMIN(Sets.newHashSet(USER_READ, USER_WRITE));

	private final Set<ApplicationUserRolePermissions> permissions;

    ApplicationUserRole(Set<ApplicationUserRolePermissions> permissions) {
      this.permissions = permissions;
    }

    public Set<ApplicationUserRolePermissions> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
      Set<SimpleGrantedAuthority> permissions = getPermissions()
          .stream()
          .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
          .collect(Collectors.toSet());
        
      permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
      return permissions;
    }
}