package com.stefanov.herobattles.data.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;


@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity implements UserDetails {
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String email;
    @OneToOne(mappedBy = "user")
    private Hero hero;

    @Column
    private boolean isAccountNonExpired;

    @Column
    @Transient
    private boolean isAccountNonLocked;

    @Column
    @Transient
    private boolean isCredentialsNonExpired;

    @Column
    @Transient
    private boolean isEnabled;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getEmail() {
        return email;
    }

    public Hero getHero() {
        return hero;
    }
}
