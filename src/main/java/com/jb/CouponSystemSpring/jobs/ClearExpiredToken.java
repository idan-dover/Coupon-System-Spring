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

    private static final int TIME_TO_CLEAR = 5;
    private static final int DELAY = 10;

    @Scheduled(fixedDelay = DELAY,timeUnit = TimeUnit.SECONDS)
    public void clearExpiredTokens() {
        tokenService.clear(TIME_TO_CLEAR);
    }
}