package com.example.canteen.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class OrderItem {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @ManyToOne(optional=false) private MenuItem menuItem;
    @ManyToOne(optional=false) private CanteenOrder order;
    private int quantity;
    private BigDecimal lineTotal;
    public OrderItem(){}
    public OrderItem(MenuItem menuItem,int quantity,BigDecimal lineTotal){this.menuItem=menuItem;this.quantity=quantity;this.lineTotal=lineTotal;}
    public Long getId(){return id;}
    public MenuItem getMenuItem(){return menuItem;}
    public int getQuantity(){return quantity;}
    public BigDecimal getLineTotal(){return lineTotal;}
    public CanteenOrder getOrder(){return order;} public void setOrder(CanteenOrder order){this.order=order;}
}
