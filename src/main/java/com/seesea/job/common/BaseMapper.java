package com.seesea.job.common;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @description
 * @since JDK1.8
 * @createTime 2020/1/17 上午 10:56
 * @author xiechongyang
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
