package io.security.coresecurity.security.service;

import io.security.coresecurity.model.AccountEntity;
import io.security.coresecurity.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService  {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AccountEntity accountEntity = userRepository.findAccountEntityByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Could not found user : "  + username));

        ArrayList<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        roles.add(new SimpleGrantedAuthority(accountEntity.getRole()));

        return User.builder()
                .username(accountEntity.getUsername())
                .password(accountEntity.getPassword())
                .roles(accountEntity.getRole())
                .build();

    }
}
