package com.seesea.job.service.impl;

import com.seesea.job.common.BaseException;
import com.seesea.job.entity.req.CollectionReq;
import com.seesea.job.util.JsonUtil;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

/**
 * @author xiechongyang
 * @description
 * @createTime 2020/1/17 下午 3:27
 * @since JDK1.8
 */
@Service
public class InfoCollectionServiceImpl extends AbstractInfoCollectionService {

//    String a = "https://m.zhipin.com/wapi/zpgeek/mobile/jobs.json?experience=104&page=3&city=101120100&query=Java";

    public void infoCollection(CollectionReq req) throws BaseException {

//        String salary = req.getSalary();
//        String area = req.getArea();
//        String experience = req.getExperience();
//        String educational = req.getEducational();
//        String time = req.getTime();
//        String url = "";
//        try {
//            url = getReqtUrl(Common.URL, BeanUtils.describe(req));
//        } catch (Exception e) {
//           logger.error("获取url错误",e);
//        }
//java  1-3 年 近 一个月 大专

        String url2 = "https://m.zhipin.com/wapi/zpgeek/mobile/jobs.json?experience=104&page=3&city=101020100&query=Java";
        boolean flag = true;
        while (flag){
            String str = doGet(url2);
            Map map = JsonUtil.JsonToObject(str,Map.class);
            if(!"Success".equals(map.get("message"))){
                flag = false;
            }
        }





    }
    public static String getReqtUrl(String url, Map<String, String> params) {
        StringBuilder builder = new StringBuilder(url);
        boolean isFirst = true;
        for (String key : params.keySet()) {
            if (key != null && params.get(key) != null) {
                if (isFirst) {
                    isFirst = false;
                    builder.append("?");
                } else {
                    builder.append("&");
                }
                builder.append(key)
                        .append("=")
                        .append(params.get(key));
            }
        }
        return builder.toString();
    }

    /**
     * get请求
     *
     * @param url
     * @return
     */
    public String doGet(String url) {

        HttpClient client = null;
        HttpGet request = null;
        String strResult = null;
        HttpResponse response = null;
        try {

            client = HttpClientBuilder.create().build();

            //发送get请求
            request = new HttpGet(url);
            request.setHeaders(new BasicHeader[]{
                    new BasicHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3"),
                    new BasicHeader("accept-language", "zh-CN,zh;q=0.9,und;q=0.8"),
                    new BasicHeader("cache-control", "max-age=0"),
                    new BasicHeader("cookie", "lastCity=101020100; _uab_collina=155926782246169454932204; _bl_uid=1Ik2w26emaOpkhf5Ii3twkh4n5gd; __c=1579168807; __g=-; __l=l=https%3A%2F%2Fwww.zhipin.com%2Fshanghai%2F&r=&friend_source=0&friend_source=0; Hm_lvt_194df3105ad7148dcf2b98a91b5e727a=1577933123,1579168807,1579240447,1579252890; toUrl=/; __zp_stoken__=06fbkZQ91jE%2Bnhjf63UO1RwUnUe%2BPuwEk%2B%2BhCZDQNAb%2Bt0jdDvVUZXu8JUZtgvsOTDiR4Ff6uDrgzMt0kh1%2FKTRsx41lzHkLpOHhdpTnG%2FGK5Gi2uLwBfRIfR%2FZs%2BFFKVr9Z; __a=24389340.1559267822.1577933123.1579168807.418.12.74.418; Hm_lpvt_194df3105ad7148dcf2b98a91b5e727a=1579253575"),
                    new BasicHeader("sec-fetch-mode", "navigate"),
                    new BasicHeader("sec-fetch-site", "none"),
                    new BasicHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36"),
                    new BasicHeader("upgrade-insecure-requests", "1"),
                    new BasicHeader("sec-fetch-user", "?1")
            });

            response = client.execute(request);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                logger.info("请求成功" + response.toString());
                strResult = EntityUtils.toString(response.getEntity(), "utf-8");
                return strResult;
            } else {
                System.out.println("响应信息 response header: " + response.getAllHeaders());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (request != null) {
                request.releaseConnection();
            }
        }
        return strResult;
    }
}
