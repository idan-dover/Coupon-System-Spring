package com.jb.CouponSystemSpring.jobs;

import com.jb.CouponSystemSpring.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
public class RemoveExpiredCoupons {

    @Autowired
    private CouponRepository couponRepo;


    @Scheduled(cron = "${job.clear-expired-coupons.delay-cron}")
    public void removeExpiredCoupons() {
        Date today = Date.valueOf(LocalDate.now());
        couponRepo.removeExpiredCoupons(today);
    }
}
