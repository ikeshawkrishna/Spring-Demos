package com.project.Student.Controller;

import com.project.Student.Configurations.RedisConfig;
import com.project.Student.Service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    RedisService redisService;

    @GetMapping("/getCache")
    public ResponseEntity<?> getCacheData(@RequestParam("cache") String cacheName){
        return redisService.printCacheContent(cacheName);
    }
}
