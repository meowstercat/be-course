package com.truecoder.spring.utils;

import java.util.UUID;

public class IdGenerator {
    public static String genID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
