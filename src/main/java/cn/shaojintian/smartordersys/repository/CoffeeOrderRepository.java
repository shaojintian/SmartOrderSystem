package cn.shaojintian.smartordersys.repository;

import cn.shaojintian.smartordersys.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder,Long> {

}
