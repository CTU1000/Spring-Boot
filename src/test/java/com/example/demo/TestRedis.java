package com.example.demo;

import com.example.demo.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description
 * @Author RuYuFeng
 * @Date 2018/8/9 0009
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() throws Exception {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertNotEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void testObj() throws Exception {
        //User user = new User(null, "dd", "dd123456", "dd@126.com", "dd1", null);
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        //operations.set("user", user);
        //operations.set("user", user, 1, TimeUnit.SECONDS);
        Thread.sleep(1000);
        //redisTemplate.delete("com.neo.f");
        boolean exists = redisTemplate.hasKey("user");
        if (exists) {
            System.out.println("--------------------exists is true--------------------");
        } else {
            System.out.println("--------------------exists is false--------------------");
        }
        // Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
    }
}
