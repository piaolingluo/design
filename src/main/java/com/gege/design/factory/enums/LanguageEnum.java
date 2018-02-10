package com.gege.design.factory.enums;

import lombok.Getter;

import java.util.stream.Stream;

/**
 * 语言枚举
 * 定义系统能翻译的语言
 *
 * @author piaolingluo
 * @date 2017-11-08
 */
@Getter
public enum LanguageEnum {

    CHINESE("chinese", "中文"),

    ENGLISH("english", "英语"),

    JAPANESE("japanese", "日语");

    private String code;

    private String name;

    LanguageEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static LanguageEnum valueOfLanguage(String code) {
        return Stream.of(values())
                .filter(languageEnum -> languageEnum.getCode().equals(code))
                .findFirst()
                .orElse(null);
    }
}
