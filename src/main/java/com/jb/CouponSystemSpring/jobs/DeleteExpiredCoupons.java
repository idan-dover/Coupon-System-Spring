package com.jb.CouponSystemSpring.jobs;

import com.jb.CouponSystemSpring.repository.CouponRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

@Component
public class DeleteExpiredCoupons {

    @Autowired
    CouponRepository couponRepo;

    private static final int RATE = 1;

    @Scheduled(fixedRate = RATE, timeUnit = TimeUnit.DAYS)
    public void deleteExpiredCoupons() {
        Date today = Date.valueOf(LocalDate.now());
        couponRepo.deleteExpiredCoupons(today);
    }
}