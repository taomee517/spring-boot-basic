package com.demo.basic.controller;

import com.demo.basic.util.SpringContextUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping(value = "/")
    public String index(){
        return "Hello! Spring Boot";
    }


    @GetMapping(value = "/info")
    public String getRedisTemplateInfo(){
        RedisTemplate redisTemplate = SpringContextUtil.getRedisTemplate();
        return (String)redisTemplate.opsForValue().get("info");
    }

    @GetMapping(value = "/putdata")
    public String putData(){
        RedisTemplate redisTemplate = SpringContextUtil.getRedisTemplate();
        redisTemplate.opsForValue().set("info", "test");
        return "成功！";
    }
}
