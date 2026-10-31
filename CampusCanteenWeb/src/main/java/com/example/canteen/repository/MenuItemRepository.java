package com.example.canteen.repository;
import com.example.canteen.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface MenuItemRepository extends JpaRepository<MenuItem,Long>{ List<MenuItem> findByAvailableTrueOrderByCategoryAscNameAsc(); }
