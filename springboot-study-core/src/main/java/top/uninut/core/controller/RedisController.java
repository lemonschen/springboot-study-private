package top.uninut.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("redis")
public class RedisController {

    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    public RedisController(RedisTemplate<String,Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    @PutMapping("/string")
    public String setStringValue(@RequestParam String key, @RequestParam String value){
        redisTemplate.opsForValue().set(key,value);
        return "添加成功";
    }

    @GetMapping("/string")
    public Object getStringValue(@RequestParam String key){
        Object res = redisTemplate.opsForValue().get(key);
        return res;
    }
}
