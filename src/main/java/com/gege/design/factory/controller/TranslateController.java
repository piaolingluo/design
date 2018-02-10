package com.gege.design.factory.controller;

import com.gege.design.factory.service.Factory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 翻译服务
 *
 * @author piaolingluo
 * @date 2017-11-08
 */
@RestController
@RequestMapping("translate")
public class TranslateController {

    @GetMapping("{code}")
    public ResponseEntity<String> translate(@PathVariable("code") String code,
                                    @RequestParam(value = "content", required = false) String content) {
        try {
            // 调用工厂类的静态方法，传入语言编码，拿到具体的翻译器实例进行翻译
            return ResponseEntity.ok(Factory.getTranslator(code).translate(content));
        } catch (Exception e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }
}
