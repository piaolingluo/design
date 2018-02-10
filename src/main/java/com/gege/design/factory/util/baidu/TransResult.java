package com.gege.design.factory.util.baidu;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

/**
 * 翻译结果
 *
 * @author piaolingluo
 * @date 2017-11-08
 */
@Data
public class TransResult {

    private String from;

    private String to;

    @SerializedName("trans_result")
    private List<Result> transResult;

    @Data
    public static class Result {

        private String src;

        private String dst;
    }
}
