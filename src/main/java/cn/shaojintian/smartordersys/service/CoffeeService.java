package cn.shaojintian.smartordersys.service;

import cn.shaojintian.smartordersys.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class CoffeeService {
    @Autowired
    private CoffeeRepository coffeeRepository;

    /*
    public Optional<Coffee> findOneCoffee(String name){
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", exact().ignoreCase());
        Optional<Coffee> coffee = coffeeRepository.findOne(
                Example.of(Coffee.builder().name(name).build(),matcher));
        log.info("Coffee Found : {}" ,coffee);
        return coffee;
    }

     */
}
