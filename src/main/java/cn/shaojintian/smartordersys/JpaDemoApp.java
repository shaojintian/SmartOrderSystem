package cn.shaojintian.smartordersys;

import cn.shaojintian.smartordersys.model.Coffee;
import cn.shaojintian.smartordersys.model.CoffeeOrder;
import cn.shaojintian.smartordersys.model.OrderState;
import cn.shaojintian.smartordersys.repository.CoffeeOrderRepository;
import cn.shaojintian.smartordersys.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;
import java.util.Collections;

@Slf4j
@EnableJpaRepositories
@SpringBootApplication
public class JpaDemoApp implements ApplicationRunner {
    @Autowired
    private CoffeeRepository coffeeRepository;
    @Autowired
    private CoffeeOrderRepository coffeeOrderRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApp.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //initOrders();
    }

    public void initOrders() {
        Coffee espresso = Coffee.builder()
                .name("espresso")
                .price(Money.of(CurrencyUnit.of("CNY"), 20.0))
                .build();
        coffeeRepository.save(espresso);
        log.info("Coffee:{}", espresso);

        Coffee latte = Coffee.builder().name("latte")
                .price(Money.of(CurrencyUnit.of("CNY"), 30.0))
                .build();
        coffeeRepository.save(latte);
        log.info("Coffee:{}", latte);

        CoffeeOrder order = CoffeeOrder.builder()
                .customer("sjt")
                .items(Collections.singletonList(espresso))
                .state(OrderState.INIT)
                .build();
        coffeeOrderRepository.save(order);
        log.info("coffeeOrder: {}", order);

        order = CoffeeOrder.builder()
                .customer("sjt")
                .items(Arrays.asList(latte, espresso))
                .state(OrderState.INIT)
                .build();
        coffeeOrderRepository.save(order);
        log.info("coffeeOrder: {}", order);

    }
}
