package com.seesea.job.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author xiechongyang
 * @description
 * @createTime 2020/1/17 下午 6:32
 * @since JDK1.8
 */
public class JsonUtil {
    private static ObjectMapper mapper = new ObjectMapper();


    public static String ObjectToJson(Object o) {
        try {
            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T JsonToObject(String str,Class<T> t) {
        try {
            return mapper.readValue(str,t);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
