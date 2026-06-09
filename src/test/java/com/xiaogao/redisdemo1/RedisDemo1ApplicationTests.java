package com.xiaogao.redisdemo1;

import com.xiaogao.redisdemo1.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisDemo1ApplicationTests {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    void contextLoads() {
        //写入一条String数据
        redisTemplate.opsForValue().set("name","xiaozhao");
        //获取String数据
        Object name=redisTemplate.opsForValue().get("name");
        System.out.println("name="+name);
    }

    @Test
    void testSaveUser(){
        //1.写入数据
        redisTemplate.opsForValue().set("user:200",new User("xiaogao",24));
        //2.获取数据
        User user = (User) redisTemplate.opsForValue().get("user:200");
        System.out.println(user);
    }

}
