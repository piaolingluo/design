package com.gege.design.factory.service.translate.impl;

import com.gege.design.factory.service.translate.AbstractTranslator;
import com.gege.design.factory.util.baidu.TransApi;
import com.gege.design.factory.util.baidu.TransResult;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 英语翻译器
 * 具体产品
 *
 * @author piaolingluo
 * @date 2017-11-08
 */
@Service
public class EnglishTranslator extends AbstractTranslator {

    @Autowired
    private Gson gson;

    @Override
    public String translate(String content) {
        TransApi api = new TransApi(baiduConfig.getAppId(), baiduConfig.getSecurityKey());
        String response = api.getTransResult(content, "auto", "en");
        TransResult result = gson.fromJson(response, TransResult.class);
        return result.getTransResult().get(0).getDst();
    }
}
