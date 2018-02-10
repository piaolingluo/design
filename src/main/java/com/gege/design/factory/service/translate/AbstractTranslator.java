package com.gege.design.factory.service.translate;

import com.gege.design.factory.config.BaiduConfig;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 翻译器抽象类
 * 抽象产品，定义产品必须实现的方法
 *
 * @author piaolingluo
 * @date 2017-11-08
 */
public abstract class AbstractTranslator {

    @Autowired
    protected BaiduConfig baiduConfig;

    /**
     * 翻译
     *
     * @param content 待翻译的内容
     * @return 翻译的得到的内容
     */
    public abstract String translate(String content);
}
