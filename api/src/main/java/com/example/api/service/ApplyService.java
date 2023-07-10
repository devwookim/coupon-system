package com.example.api.service;

import com.example.api.domain.Coupon;
import com.example.api.repository.CouponRepository;
import org.springframework.stereotype.Service;

@Service
public class ApplyService {

    private final CouponRepository couponRepository;

    public ApplyService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public void apply(Long userId){
        long count = couponRepository.count(); //ctrl + alt + v -> 변수 생성 단축키

        if( count> 100){
            return;
        }

        couponRepository.save(new Coupon(userId));
    }
}
