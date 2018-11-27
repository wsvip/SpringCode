package com.ws.domain.redis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void stringRedisTest(){
        stringRedisTemplate.opsForValue().set("abc","cba");
        Assert.assertEquals("cba",stringRedisTemplate.opsForValue().get("abc"));
    }
    @Test
    public void redisTempTest(){
        String abc = redisTemplate.opsForValue().get("abc").toString();
        System.err.println(abc);
    }
}
