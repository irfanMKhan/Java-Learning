package com.topic.module.userManagement.model.dto;

import com.topic.module.userManagement.model.AbstractDTO;
import com.topic.module.userManagement.model.security.CustomGrantedAuthority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
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
    private Boolean isActive;
    private Boolean isDeleted;
    private Boolean isTokenExpired;
    private String createdBy;
    private LocalDateTime createdDate;
    private String updatedBy;
    private LocalDateTime updatedDate;
    private String deletedBy;
    private LocalDateTime deletedDate;
    private String role_xml;
    private List<CustomGrantedAuthority> authorities;

    /**
     * author : MD Irfan Khan;
     * for User Build
     */
    public UserDTO(Long id, String username, String password, List<CustomGrantedAuthority> authorities) {
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
        List<CustomGrantedAuthority> authorities = roles.stream()
                .map(role -> new CustomGrantedAuthority(
                                role.getId(),
                                role.getRoleName(),
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
