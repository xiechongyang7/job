package com.seesea.job.service.impl;

import com.seesea.job.common.BaseException;
import com.seesea.job.entity.Job;
import com.seesea.job.entity.JobBoss;
import com.seesea.job.entity.req.CollectionReq;
import com.seesea.job.mapper.JobBossMapper;
import com.seesea.job.util.JsonUtil;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
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
    @Autowired
    private JobBossMapper mapper;
    public void infoCollection(CollectionReq req) throws BaseException, InterruptedException {

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
//java  1-3 年 近 一个月 大专page=3&

//        String url2 = "https://m.zhipin.com/wapi/zpgeek/mobile/jobs.json?experience=104&city=101020100&query=Java";
        String url2 = "https://www.zhipin.com/mobile/jobs.json?city=101020100&query=java&page=";
        boolean flag = true;
        int a = 0;
        while (flag){
            a++;
            String str = doGet(url2+a);
            Map map = JsonUtil.JsonToObject(str,Map.class);
            logger.info(str);
            if(!"成功".equals(map.get("resmsg"))){
                logger.info(str);
//                flag = false;
                break;
            }
            if((Boolean) map.get("hasMore")){
                logger.info(str);
//                flag = false;
                break;
            }
            String html = map.get("html").toString();
//            String html = ((Map)map.get("zpData")).get("html").toString();

//            Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
//
//            Elements links = doc.select("a[href]"); //带有href属性的a元素
//            Elements pngs = doc.select("img[src$=.png]");
//            //扩展名为.png的图片
//
//            Element masthead = doc.select("div.masthead").first();
//            //class等于masthead的div标签
//
//            Elements resultLinks = doc.select("h3.r > a"); //在h3元素之后的a元素
//             <li class="item">
//            <a href="/job_detail/8e6e6455500eff690nN-2d20GVY~.html" ka="job_list_32" data-itemId="32" data-lid="8ppCcbYmciD.search.32" data-index="1">
//                    <img src="https://img.bosszhipin.com/beijin/mcs/chatphoto/20191230/30ad984d40547a0263d9e7c916ffb7c504e9fed5525dee2adbdd999ee2249464_s.jpg?x-oss-process=image/resize,w_120,limit_0"/>
//                <div class="text">
//                    <div class="title"><h4>Java开发工程师</h4><span class="salary">12-22K</span></div>
//                    <div class="name">轻轻教育</div>
//                    <div class="msg"><em>上海</em><em>1-3年</em><em>本科</em></div>
//                </div>
//            </a>
//</li>
            Document doc = Jsoup.parse(html);
            Elements contents = doc.getElementsByTag("li");

            for(Element content:contents){
                JobBoss job = new JobBoss();
//                 job.setPrimaryKey();
                job.setJobName(content.getElementsByTag("h4").html());
                job.setCompanyName(content.getElementsByClass("name").html());
                String salary = content.getElementsByClass("salary").html();
                String[] salarys = salary.split("-");
                job.setSalaryHeight(salarys[0]);
                if(salarys.length>=2){
                    job.setSalaryLow(salarys[1]);
                }
                job.setArea(content.getElementsByTag("em").get(0).html());
                job.setCity(content.getElementsByTag("em").get(0).html());
                job.setExperience(content.getElementsByTag("em").get(1).html());
                job.setEducational(content.getElementsByTag("em").get(2).html());
                job.setUrl(content.getElementsByTag("a").attr("href"));
                job.setCreatTime(new Date());

                mapper.insert(job);
            }

            Thread.sleep(3000);

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

            String cookie = "lastCity=101020100; _uab_collina=157295165063968628164412; __c=1579340403; __g=-; Hm_lvt_194df3105ad7148dcf2b98a91b5e727a=1579340403; __l=l=https%3A%2F%2Fwww.baidu.com%2Flink%3Furl%3DDxkvRiCGDpWf9dJXzbl4lF_fvnGju6sYildui8iDtXGQJFkyEMhPTPQm4M2TJbl9%26wd%3D%26eqid%3De17df7e10008b7e7000000035e22d26e&r=https%3A%2F%2Fwww.baidu.com%2Flink%3Furl%3DDxkvRiCGDpWf9dJXzbl4lF_fvnGju6sYildui8iDtXGQJFkyEMhPTPQm4M2TJbl9%26wd%3D%26eqid%3De17df7e10008b7e7000000035e22d26e&friend_source=0&friend_source=0; __zp_stoken__=ce26zEyJ3H9Qzqu37nCY3uvA0RHjwFtpwZb8SP8M6ROeciXMy5d454xpJUUA5uEEb2U5zZMeyFqusXSrQRB%2B72MMloU7W5yNASU8XpRbM8fuuqS9kQzia%2Bgh6XuOMtgIIqT7; __a=69653357.1572951651.1572951651.1579340403.33.2.23.33; Hm_lpvt_194df3105ad7148dcf2b98a91b5e727a=1579344936; __zp_sname__=6bffc4c7; __zp_sseed__=HKBcGqybME3jU6uOHKdJTKI8FaBqOtAULkK0y+nuPkU=; __zp_sts__=1579345118831";
            client = HttpClientBuilder.create().build();

            //发送get请求
            request = new HttpGet(url);
            request.setHeaders(new BasicHeader[]{
                    new BasicHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3"),
                    new BasicHeader("accept-language", "zh-CN,zh;q=0.9,und;q=0.8"),
                    new BasicHeader("cache-control", "max-age=0"),
                    new BasicHeader("cookie",cookie),
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


    @Override
    public String getCookies() {
        return null;
    }
}
