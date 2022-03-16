package com.truecoder.spring.dic;


public enum LevelEnum {
    BEGINNER("beginner"),
    INTERMEDIATE("intermediate"),
    ADVANCED("advanced");

    private String name;

    LevelEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
