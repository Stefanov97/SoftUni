package com.stefanov.herobattles.service.services;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class HashingServiceImpl implements HashingService {
    private final PasswordEncoder passwordEncoder;

    public HashingServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public String hash(String str) {
        return passwordEncoder.encode(str);
    }
}
