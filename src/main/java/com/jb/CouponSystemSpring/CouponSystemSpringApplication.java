package com.jb.CouponSystemSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class CouponSystemSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouponSystemSpringApplication.class, args);
    }

    @GetMapping
    public String hi() {
        return "Meow!";
    }
}
