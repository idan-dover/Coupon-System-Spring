package com.jb.CouponSystemSpring.security;

import com.jb.CouponSystemSpring.Exceptions.CouponException;
import com.jb.CouponSystemSpring.Exceptions.ErrMsg;
import com.jb.CouponSystemSpring.models.ClientType;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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

    // TODO: 07/07/2023 ask kobi if this two methods are relevant

    @Override
    public boolean isUserAllowed(UUID token, ClientType type) throws CouponException {
        Information info = tokens.get(token);
        if (info == null) {
            throw new CouponException(ErrMsg.INCORRECT_TOKEN);
        }

        ClientType clientType = info.getClientType();

        return clientType.equals(type);
    }

    @Override
    public Information getUserInfo(UUID token, ClientType type) {
        return tokens.get(token);
    }

    @Override
    public int validate(UUID token, ClientType type) throws CouponException {
        Information info = tokens.get(token);
        if (info == null) {
            throw new CouponException(ErrMsg.INCORRECT_TOKEN);
        }

        if (type != info.getClientType()) {
            throw new CouponException(ErrMsg.INCORRECT_TOKEN);
        }

        return info.getId();
    }

    @Override
    public void clear(int toClear) {
        this.tokens.entrySet()
                .removeIf(entry -> entry.getValue().getTime().plusMinutes(toClear).isBefore(LocalDateTime.now()));
    }
}