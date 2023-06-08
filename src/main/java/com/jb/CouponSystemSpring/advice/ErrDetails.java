package com.jb.CouponSystemSpring.advice;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrDetails {

    private final String title = "REKT";
    private String description;
}
