package com.example.canteen.service;
import com.example.canteen.entity.*;
import com.example.canteen.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
@Component
public class DataInitializer implements CommandLineRunner {
    private final UserRepository users; private final MenuItemRepository menu; private final PasswordEncoder encoder;
    public DataInitializer(UserRepository users,MenuItemRepository menu,PasswordEncoder encoder){this.users=users;this.menu=menu;this.encoder=encoder;}
    @Override public void run(String... args){
        if(!users.existsByUsername("staff")) users.save(new AppUser("Canteen Staff","staff",encoder.encode("staff123"),"STAFF"));
        if(menu.count()==0){
            menu.save(new MenuItem("Idli (2 pcs)","Breakfast",new BigDecimal("25.00")));
            menu.save(new MenuItem("Dosa","Breakfast",new BigDecimal("40.00")));
            menu.save(new MenuItem("Veg Meals","Lunch",new BigDecimal("80.00")));
            menu.save(new MenuItem("Lemon Rice","Lunch",new BigDecimal("55.00")));
            menu.save(new MenuItem("Tea","Beverages",new BigDecimal("12.00")));
            menu.save(new MenuItem("Fresh Lime Juice","Beverages",new BigDecimal("25.00")));
        }
    }
}
