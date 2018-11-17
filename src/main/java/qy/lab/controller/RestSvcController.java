package qy.lab.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestSvcController {
    @GetMapping("/hello")
    String hello() {
        return "Hello spring-boot.";
    }
}