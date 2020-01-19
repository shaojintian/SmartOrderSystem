package cn.shaojintian.smartordersys.repository;

import cn.shaojintian.smartordersys.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoffeeRepository extends JpaRepository<Coffee,Long> {


}
