package com.example.Project.Service;

import com.example.Project.dto.CustomUserDetails;
import org.apache.groovy.parser.antlr4.util.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;

public class CustomUserDetailService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(StringUtils.isEmpty(username))
            throw new UsernameNotFoundException("User name is empty");

        //if you don't use authority based security, just add empty set
        Set<GrantedAuthority> authorities = new HashSet<>();
        CustomUserDetails userDetails = new CustomUserDetails(username, "", authorities);

        userDetails.setUsername(username);
        //here you can load user's data from DB or from
        //any other source and do:
        //userDetails.setFirstName(firstName);
        //userDetails.setLastName(lastName);

        return userDetails;
    }
}
