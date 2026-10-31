# Architecture

Campus Canteen follows layered Spring Boot MVC architecture.

Browser / Thymeleaf UI → Controller → Service → Repository → JPA/Hibernate → MySQL

Entities:
- AppUser: student/staff accounts
- MenuItem: food item, category, price and availability
- CanteenOrder: student order, time, status and total
- OrderItem: menu item, quantity and line total

Main business flow:
1. Student signs in and browses available menu items.
2. Student chooses quantities and submits an order.
3. OrderService validates quantities and item availability.
4. OrderService calculates line totals and overall total.
5. Repository saves the order and its order items.
6. Staff sees the queue and updates the order status.
