package com.jb.CouponSystemSpring.security;

import com.jb.CouponSystemSpring.models.ClientType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Information {

    private int id;
    private LocalDateTime time;
    private ClientType clientType;
}
