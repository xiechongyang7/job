package com.seesea.job.service;

import com.seesea.job.common.BaseException;
import com.seesea.job.entity.req.CollectionReq;

/**
 * @description
 * @since JDK1.8
 * @createTime 2020/1/17 下午 2:44
 * @author xiechongyang
 */
public interface InfoCollectionService {



    void infoCollection(CollectionReq req) throws BaseException;

}
