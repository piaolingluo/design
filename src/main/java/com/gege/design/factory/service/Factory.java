package com.gege.design.factory.service;

import com.gege.design.factory.enums.LanguageEnum;
import com.gege.design.factory.enums.TranslatorEnum;
import com.gege.design.factory.service.translate.AbstractTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * 工厂
 *
 * @author piaolingluo
 * @date 2017-11-08
 */
@Component
public class Factory {

    private static final Map<LanguageEnum, AbstractTranslator> TRANSLATOR_MAP = new HashMap<>();

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    public void init() {
        applicationContext.getBeansOfType(AbstractTranslator.class)
                .entrySet().stream()
                .filter(entry -> null != TranslatorEnum.valueOfTranslator(entry.getKey()))
                .forEach(entry -> TRANSLATOR_MAP.put(
                        TranslatorEnum.languageOfTranslator(entry.getKey()),
                        entry.getValue()));
    }

    /**
     * 根据语言枚举拿到指定语言的翻译器
     *
     * @param languageEnum 语言枚举
     * @return 指定语言的翻译器
     * @throws Exception 当拿不到翻译器时，抛出此异常
     */
    public static AbstractTranslator getTranslator(LanguageEnum languageEnum) throws Exception {
        AbstractTranslator translator = TRANSLATOR_MAP.get(languageEnum);
        if (null == translator) {
            throw new Exception("无法翻译成这种语言");
        }
        return translator;
    }

    /**
     * 根据语言编码拿到指定语言的翻译器
     *
     * @param languageCode 语言编码
     * @return 指定语言的翻译器
     * @throws Exception 当拿不到翻译器时，抛出此异常
     */
    public static AbstractTranslator getTranslator(String languageCode) throws Exception {
        return getTranslator(LanguageEnum.valueOfLanguage(languageCode));
    }
}
