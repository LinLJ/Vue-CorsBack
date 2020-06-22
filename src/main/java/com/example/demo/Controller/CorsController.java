package com.example.demo.Controller;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("")
public class CorsController {

    @ResponseBody
    @GetMapping("/cors")
    public String corsParam(){
        return "我从127.0.0.1:8081后台返回";
    }
}
