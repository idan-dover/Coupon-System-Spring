package com.jb.CouponSystemSpring.models;


import com.jb.CouponSystemSpring.beans.ClientType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// FIXME: 09/06/2023 SHOULD PROBABLY REMOVE THIS CLASS AND IMPLEMENT IT ANOTHER WAY
// TODO: 09/06/2023 ASK KOBI IF I CAN DO THIS OR SHOULD I STILL OPEN A USER REPO AND IMPLEMENT IT AS SUCH
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private String firstName;
    private String lastName;
    private String name;
    private String email;
    private String password;
    private ClientType clientType;
}
