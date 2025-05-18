package com.project.Student.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RedisService {

    private final CacheManager cacheManager;
    private final RedisTemplate<String, Object> redisTemplate;

    public RedisService(RedisTemplate<String, Object> redisTemplate, CacheManager cacheManager){
        this.redisTemplate = redisTemplate;
        this.cacheManager = cacheManager;
    }

    public void saveDataToRedis(String key, Object value){
        redisTemplate.opsForValue().set(key, value);
    }

    public Object getDataFromRedis(String key){
        return redisTemplate.opsForValue().get(key);
    }

    public void deleteDataFromRedis(String key){
        redisTemplate.delete(key);
    }

    public ResponseEntity<?> printCacheContent(String cachename){
        return new ResponseEntity<Object>(getDataFromRedis(cachename), HttpStatus.OK);
    }
}
