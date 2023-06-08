package com.jb.CouponSystemSpring.beans;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

// FIXME: 09/06/2023 SHOULD PROBABLY REMOVE THIS CLASS AND IMPLEMENT IT ANOTHER WAY
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {

    private String firstName;
    private String lastName;
    private String name;
    private String email;
    private String password;
    private ClientType clientType;
}
