package com.yss;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @RequestMapping("/say")
    public  String sayHello(){
        return  "hello  fffff";
    }
}
