package com.seesea.job.common;

/**
 * @description
 * @since JDK1.8
 * @createTime 2020/1/17 下午 2:58
 * @author xiechongyang
 */
public class BaseException extends Exception{
    private String errCode;
    private String errMsg;

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param errMsg the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public BaseException(String errMsg, String errCode) {
        super(errMsg);
        this.errMsg = errMsg;
        this.errCode = errCode;
    }
}
