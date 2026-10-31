package com.example.canteen.controller;
import com.example.canteen.entity.MenuItem;
import com.example.canteen.repository.MenuItemRepository;
import com.example.canteen.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
@Controller
@RequestMapping("/staff")
public class StaffController {
    private final MenuItemRepository menu; private final OrderService orders;
    public StaffController(MenuItemRepository menu,OrderService orders){this.menu=menu;this.orders=orders;}
    @GetMapping("/orders") public String orders(Model model){model.addAttribute("orders",orders.allOrders());return "staff-orders";}
    @PostMapping("/orders/{id}/status") public String status(@PathVariable Long id,@RequestParam String status){orders.updateStatus(id,status);return "redirect:/staff/orders";}
    @GetMapping("/menu") public String menu(Model model){model.addAttribute("items",menu.findAll());return "staff-menu";}
    @PostMapping("/menu/add") public String add(@RequestParam String name,@RequestParam String category,@RequestParam BigDecimal price){
        menu.save(new MenuItem(name,category,price));return "redirect:/staff/menu";
    }
    @PostMapping("/menu/{id}/availability") public String availability(@PathVariable Long id){
        MenuItem item=menu.findById(id).orElseThrow();item.setAvailable(!item.isAvailable());menu.save(item);return "redirect:/staff/menu";
    }
}
