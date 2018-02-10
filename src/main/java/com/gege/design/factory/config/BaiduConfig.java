package com.gege.design.factory.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 百度配置
 *
 * @author piaolingluo
 * @date 2017-11-08
 */
@Data
@Component
@ConfigurationProperties(prefix = "baidu")
public class BaiduConfig {

    private String appId;

    private String securityKey;
}
