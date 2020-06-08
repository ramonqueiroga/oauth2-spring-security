package br.com.example.auth.security.oauth2poc.service;

import br.com.example.auth.security.oauth2poc.domain.Role;
import br.com.example.auth.security.oauth2poc.infra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        br.com.example.auth.security.oauth2poc.domain.User user = this.userRepository.findByUsername(username);
        List<String> roles = user.getRoles().stream().map(Role::getName).collect(Collectors.toList());
        return new User(user.getUsername(), "{bcrypt}$2a$10$yXmeUSpWCA.X9snxXS6C2eR8nrvIkaXqSJRINq0R1rFi7IqrgRhg.", new ArrayList<>());
    }
}