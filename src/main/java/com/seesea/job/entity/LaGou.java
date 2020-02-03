package com.seesea.job.entity;

/**
 * @description
 * @since JDK1.8
 * @createTime 2020/1/21 上午 10:57
 * @author xiechongyang
 */
public class LaGou {


    private boolean success;
    private String msg;
    private String code;
    private LaGouContent content;


    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LaGouContent getContent() {
        return content;
    }

    public void setContent(LaGouContent content) {
        this.content = content;
    }
}
