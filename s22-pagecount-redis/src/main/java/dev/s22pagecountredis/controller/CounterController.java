package dev.s22pagecountredis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CounterController {

    @Autowired
    StringRedisTemplate redisTemplate;

    @GetMapping("/hello")
    public String count(){
        long times = this.redisTemplate.opsForValue().increment("count-times");
        return  "有  【"+times+"】 人次访问此页面";
    }
}
