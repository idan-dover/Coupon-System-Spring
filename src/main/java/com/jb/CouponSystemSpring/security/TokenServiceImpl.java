package com.jb.CouponSystemSpring.security;

import com.jb.CouponSystemSpring.beans.ClientType;

import com.jb.CouponSystemSpring.services.ClientService;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class TokenServiceImpl implements TokenService {


    private final Map<UUID, Information> tokens = new HashMap<>();


    @Override
    public UUID addToken(int id, ClientType clientType) {
        UUID token = UUID.randomUUID();

        Information info = Information.builder()
                .id(id)
                .time(LocalDateTime.now())
                .clientType(clientType)
                .build();

        tokens.put(token, info);
        return token;
    }

    @Override
    public boolean isUserAllowed(UUID token, ClientType type) {
        Information info = tokens.get(token);

        ClientType clientType = info.getClientType();

        return clientType.equals(type);
    }

    @Override
    public Information getUserInfo(UUID token, ClientType type) {
        return tokens.get(token);
    }

    @Override
    public void clear(int toClear) {
        this.tokens.entrySet()
                .removeIf(entry -> entry.getValue().getTime().plusMinutes(toClear).isBefore(LocalDateTime.now()));
    }
}