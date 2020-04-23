package com.stefanov.herobattles.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Hero not found")
public class HeroNotFoundException extends RuntimeException {

    public HeroNotFoundException(String message) {
        super(message);
    }
}