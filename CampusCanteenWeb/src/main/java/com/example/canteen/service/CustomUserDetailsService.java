package com.example.canteen.service;
import com.example.canteen.repository.UserRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository users;
    public CustomUserDetailsService(UserRepository users){this.users=users;}
    @Override public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return users.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User not found"));
    }
}
