package com.xinyi.flashsale.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class RediService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void setValue(String key, Long value) {
        redisTemplate.opsForValue().set(key, value.longValue());
    }

    public Long getValue(String key){
        Long value = (Long) redisTemplate.opsForValue().get(key);
        System.out.println(key + ": " + value);
        return value;
    }

    public boolean stockDeductValidator(String key){
        try{
            RedisScript<Long> script = new DefaultRedisScript<>(
                    "if redis.call('exists',KEYS[1]) == 1 then\n" +
                            "                 local stock = tonumber(redis.call('get', KEYS[1]))\n" +
                            "                 redis.log(redis.LOG_NOTICE, \"Stock value: \" .. stock)\n" +
                            "                 if( stock <=0 ) then\n" +
                            "                    return -1\n" +
                            "                 end;\n" +
                            "                 redis.call('decr',KEYS[1]);\n" +
                            "                 return stock - 1;\n" +
                            "             end;\n" +
                            "             return -1;", Long.class);
            Long stock = (Long) redisTemplate.execute(script, Collections.singletonList(key), Collections.emptyList());
            if (stock >= 0) {
//                System.out.println("Congratulation!");
                return true;
            } else {
//                System.out.println("Sorry! This product is not available now!");
                return false;
            }
        }
        catch (RuntimeException e){
            System.out.println("fail to deduct stock: " + e.getMessage());
            return false;
        }
    }


}
