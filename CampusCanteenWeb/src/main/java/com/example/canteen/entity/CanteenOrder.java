package com.example.canteen.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="canteen_orders")
public class CanteenOrder {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @ManyToOne(optional=false) private AppUser student;
    @Column(nullable=false) private LocalDateTime orderTime=LocalDateTime.now();
    @Column(nullable=false) private String status="PLACED";
    @Column(nullable=false) private BigDecimal total=BigDecimal.ZERO;
    @OneToMany(mappedBy="order",cascade=CascadeType.ALL,orphanRemoval=true)
    private List<OrderItem> items=new ArrayList<>();
    public CanteenOrder(){}
    public Long getId(){return id;}
    public AppUser getStudent(){return student;} public void setStudent(AppUser student){this.student=student;}
    public LocalDateTime getOrderTime(){return orderTime;} public String getStatus(){return status;} public void setStatus(String status){this.status=status;}
    public BigDecimal getTotal(){return total;} public void setTotal(BigDecimal total){this.total=total;}
    public List<OrderItem> getItems(){return items;}
    public void addItem(OrderItem item){items.add(item);item.setOrder(this);}
}
