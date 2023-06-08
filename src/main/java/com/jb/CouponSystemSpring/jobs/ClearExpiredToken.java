package com.jb.CouponSystemSpring.jobs;

import com.jb.CouponSystemSpring.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class ClearExpiredToken {

    @Autowired
    private TokenService tokenService;

    private static final int timeToClear = 30;

    @Scheduled(fixedDelay = timeToClear, timeUnit = TimeUnit.MINUTES)
    public void clearExpiredTokens(){
        tokenService.clear();
    }
}