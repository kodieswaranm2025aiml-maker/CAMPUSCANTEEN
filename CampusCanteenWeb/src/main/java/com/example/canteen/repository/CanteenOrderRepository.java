package com.example.canteen.repository;
import com.example.canteen.entity.CanteenOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface CanteenOrderRepository extends JpaRepository<CanteenOrder,Long>{ List<CanteenOrder> findByStudentUsernameOrderByOrderTimeDesc(String username); List<CanteenOrder> findAllByOrderByOrderTimeDesc(); }
