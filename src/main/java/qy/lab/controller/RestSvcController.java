package qy.lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import qy.lab.AppConfig;
import qy.lab.jpa.LabRepository;
import qy.lab.jpa.Person;

import javax.servlet.http.HttpSession;

@RestController
public class RestSvcController {

    @Autowired
    AppConfig appConfig;

    @Autowired
    private LabRepository labRepository;

    @GetMapping("/hello")
    String hello(HttpSession session) {

        System.out.println("++++Test: config env = " + this.appConfig.getEnv());

        if (null != session.getAttribute("sskey")) {
            return (String) session.getAttribute("sskey");
        } else {
            return "Hello spring-boot.";
        }
    }

    @GetMapping("/save")
    String save(HttpSession session) {

        session.setAttribute("sskey", "redis value ah!");

        return "saved";
    }

    @GetMapping("/query/{id}")
//    @RequestMapping(value = "/query", method = RequestMethod.GET)
    String query(@PathVariable("id") Long id) {

        Person someone = labRepository.findById(id).orElse(new Person(Long.valueOf("0"), "NotFound"));

        System.out.println("++++Test: someone is " + someone.getName());

        return someone.getName();
    }
}