package com.seesea.job.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: xiechongyang
 * @create: 2021-12-20 15:55
 **/
@Aspect
@Component
public class CheckInteceptor {


    private Logger logger = LoggerFactory.getLogger(CheckInteceptor.class);


    /**
     * 拦截类的入口--拦截所有controller类
     */
//    @Pointcut("execution(public * com.seesea.study.service.TestService.test(..))  ")
//    @Pointcut(value = "execution(public * com.seesea.job.config.Check  ")
    @Pointcut("@annotation(com.seesea.job.config.Check)")
    public void pointCut() {
    }


    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        Object[] o = joinPoint.getArgs();
        for (Object o1 : o) {

            Map<String,Object> map = JSON.parseObject(JSON.toJSONString(o1), Map.class);
            logger.info("校验Before object" + map.get("mchId"));
        }
        String name = joinPoint.getSignature().getName();
        logger.info("校验Before name" + name);

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        PostMapping annotations = method.getAnnotation(PostMapping.class);
        annotations.name()
    }


    @After("pointCut()")
    public void after(JoinPoint joinPoint) {
//        for(Object o1:o){
//            logger.info("嘻嘻啊"+o1);
//        }
//        String name = joinPoint.getSignature().getName();
        logger.info("校验 After" + joinPoint);
        Object[] o = joinPoint.getArgs();
        for (Object o1 : o) {
            logger.info("校验 After object" + o1);
        }
    }
}
