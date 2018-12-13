package com.uduck.multthread.controller;

import com.uduck.multthread.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello/{info}")
    public String hello(@PathVariable("info") String info){
        // 模拟耗时操作
        String result = helloService.compute(info);

        return result;
    }
}
