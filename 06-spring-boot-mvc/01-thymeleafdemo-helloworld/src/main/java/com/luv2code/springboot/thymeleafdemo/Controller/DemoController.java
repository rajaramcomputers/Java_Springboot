package com.luv2code.springboot.thymeleafdemo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    @GetMapping("/hello")
    public String sayHello(Model theModel){
    theModel.addAttribute("theDate",java.time.LocalTime.now());
    return "helloworld";
    }
}