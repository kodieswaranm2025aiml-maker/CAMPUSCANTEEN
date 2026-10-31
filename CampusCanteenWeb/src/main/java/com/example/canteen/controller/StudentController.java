package com.example.canteen.controller;
import com.example.canteen.repository.MenuItemRepository;
import com.example.canteen.service.OrderService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/student")
public class StudentController {
    private final MenuItemRepository menu; private final OrderService orders;
    public StudentController(MenuItemRepository menu,OrderService orders){this.menu=menu;this.orders=orders;}
    @GetMapping("/menu") public String menu(Model model){model.addAttribute("items",menu.findByAvailableTrueOrderByCategoryAscNameAsc());return "student-menu";}
    @PostMapping("/order") public String order(@RequestParam(required=false) Long[] itemIds,@RequestParam(required=false) Integer[] quantities,Authentication auth,Model model){
        try {var order=orders.placeOrder(auth.getName(),itemIds,quantities); model.addAttribute("order",order);return "order-success";}
        catch(IllegalArgumentException ex){model.addAttribute("error",ex.getMessage());model.addAttribute("items",menu.findByAvailableTrueOrderByCategoryAscNameAsc());return "student-menu";}
    }
    @GetMapping("/orders") public String myOrders(Authentication auth,Model model){model.addAttribute("orders",orders.studentOrders(auth.getName()));return "my-orders";}
}
