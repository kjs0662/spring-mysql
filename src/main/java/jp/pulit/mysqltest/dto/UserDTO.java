package jp.pulit.mysqltest.dto;

import org.springframework.security.core.GrantedAuthority;

import java.math.BigDecimal;
import java.util.Collection;

public class UserDTO extends org.springframework.security.core.userdetails.User {

    public UserDTO(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
}
