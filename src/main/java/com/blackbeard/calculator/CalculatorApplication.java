package com.blackbeard.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
@RestController
public class CalculatorApplication {
    
    private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

    public static void main(String[] args) {
        SpringApplication.run(CalculatorApplication.class, args);
    }

    // inline function
    @GetMapping("/")
    public String root(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
    
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
    
    @GetMapping("/sum")
    public int sum(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        return (a + b);
    }
    
    // Using a resource representation class
    @GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
