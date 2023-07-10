package com.example.api.repository;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

//reids 는 싱글 스레드 기반으로 동작 => 레이스 컨디션 해결
@Repository
public class CouponCountRepository {
    private final RedisTemplate<String, String> redisTemplate;

    public CouponCountRepository(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public Long increment(){
        return redisTemplate
                .opsForValue()
                .increment("coupon_count");
    }
}
