package com.xiaogao.redisdemo1;

import com.xiaogao.redisdemo1.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import tools.jackson.databind.ObjectMapper;

import java.util.Map;

@SpringBootTest
public class RedisStringTset {

    //处理字符串键值对
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void testString (){
        //写入一条String字符串
        stringRedisTemplate.opsForValue().set("verify:phone:132136","69180");
        //获取改字符串
        Object value = stringRedisTemplate.opsForValue().get("verify:phone:132136");
        System.out.println(value);
    }

    //手动序列化
    private static final ObjectMapper mapper = new ObjectMapper();

    @Test
    void testSaveUser(){
        //创建对象
        User user = new User("xiaozhao",24);
        //手动序列化
        String json = mapper.writeValueAsString(user);
        //写入数据
        stringRedisTemplate.opsForValue().set("user:300",json);
        //获取数据
        String jsonUser = stringRedisTemplate.opsForValue().get("user:300");
        //手动反序列化
        User user1 = mapper.readValue(jsonUser,User.class);
        System.out.println(user1);
    }

    @Test
    void testHash() {
        stringRedisTemplate.opsForHash().put("user:400", "name", "虎哥");
        stringRedisTemplate.opsForHash().put("user:400", "age", "21");

        Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries("user:400");
        System.out.println("entries = " + entries);
    }
}
