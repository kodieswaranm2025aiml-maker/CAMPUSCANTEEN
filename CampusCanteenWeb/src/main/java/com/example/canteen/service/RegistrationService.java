package com.example.canteen.service;
import com.example.canteen.entity.AppUser;
import com.example.canteen.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class RegistrationService {
    private final UserRepository users; private final PasswordEncoder encoder;
    public RegistrationService(UserRepository users,PasswordEncoder encoder){this.users=users;this.encoder=encoder;}
    public void registerStudent(String name,String username,String password){
        if(users.existsByUsername(username)) throw new IllegalArgumentException("Username already exists");
        users.save(new AppUser(name,username,encoder.encode(password),"STUDENT"));
    }
}
