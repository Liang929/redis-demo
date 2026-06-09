package com.xiaogao.redisdemo1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
public class Redisconfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        // 1.创建RedisTemplate对象
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        // 2.设置连接工厂
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        // 3.设置key的序列化  将key设置成字符串型
        redisTemplate.setKeySerializer(RedisSerializer.string());
        redisTemplate.setHashKeySerializer(RedisSerializer.string());
        // 4.设置value的序列化  将value设置成JSON型
        //    GenericJacksonJsonRedisSerializer 内部已配置好 ObjectMapper、DefaultTyping、类型验证器
        //    直接使用 RedisSerializer.json() 即可，无需传入自定义 ObjectMapper
        redisTemplate.setValueSerializer(RedisSerializer.json());
        redisTemplate.setHashValueSerializer(RedisSerializer.json());
        // 5.返回
        return redisTemplate;
    }
}
