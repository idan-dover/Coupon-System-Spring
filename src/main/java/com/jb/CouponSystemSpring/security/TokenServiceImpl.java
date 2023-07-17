package com.jb.CouponSystemSpring.security;

import com.jb.CouponSystemSpring.models.ClientType;
import com.jb.CouponSystemSpring.models.LoginResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class TokenServiceImpl implements TokenService {


    private final Map<UUID, Information> tokens = new HashMap<>();


    @Override
    public LoginResponse addToken(int id, ClientType clientType) {
        UUID token = UUID.randomUUID();

        Information info = Information.builder()
                .id(id)
                .time(LocalDateTime.now())
                .clientType(clientType)
                .build();

        tokens.put(token, info);
        return new LoginResponse(token, clientType);
    }

    @Override
    public boolean validate(UUID token, ClientType type) {
        Information info = tokens.get(token);
        if (info == null) {
            return false;
        }

        ClientType clientType = info.getClientType();

        return clientType.equals(type);
    }

    @Override
    public Information getUserInfo(UUID token) {
        return tokens.get(token);
    }


    @Override
    public void clear(int toClear) {
        this.tokens.entrySet()
                .removeIf(entry -> entry.getValue().getTime().plusMinutes(toClear).isBefore(LocalDateTime.now()));
    }
}