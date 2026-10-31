package com.example.canteen.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

@Entity
public class MenuItem {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @NotBlank private String name;
    @NotBlank private String category;
    @NotNull @DecimalMin("1.00") private BigDecimal price;
    private boolean available=true;
    public MenuItem(){}
    public MenuItem(String name,String category,BigDecimal price){this.name=name;this.category=category;this.price=price;this.available=true;}
    public Long getId(){return id;}
    public String getName(){return name;} public void setName(String name){this.name=name;}
    public String getCategory(){return category;} public void setCategory(String category){this.category=category;}
    public BigDecimal getPrice(){return price;} public void setPrice(BigDecimal price){this.price=price;}
    public boolean isAvailable(){return available;} public void setAvailable(boolean available){this.available=available;}
}
