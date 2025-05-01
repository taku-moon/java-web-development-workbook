package com.example.javawebdevelopmentworkbook.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;

public enum MapperUtil {
    INSTANCE;

    private ModelMapper modelMapper;

    MapperUtil() {
        this.modelMapper = new ModelMapper();
        this.modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)                              // 필드 이름 기반 매핑 활성화
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)     // private 필드 접근 허용
                .setMatchingStrategy(MatchingStrategies.STRICT);            // 엄격한 매칭 전략 사용
    }

    public ModelMapper get() {
        return modelMapper;
    }
}

/**
 * setFieldMatchingEnabled(true)
 * → getter/setter 없이 필드 이름으로 매핑 가능

 * setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
 * → private 필드에 접근 허용

 * setMatchingStrategy(MatchingStrategies.STRICT)
 * → 소스와 대상의 필드명이 정확히 일치해야만 매핑 (자동 변환 실수 방지)
 */
