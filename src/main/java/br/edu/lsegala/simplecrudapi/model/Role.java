package br.edu.lsegala.simplecrudapi.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_CLIENT;

    public String getAuthority() {
        return name();
    }

}