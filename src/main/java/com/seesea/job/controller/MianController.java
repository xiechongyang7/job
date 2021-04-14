package com.seesea.job.controller;

import com.seesea.job.common.BaseException;
import com.seesea.job.entity.req.CollectionReq;
import com.seesea.job.service.GetFangZiInfoService;
import com.seesea.job.service.InfoCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @description
 * @since JDK1.8
 * @createTime 2020/1/17 上午 11:00
 * @author xiechongyang
 */
@Controller
public class MianController {

    @Autowired
    private InfoCollectionService collectionService;

    @Autowired
    private GetFangZiInfoService getFangZiInfo;

    @RequestMapping(value = "/Job",method = RequestMethod.POST)
    @ResponseBody
    public Object test(CollectionReq req) throws BaseException, InterruptedException {

        CollectionReq req1 = new CollectionReq();
        //java  1-3 年 近 一个月 大专 上海
        req1.setArea("101020100");
        req1.setEducational("202");
        collectionService.infoCollection(req);
        return 1;

    }


    @RequestMapping(value = "/area/{townname}",method = RequestMethod.POST)
    @ResponseBody
    public Object test2(@PathVariable("townname") String townname) throws BaseException {

        getFangZiInfo.getFangZiInfo(townname);

        return 1;

    }
}
