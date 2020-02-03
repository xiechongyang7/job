package com.seesea.job.entity;

import java.util.List;
import java.util.Map;

/**
 * @description
 * @since JDK1.8
 * @createTime 2020/1/21 上午 10:57
 * @author xiechongyang
 */
public class LaGouResult {


    private int resultSize;
    private List<Map> result;

    public int getResultSize() {
        return resultSize;
    }

    public void setResultSize(int resultSize) {
        this.resultSize = resultSize;
    }

    public List<Map> getResult() {
        return result;
    }

    public void setResult(List<Map> result) {
        this.result = result;
    }
}
