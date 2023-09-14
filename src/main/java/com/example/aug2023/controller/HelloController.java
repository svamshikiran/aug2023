package com.example.aug2023.controller;

import com.example.aug2023.model.Message;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/greet")
    public String sayHello(){
        return "WELCOME TO THE SPRINGBOOT FRAMEWORK";
    }

    //   http://localhost:2023/aug2023/hello/greet/VAMSHI
    @GetMapping("/greet/{name}")
    public String sayHello(@PathVariable("name") String inputName){
        return "HI "+inputName+", WELCOME TO THE SPRINGBOOT FRAMEWORK";
    }

    //   http://localhost:2023/aug2023/hello/greetwithparameter?name=VAMSHI
    @GetMapping("/greetwithparameter")
    public String sayHelloWithParameter(@RequestParam("name") String inputName){
        return "HI "+inputName+", WELCOME TO THE SPRINGBOOT FRAMEWORK";
    }

    @PostMapping("/post")
    public void postMessage(@RequestBody Message message) {
        System.out.println("Message Id: "+message.getMsgid());
        System.out.println("Message: "+message.getMsg());
    }
}

//@RestController
//@Service
//@Repository
//@Component
//@Bean
