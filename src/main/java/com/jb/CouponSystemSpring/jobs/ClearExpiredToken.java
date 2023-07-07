package com.jb.CouponSystemSpring.jobs;

import com.jb.CouponSystemSpring.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ClearExpiredToken {

    @Autowired
    private TokenService tokenService;

    @Value("${job.clear-expired-token.clear-time}")
    private int TIME_TO_CLEAR;


    @Scheduled(cron = "${job.clear-expired-token.delay-cron}")
    public void clearExpiredTokens() {
        tokenService.clear(TIME_TO_CLEAR);
    }
}