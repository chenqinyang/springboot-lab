package qy.lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import qy.lab.jpa.LabRepository;
import qy.lab.jpa.Person;

@RestController
public class RestSvcController {

    @Autowired
    private LabRepository labRepository;

    @GetMapping("/hello")
    String hello() {
        return "Hello spring-boot.";
    }

    @GetMapping("/query/{id}")
//    @RequestMapping(value = "/query", method = RequestMethod.GET)
    String query(@PathVariable("id") Long id) {

        Person someone = labRepository.findById(id).orElse(new Person(Long.valueOf("0"), "NotFound"));

        System.out.println("++++Test: someone is " + someone.getName());

        return someone.getName();
    }
}