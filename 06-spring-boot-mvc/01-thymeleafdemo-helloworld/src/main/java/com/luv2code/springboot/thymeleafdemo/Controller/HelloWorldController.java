package com.luv2code.springboot.thymeleafdemo.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @GetMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    @GetMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    @GetMapping("/processFormVersionTwo")
    public String processFormVersionTwo(HttpServletRequest httpServletRequest, Model theModel)
    {
        String theName=httpServletRequest.getParameter("studentName");
        theName=theName.toUpperCase();
        String res="CSK player "+theName;
        theModel.addAttribute("message",res);
        return "helloworld";
    }

    @PostMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model theModel)
    {
        theName=theName.toUpperCase();
        String res="CSK player V3 "+theName;
        theModel.addAttribute("message",res);
        return "helloworld";
    }
}
