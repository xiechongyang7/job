package com.seesea.job.service.impl;

import com.seesea.job.common.BaseException;
import com.seesea.job.common.BaseService;
import com.seesea.job.common.ErrInfo;
import com.seesea.job.entity.req.CollectionReq;
import com.seesea.job.service.InfoCollectionService;

public abstract class AbstractInfoCollectionService extends BaseService implements InfoCollectionService {

    public void infoCollection(CollectionReq req) throws BaseException, InterruptedException {
        throw new BaseException(ErrInfo.errMsg_10001,ErrInfo.errCode_10001);
    }
}
