package com.jb.CouponSystemSpring.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class RegisterRequest extends RegisterResponse {
    private final Map<String, Object> params = new HashMap<>();

}
