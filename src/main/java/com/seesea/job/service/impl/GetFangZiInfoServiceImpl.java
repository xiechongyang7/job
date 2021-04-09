package com.seesea.job.service.impl;


import com.seesea.job.common.BaseLogger;
import com.seesea.job.entity.Area;
import com.seesea.job.entity.Town;
import com.seesea.job.mapper.AreaMapper;
import com.seesea.job.mapper.TownMapper;
import com.seesea.job.service.GetFangZiInfoService;
import com.seesea.job.util.Pinyin;
import org.apache.commons.io.FileUtils;
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
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xie
 * @description
 * @createTime 2021/4/5 20:52
 * @since JDK1.8
 */
@Service
public class GetFangZiInfoServiceImpl extends BaseLogger implements GetFangZiInfoService {


    private final static String url = "https://sh.ke.com/xiaoqu/";

    @Resource
    private TownMapper townMapper;

    @Resource
    private AreaMapper areaMapper;

    @Override
    public void getFangZiInfo(String towncc) {

        Town town1 = new Town();
        town1.setTown(towncc);
        List<Town> list = townMapper.select(town1);

//        for (Town town : list) {
//            Integer id = town.getId();
//            String townNames = town.getTown();
//            String name = town.getName();
//            String pinyin = town.getPinyin();
//            Integer num = town.getNum();
////            beicai/
        try {
            for(Town town : list){
//                String townNames = town.getTown();
                String townNamec = town.getName();
                String pinyin = town.getPinyin();
                boolean flag = true;
                int page = 0;
                do {
                    page++;
                    String urls = url + pinyin + "/pg" + page;
                    try {
                        logger.info("目前进行{}-{},第{}页",towncc,townNamec,page);
                        List<Area> area = getArea(urls,pinyin,page);
                        if (area.isEmpty()) {
                            flag = false;
                        }else {
                            areaMapper.insertList(area);
                        }
                    } catch (Exception e) {
                        logger.error("错误页数" + page + "错误url" + urls, e);
                    }

                } while (flag);
                logger.info(towncc+townNamec+"完成！！！");
            }
            logger.info(towncc+"完成！！！");
        } catch (Exception e) {
            logger.error("错误", e);
        }


    }

    public List<Area> getArea(String url,String pinyinName,Integer page) throws IOException {
        List<Area> areas = new ArrayList<>();
        String html = doGet(url);
        Document doc = Jsoup.parse(html);
        Elements ulz = doc.getElementsByClass("listContent");
        if(ulz.size()<=0){
            return areas;
        }
        Element ul = ulz.get(0);
        if (ul == null) {
            return areas;
        }


        Elements li = ul.getElementsByTag("li");
        String region = "";
        String town = "";
        for (int i = 1; i < li.size() + 1; i++) {
            Element element = li.get(i - 1);
            try {
                String areaName = element.getElementsByClass("lj-lazy").attr("title");
                region = element.getElementsByClass("district").html();
                town = element.getElementsByClass("bizcircle").html();
                String year = element.getElementsByClass("positionInfo").html();
                year = year.substring(year.length() - 7);
                String value = element.getElementsByClass("totalPrice").get(0).getElementsByTag("span").html();
                String link = element.getElementsByClass("maidian-detail").get(0).attr("href");
                String mark = element.getElementsByClass("tagList").get(0).getElementsByTag("span").html();
                Elements elements = element.getElementsByClass("houseInfo").get(0).getElementsByTag("a");
                String clinch = "";
                String rent = "";
                if(elements.size()>=2){
                     clinch = elements.get(0).html();
                     rent = elements.get(1).html();
                }
                String sale = element.getElementsByClass("totalSellCount").get(0).getElementsByTag("span").html();

                Area area = new Area();
                area.setId(Pinyin.HanziToPinyin(region)+"-"+pinyinName+"-"+getReplenish(page,4)+"-"+getReplenish(i,4));
                area.setAreaName(areaName);
                area.setRegion(region);
                area.setTown(town);
                area.setYear(year);
                area.setValue(value);
                area.setLink(link);
                area.setMark(mark);
                area.setClinch(clinch);
                area.setRent(rent);
                area.setSale(sale);
//                logger.info(area.toString());
                areas.add(area);
            } catch (Exception e) {
                logger.error("错误第{}页,第{}个,错误的html{}",page,i,element, e);
            }
        }
        FileUtils.writeStringToFile(new File("E:\\workspace3\\job\\src\\main\\resources\\html\\" + region+"-"+town+"-"+page+".html"), String.valueOf(ul));
        return areas;
    }


    public String doGet(String url) {

        HttpClient client = null;
        HttpGet request = null;
        String strResult = null;
        HttpResponse response = null;
        try {
            client = HttpClientBuilder.create().build();
            //发送get请求
            request = new HttpGet(url);
            response = client.execute(request);
            return EntityUtils.toString(response.getEntity(), "utf-8");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (request != null) {
                request.releaseConnection();
            }
        }
        return strResult;
    }


    private String getReplenish(Integer str,int replenish){
        if(str == null){
            str = 0;
        }
        String rex = "%0"+replenish+"d";
        return String.format(rex,str);
    }

}


