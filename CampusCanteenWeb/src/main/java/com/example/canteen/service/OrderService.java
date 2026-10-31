package com.example.canteen.service;

import com.example.canteen.entity.*;
import com.example.canteen.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {
    private final MenuItemRepository menu; private final CanteenOrderRepository orders; private final UserRepository users;
    public OrderService(MenuItemRepository menu,CanteenOrderRepository orders,UserRepository users){this.menu=menu;this.orders=orders;this.users=users;}
    @Transactional
    public CanteenOrder placeOrder(String username,Long[] itemIds,Integer[] quantities){
        if(itemIds==null || quantities==null || itemIds.length==0 || itemIds.length!=quantities.length) throw new IllegalArgumentException("Select at least one menu item");
        AppUser student=users.findByUsername(username).orElseThrow();
        CanteenOrder order=new CanteenOrder(); order.setStudent(student); BigDecimal total=BigDecimal.ZERO;
        for(int i=0;i<itemIds.length;i++){
            if(quantities[i]==null || quantities[i]<0 || quantities[i]>20) throw new IllegalArgumentException("Quantity must be between 0 and 20");
            if(quantities[i]==0) continue;
            MenuItem item=menu.findById(itemIds[i]).orElseThrow(()->new IllegalArgumentException("Menu item not found"));
            if(!item.isAvailable()) throw new IllegalArgumentException(item.getName()+" is unavailable");
            BigDecimal line=item.getPrice().multiply(BigDecimal.valueOf(quantities[i]));
            order.addItem(new OrderItem(item,quantities[i],line)); total=total.add(line);
        }
        if(order.getItems().isEmpty()) throw new IllegalArgumentException("Choose a quantity for at least one item");
        order.setTotal(total); return orders.save(order);
    }
    public List<CanteenOrder> studentOrders(String username){return orders.findByStudentUsernameOrderByOrderTimeDesc(username);}
    public List<CanteenOrder> allOrders(){return orders.findAllByOrderByOrderTimeDesc();}
    public void updateStatus(Long id,String status){
        if(!List.of("PREPARING","READY","COMPLETED","CANCELLED").contains(status)) throw new IllegalArgumentException("Invalid order status");
        CanteenOrder order=orders.findById(id).orElseThrow(()->new IllegalArgumentException("Order not found"));
        order.setStatus(status); orders.save(order);
    }
}
