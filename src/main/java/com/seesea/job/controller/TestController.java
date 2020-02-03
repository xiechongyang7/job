package com.seesea.job.controller;

import com.seesea.job.common.BaseException;
import com.seesea.job.entity.req.CollectionReq;
import com.seesea.job.service.impl.BossJobServiceImpl;
import com.seesea.job.service.impl.LaGouJobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xiechongyang
 * @description
 * @createTime 2020/1/17 上午 11:00
 * @since JDK1.8
 */
@Controller
public class TestController {
//
//    @Autowired
//    private InfoCollectionService service;

    //    @Qualifier(value = "boss")
    @Autowired
    private BossJobServiceImpl boss;
    //    @Qualifier(value = "lagou")
    @Autowired
    private LaGouJobServiceImpl lagou;

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public Object test(CollectionReq req) throws BaseException, InterruptedException {

        CollectionReq req1 = new CollectionReq();
        //java  1-3 年 近 一个月 大专 上海
        req1.setArea("101020100");
        req1.setEducational("202");
        boss.infoCollection(req);
        return 1;

    }


    @RequestMapping(value = "/test2", method = RequestMethod.POST)
    @ResponseBody
    public Object test2(CollectionReq req) throws BaseException, InterruptedException {

        req.setArea("101020100");
        req.setArea("101020100");
        req.setArea("101020100");
        lagou.infoCollection(req);

//        CollectionReq req1 = new CollectionReq();
//        //java  1-3 年 近 一个月 大专 上海
//        req1.setArea("101020100");
//        req1.setEducational("202");
//        service.infoCollection(req);


        return 1;

    }
}
