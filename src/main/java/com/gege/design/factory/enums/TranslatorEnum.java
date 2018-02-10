package com.gege.design.factory.enums;

import lombok.Getter;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * 语言类型与翻译器实例的映射
 *
 * @author piaolingluo
 * @date 2017-11-08
 */
@Getter
public enum TranslatorEnum {

    ENGLISH_TRANSLATOR(LanguageEnum.ENGLISH, "englishTranslator"),

    JAPANESE_TRANSLATOR(LanguageEnum.JAPANESE, "japaneseTranslator");

    /**
     * 语言
     */
    private LanguageEnum language;

    /**
     * 具体翻译器处理bean的名字
     */
    private String translatorName;

    TranslatorEnum(LanguageEnum language, String translatorName) {
        this.language = language;
        this.translatorName = translatorName;
    }

    public static TranslatorEnum valueOfTranslator(String translatorName) {
        return Stream.of(values())
                .filter(translatorEnum -> translatorEnum.getTranslatorName().equals(translatorName))
                .findFirst()
                .orElse(null);
    }

    public static LanguageEnum languageOfTranslator(String translatorName) {
        Optional<TranslatorEnum> optional = Optional.ofNullable(valueOfTranslator(translatorName));
        return optional.isPresent() ? optional.get().getLanguage() : null;
    }
}
