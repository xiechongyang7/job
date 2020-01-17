package com.seesea.job.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description
 * @since JDK1.8
 * @createTime 2020/1/17 下午 3:28
 * @author xiechongyang
 */
public abstract class BaseLogger {
    public  Logger logger = LoggerFactory.getLogger(this.getClass());
}
