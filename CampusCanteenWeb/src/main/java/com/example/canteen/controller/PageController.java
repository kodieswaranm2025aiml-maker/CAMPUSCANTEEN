package com.example.canteen.controller;
import com.example.canteen.repository.MenuItemRepository;
import com.example.canteen.repository.CanteenOrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class PageController {
    private final MenuItemRepository menu; private final CanteenOrderRepository orders;
    public PageController(MenuItemRepository menu,CanteenOrderRepository orders){this.menu=menu;this.orders=orders;}
    @GetMapping("/") public String home(){return "redirect:/login";}
    @GetMapping("/login") public String login(){return "login";}
    @GetMapping("/dashboard") public String dashboard(Model model){
        model.addAttribute("menuCount",menu.count()); model.addAttribute("orderCount",orders.count()); return "dashboard";
    }
}
