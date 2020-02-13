package com.seesea.job.service.impl;

import com.seesea.job.entity.*;
import com.seesea.job.mapper.ZhihuMapper;
import com.seesea.job.util.JsonUtil;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service(value = "zhihu")
public class ZhihuService  extends AbstractInfoCollectionService {

    @Autowired
    private ZhihuMapper mapper;

    @Override
    public String getCookies() {
        return null;
    }



    public void run(){
//        String url = "https://www.zhihu.com/api/v4/questions/39501641/answers?limit=20&offset=11340&sort_by=updated";


        String url = "https://www.zhihu.com/api/v4/questions/39501641/answers?include=data%5B%2A%5D.is_normal%2Cadmin_closed_comment%2Creward_info%2Cis_collapsed%2Cannotation_action%2Cannotation_detail%2Ccollapse_reason%2Cis_sticky%2Ccollapsed_by%2Csuggest_edit%2Ccomment_count%2Ccan_comment%2Ccontent%2Ceditable_content%2Cvoteup_count%2Creshipment_settings%2Ccomment_permission%2Ccreated_time%2Cupdated_time%2Creview_info%2Crelevant_info%2Cquestion%2Cexcerpt%2Crelationship.is_authorized%2Cis_author%2Cvoting%2Cis_thanked%2Cis_nothelp%2Cis_labeled%3Bdata%5B%2A%5D.mark_infos%5B%2A%5D.url%3Bdata%5B%2A%5D.author.follower_count%2Cbadge%5B%2A%5D.topics&offset=5&platform=desktop&sort_by=default&limit=";
        boolean flag = true;



//        while (flag) {
//            a++;
//            String result = doGet(url);
//            Map map = JsonUtil.JsonToObject(result,Map.class);
//            String data = map.get("data")+"";
//            String paging = map.get("paging")+"";
//
//            ZhiHuData zhiHuData = JsonUtil.JsonToObject(data, ZhiHuData.class);
//            ZhiHuPaging zhiHuPaging = JsonUtil.JsonToObject(paging,ZhiHuPaging.class);
//            List<ZhiHuInfo> infos = zhiHuData.getZhiHuInfos();
//
//            for(ZhiHuInfo info : infos){
//                Zhihu zhihu = new Zhihu();
//                ZhiHuAuthor author = info.getAuthor();
//                if("匿名用户".equals(author.getName())){
//                    continue;
//                }
//                zhihu.setAnswersUrl(info.getUrl());
////                zhihu.setAuthor(author.get);
//                zhihu.setHeadline(author.getHeadline());
//                zhihu.setId(author.getId());
//                zhihu.setName(author.getName());
//                zhihu.setUrl(author.getUrl());
//                zhihu.setUrlToken(author.getUrl_token());
//                zhihu.setCreatedTime(new Date(Long.valueOf(info.getCreatedTime())));
//                zhihu.setUpdatedTime(new Date(Long.valueOf(info.getUpdatedTime())));
//                mapper.insert(zhihu);
//            }
        int a = 5;

        while (flag) {
                url = url+a;
                a= a+5;
                String result = doGet(url);
                Map map = JsonUtil.JsonToObject(result,Map.class);
                List<Map> data = (List) map.get("data");
//                String paging = (String) ((Map)map.get("paging")).get("next");

//                ZhiHuData zhiHuData = JsonUtil.JsonToObject(data, ZhiHuData.class);
//                ZhiHuPaging zhiHuPaging = JsonUtil.JsonToObject(paging,ZhiHuPaging.class);
//                List<ZhiHuInfo> infos = zhiHuData.getZhiHuInfos();

                for(Map map1 : data){
                    Zhihu zhihu = new Zhihu();
                    Map author = (Map) map1.get("author");
                    if("知乎用户".equals(author.get("name")+"")||"匿名用户".equals(author.get("name")+"")){
                        continue;
                    }
                    zhihu.setAnswersUrl(map1.get("url")+"");
//                zhihu.setAuthor(author.get);
                    zhihu.setHeadline(author.get("headline")+"");
                    zhihu.setId(author.get("id")+"");
                    zhihu.setName(author.get("name")+"");
                    zhihu.setUrl(author.get("url")+"");
                    zhihu.setUrlToken(author.get("url_token")+"");
                    zhihu.setCreatedTime(getDateFromTimeMillis(map1.get("created_time")+"",true));
                    zhihu.setUpdatedTime(getDateFromTimeMillis(map1.get("updated_time")+"",false));
                    mapper.insert(zhihu);
                }

//            url = paging.replace("&","");

//            if (a==1) flag = false;
        }



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

//            String cookie = "lastCity=101020100; _uab_collina=157295165063968628164412; __c=1579340403; __g=-; Hm_lvt_194df3105ad7148dcf2b98a91b5e727a=1579340403; __l=l=https%3A%2F%2Fwww.baidu.com%2Flink%3Furl%3DDxkvRiCGDpWf9dJXzbl4lF_fvnGju6sYildui8iDtXGQJFkyEMhPTPQm4M2TJbl9%26wd%3D%26eqid%3De17df7e10008b7e7000000035e22d26e&r=https%3A%2F%2Fwww.baidu.com%2Flink%3Furl%3DDxkvRiCGDpWf9dJXzbl4lF_fvnGju6sYildui8iDtXGQJFkyEMhPTPQm4M2TJbl9%26wd%3D%26eqid%3De17df7e10008b7e7000000035e22d26e&friend_source=0&friend_source=0; __zp_stoken__=ce26zEyJ3H9Qzqu37nCY3uvA0RHjwFtpwZb8SP8M6ROeciXMy5d454xpJUUA5uEEb2U5zZMeyFqusXSrQRB%2B72MMloU7W5yNASU8XpRbM8fuuqS9kQzia%2Bgh6XuOMtgIIqT7; __a=69653357.1572951651.1572951651.1579340403.33.2.23.33; Hm_lpvt_194df3105ad7148dcf2b98a91b5e727a=1579344936; __zp_sname__=6bffc4c7; __zp_sseed__=HKBcGqybME3jU6uOHKdJTKI8FaBqOtAULkK0y+nuPkU=; __zp_sts__=1579345118831";
            client = HttpClientBuilder.create().build();

            //发送get请求
            request = new HttpGet(url);
//            request.setHeaders(new BasicHeader[]{
//                    new BasicHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3"),
//                    new BasicHeader("accept-language", "zh-CN,zh;q=0.9,und;q=0.8"),
//                    new BasicHeader("cache-control", "max-age=0"),
//                    new BasicHeader("cookie",cookie),
//                    new BasicHeader("sec-fetch-mode", "navigate"),
//                    new BasicHeader("sec-fetch-site", "none"),
//                    new BasicHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36"),
//                    new BasicHeader("upgrade-insecure-requests", "1"),
//                    new BasicHeader("sec-fetch-user", "?1")
//            });

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

    public static void main(String[] args) {

//        Map map = new HashMap();
//        map.put("a",1454270582000l);
//
//        String b  = map.get("a")+"";
//        System.out.println(b);
//        System.out.println(Long.valueOf(b));
//
//        Long c  = Long.valueOf(b);
//        System.out.println(new Date(
//             c
//        ));
//        System.out.println(new Date(
//                c
//        ));
//        System.out.println(getDateFromTimeMillis(c));
//        System.out.println(getDateFromTimeMilli(c));
    }

    /**
     * 根据时间戳返回日期对象
     *
     * @Desc:
     * @author: liubing
     * @return Date
     */
    public static Date getDateFromTimeMillis(String currentTimeMillis,boolean flags) {

        long currentTimeMilli = Long.valueOf(currentTimeMillis+"000");
//        if( flags == true && 1483200000000L <currentTimeMilli){
//            throw new RuntimeException("over over over over over over over over over over over over over over over over over over");
//        }
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(currentTimeMilli);
        return cal.getTime();
    }

}
