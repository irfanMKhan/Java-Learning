package com.topic.module.userManagement.model.dto;

import com.topic.module.userManagement.model.AbstractDTO;
import com.topic.module.userManagement.model.security.UserGrantedAuthority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends AbstractDTO implements UserDetails {

    private Long id;

    private String username;
    private String password;

    private String firstName;
    private String lastName;

    private String email;
    private String mobile;
    private String occupation;
    private String companyName;

    private Long totalRoles;
    private String roleName;
    private Boolean isTokenExpired;

    private String role_xml;
    private List<UserGrantedAuthority> authorities;

    /**
     * author : MD Irfan Khan;
     * for User Build
     */
    public UserDTO(Long id, String username, String password, List<UserGrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    /**
     * author : MD Irfan Khan
     * build user for authentication
     */
    public static UserDTO build(UserDTO user, List<RoleDTO> roles) {
        List<UserGrantedAuthority> authorities = roles.stream()
                .map(role -> new UserGrantedAuthority(
                                role.getId(),
                                role.getName(),
                                role.getDescription(),
                                role.getPriority()
                        )
                ).collect(Collectors.toList());

        return new UserDTO(user.getId(), user.getUsername(), user.getPassword(), authorities);
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public boolean isAccountNonExpired() {
        return false;
    }

    public boolean isAccountNonLocked() {
        return false;
    }

    public boolean isCredentialsNonExpired() {
        return false;
    }

    public boolean isEnabled() {
        return false;
    }
}
