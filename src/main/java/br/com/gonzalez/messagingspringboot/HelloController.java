package br.com.gonzalez.messagingspringboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class HelloController {

    private HelloProducer service;

    public HelloController(HelloProducer service){
        this.service = service;
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        service.sendMessage("Hello, " + name);
        return "OK";
    }

}
