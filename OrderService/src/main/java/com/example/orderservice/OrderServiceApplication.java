package com.example.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.orderservice.model.Order;
import com.example.orderservice.repositories.OrderRepository;
@SpringBootApplication
public class OrderServiceApplication {

    private final OrderRepository orderRepository;
    private final Faker faker = new Faker();

    public OrderServiceApplication(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            for (int i = 1; i <= 10; i++) {
                Order order = createFakeOrder();
                orderRepository.save(order);
            }
        };
    }

    private Order createFakeOrder() {
        Order order = new Order();
        order.setOrderDate(faker.date().past(10, java.util.concurrent.TimeUnit.DAYS).toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDateTime());
        order.setStatus(faker.lorem().word());
        order.setShippingAddress(faker.address().fullAddress());
        return order;
    }
}
