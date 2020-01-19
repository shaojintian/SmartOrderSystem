package cn.shaojintian.smartordersys;


import cn.shaojintian.smartordersys.model.Coffee;
import cn.shaojintian.smartordersys.model.CoffeeOrder;
import cn.shaojintian.smartordersys.model.OrderState;
import cn.shaojintian.smartordersys.repository.CoffeeRepository;
import cn.shaojintian.smartordersys.service.CoffeeOrderService;
import cn.shaojintian.smartordersys.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Optional;

@Slf4j
@EnableTransactionManagement
@SpringBootApplication
@EnableJpaRepositories
public class App implements ApplicationRunner {
    @Autowired
    private CoffeeRepository coffeeRepository;
    @Autowired
    private CoffeeService coffeeService;
    @Autowired
    private CoffeeOrderService orderService;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("All Coffee: {}", coffeeRepository.findAll());

        Optional<Coffee> latte = coffeeService.findOneCoffee("Latte");
        if (latte.isPresent()) {
            CoffeeOrder order = orderService.createOrder("sjt", latte.get());
            log.info("Update INIT to PAID : {}", orderService.updateState(order, OrderState.PAID));
            log.info("Update PAID to INIT : {}", orderService.updateState(order, OrderState.INIT));
        }


    }

}
