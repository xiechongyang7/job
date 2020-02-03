package com.seesea.job.service.impl;

import com.seesea.job.common.BaseException;
import com.seesea.job.entity.JobBoss;
import com.seesea.job.entity.LaGou;
import com.seesea.job.entity.req.CollectionReq;
import com.seesea.job.mapper.JobBossMapper;
import com.seesea.job.util.JsonUtil;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @description
 * @since JDK1.8
 * @createTime 2020/1/21 上午 10:33
 * @author xiechongyang
 */
@Service(value = "lagou")
public class LaGouJobServiceImpl extends AbstractInfoCollectionService{


    private JobBossMapper mapper;


    public void infoCollection(CollectionReq req) throws BaseException, InterruptedException {

        String url = "https://www.lagou.com/jobs/positionAjax.json?city=%E4%B8%8A%E6%B5%B7&needAddtionalResult=false";

        boolean flag = true;
        int a = 0;
        while (flag){
            a++;

            Map reqMap = new HashMap();
            reqMap.put("first",flag);
            flag = false;
            reqMap.put("pn",a);
            reqMap.put("ka","Java");


            String str = doPost(url,reqMap);


            logger.info(str);
            LaGou laGou = JsonUtil.JsonToObject(str, LaGou.class);

            if(laGou.getSuccess()){
                logger.info(str);
//                flag = false;
                break;
            }
            List<Map> list = laGou.getContent().getPositionResult().getResult();

            for(int i =0;i<laGou.getContent().getPositionResult().getResultSize();i++){

                Map map  = list.get(i);



                JobBoss job = new JobBoss();
//                 job.setPrimaryKey();
                job.setJobName(map.get("positionName")+"");
                job.setCompanyName(map.get("companyFullName")+"");
                String salary = map.get("salary")+"";
                String[] salarys = salary.split("-");
                job.setSalaryHeight(salarys[0]);
                if(salarys.length>=2){
                    job.setSalaryLow(salarys[1]);
                }
                job.setArea(map.get("district")+"");
                job.setCity(map.get("city")+"");
                job.setExperience(map.get("workYear")+"");
                job.setEducational(map.get("education")+"");
                job.setUrl("");
                job.setCreatTime(new Date());
                job.setType("2");
                mapper.insert(job);
            }

            Thread.sleep(3000);

        }





    }

    @Override
    public String getCookies() {
        return null;
    }

    /**
     * post请求
     */

    public  String doPost(String url, Map params) {
        BufferedReader in = null;
        HttpClient client = null;
        HttpPost request = null;


        String cookies = "_ga=GA1.2.114845179.1539228271; LGUID=20181011112430-2ab1a6fd-cd05-11e8-bbb2-5254005c3644; user_trace_token=20191113151754-325446e6-8bb1-4bb9-b845-c5cc9a498ef4; LG_HAS_LOGIN=1; index_location_city=%E4%B8%8A%E6%B5%B7; lagou_utm_source=A; JSESSIONID=ABAAAECABGFABFF0E350005897124A3AA28AD2BDE54E1EF; showExpriedIndex=1; showExpriedCompanyHome=1; showExpriedMyPublish=1; hasDeliver=59; privacyPolicyPopup=false; WEBTJ-ID=20200116095652-16fac114c041d8-054063c41d0255-2393f61-1049088-16fac114c05891; TG-TRACK-CODE=index_navigation; _gid=GA1.2.1396860148.1579572335; SEARCH_ID=98d04909ff3c48ba8f92e1aa25f4f564; LGSID=20200121112945-4533fe4e-3bfe-11ea-af1f-5254005c3644; PRE_UTM=; PRE_HOST=link.zhihu.com; PRE_SITE=https%3A%2F%2Flink.zhihu.com%2F%3Ftarget%3Dhttps%253A%2F%2Fwww.lagou.com%2Fjobs%2Flist_Java%2F; PRE_LAND=https%3A%2F%2Fwww.lagou.com%2Fjobs%2Flist_Java%2F; Hm_lvt_4233e74dff0ae5bd0a3d81c6ccf756e6=1579573019,1579573072,1579573652,1579577386; _gat=1; login=false; unick=\"\"; _putrc=\"\"; LG_LOGIN_USER_ID=\"\"; X_HTTP_TOKEN=574df893dd22aa1f990875975128133beaea0115ca; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22169577d3fbb4f2-05338cf9c05771-1333063-1049088-169577d3fbc2d0%22%2C%22%24device_id%22%3A%22169577d3fbb4f2-05338cf9c05771-1333063-1049088-169577d3fbc2d0%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_referrer%22%3A%22%22%2C%22%24latest_referrer_host%22%3A%22%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24os%22%3A%22Windows%22%2C%22%24browser%22%3A%22Chrome%22%2C%22%24browser_version%22%3A%2278.0.3904.108%22%7D%7D; LGRID=20200121114140-ef1a30a1-3bff-11ea-af1f-5254005c3644; Hm_lpvt_4233e74dff0ae5bd0a3d81c6ccf756e6=1579578100";
        try {

            client = HttpClientBuilder.create().build();
            request = new HttpPost(url);

//设置参数
            List<NameValuePair> nameValuePairs = new ArrayList<>();
            for (Iterator iterator = params.keySet().iterator(); iterator.hasNext(); ) {
                String name = (String) iterator.next();
                String value = String.valueOf(params.get(name));
                nameValuePairs.add(new BasicNameValuePair(name, value));
            }

            request.setHeader(new BasicHeader("Accept", "application/json, text/javascript, */*; q=0.01"));
            request.setHeader(new BasicHeader("Accept-Encoding", "gzip, deflate, br"));
            request.setHeader(new BasicHeader("Accept-Language", "zh-CN,zh;q=0.9,und;q=0.8"));
            request.setHeader(new BasicHeader("Connection", "keep-alive"));
//            request.setHeader(new BasicHeader("Content-Length", "23"));
            request.setHeader(new BasicHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"));
            request.setHeader(new BasicHeader("Cookie", cookies));
            request.setHeader(new BasicHeader("Host", "www.lagou.com"));
            request.setHeader(new BasicHeader("Origin", "https://www.lagou.com"));
            request.setHeader(new BasicHeader("Referer", "https://www.lagou.com/jobs/list_Java/"));
            request.setHeader(new BasicHeader("Sec-Fetch-Mode", "cors"));
            request.setHeader(new BasicHeader("Sec-Fetch-Site", "same-origin"));
            request.setHeader(new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36"));
            request.setHeader(new BasicHeader("X-Anit-Forge-Code", "0"));
            request.setHeader(new BasicHeader("X-Anit-Forge-Token", "None"));
            request.setHeader(new BasicHeader("X-Requested-With", "XMLHttpRequest"));



            request.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            HttpResponse response = client.execute(request);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                logger.info("请求成功" + response.toString());
                in = new BufferedReader(new InputStreamReader(request.getEntity().getContent(), "utf-8"));
                StringBuffer stringBuffer = new StringBuffer();
                String line = "";
//换行符
                String NL = System.getProperty("line.separator");
                while ((line = in.readLine()) != null) {
                    stringBuffer.append(line + NL);
                }
                return stringBuffer.toString();
            } else {
                logger.info("响应信息 response header: " + response.getAllHeaders());
                return null;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (request != null) {
                    request.releaseConnection();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
