package com.seesea.job.service.impl;


import com.seesea.job.common.BaseLogger;
import com.seesea.job.entity.Area;
import com.seesea.job.entity.Town;
import com.seesea.job.mapper.AreaMapper;
import com.seesea.job.mapper.TownMapper;
import com.seesea.job.service.GetFangZiInfoService;
import com.seesea.job.util.Pinyin;
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
import java.io.IOException;
import java.util.ArrayList;
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
    public void getFangZiInfo(String townName) {
        Town town1 = new Town();
        town1.setTown(townName);
        List<Town> list = townMapper.select(town1);
        logger.info(list.toString());
        for (Town town : list) {
            Integer id = town.getId();
            String townNames = town.getTown();
            String name = town.getName();
            String pinyin = town.getPinyin();
            Integer num = town.getNum();
//            beicai/
            try {

                boolean flag = false;
                int page = 1;
                do {
                    String urls = url + Pinyin.HanziToPinyin(name) + "/pg" + page;
                    List<Area> area = getArea(urls);
                    page++;
                    if (area.isEmpty()) {
                        flag = true;
                    }
                } while (flag);

            } catch (Exception e) {
                logger.error("错误", e);
            }


        }

    }

    public List<Area> getArea(String url) {
        List<Area> areas = new ArrayList<>();
        String html = doGet(url);

        Document doc = Jsoup.parse(html);
        Elements ul = doc.getElementsByClass("listContent");

        for (Element element : ul) {

            /***
             * <li class="clear xiaoquListItem CLICKDATA" data-click-evtid="11966" data-click-event="WebClick" data-action="source_type=PC小区列表页房源卡片点击&click_position=0&resblock_id=5011000018309&resblock_name=万邦都市花园" data-index="0" data-log_index="0" data-id="5011000018309" data-el="xiaoqu" data-housecode="5011000018309" data-is_focus="" data-sl="">
             *     <a class="img maidian-detail" href="https://sh.ke.com/xiaoqu/5011000018309/" data-maidian="431564988114182144" target="_blank"  title="万邦都市花园">
             *     <img class="lj-lazy" src="https://s1.ljcdn.com/pegasus/redskull/images/common/blank.gif?_v=20210330151409" data-original="https://ke-image.ljcdn.com/hdic-resblock/3680c7b9-63b7-4aa6-9257-7ef369f94153.jpg.232x174.jpg" alt="万邦都市花园" title="万邦都市花园">
             *     </a>
             *     <div class="info">
             *     <div class="title">
             *         <a class="maidian-detail" href="https://sh.ke.com/xiaoqu/5011000018309/" target="_blank" data-maidian="431564988114182144" title="万邦都市花园">万邦都市花园</a>
             *                             </div>
             *                             <div class="houseInfo">
             *         <span class="houseIcon"></span>
             *                                                             <a title="万邦都市花园网签"  href="https://sh.ke.com/chengjiao/c5011000018309/" >90天成交0套</a>
             *                                                             <span class="cutLine">|</span><a title="万邦都市花园租房"  href="http://sh.zu.ke.com/zufang/c5011000018309/" >32套正在出租</a>
             *                                 </div>
             *                         <div class="positionInfo">
             *         <span class="positionIcon"></span>
             *         <a href="https://sh.ke.com/xiaoqu/pudong/" class="district" title="浦东小区">浦东</a>
             *         &nbsp;<a href="https://sh.ke.com/xiaoqu/beicai/" class="bizcircle" title="北蔡小区">北蔡</a>&nbsp;
             *                                                         /&nbsp;2000年建成
             *                             </div>
             *                         <div class="tagList">
             *                                                             <span>近地铁2号线龙阳路站</span>
             *                             </div>
             *     </div>
             *     <div class="xiaoquListItemRight">
             *     <div class="xiaoquListItemPrice">
             *                                 <div class="totalPrice"><span>108662</span>元/m<sup>2</sup></div>
             *                                 <div class="priceDesc">3月二手房参考均价</div>
             *     </div>
             *                         <div class="xiaoquListItemSellCount">
             *         <a title="万邦都市花园二手房" href="https://sh.ke.com/ershoufang/c5011000018309/" class="totalSellCount"><span>18</span>套</a>
             *         <div class="sellCountDesc">在售二手房</div>
             *     </div>
             *                         </div>
             * </li>
             */
            Area area = new Area();
            String areaName = element.getElementsByClass("lj-lazy").attr("title");
            String region = element.getElementsByClass("district").html();
            String town = element.getElementsByClass("bizcircle").html();
            String year = element.getElementsByClass("positionInfo").html();
            String value = element.getElementsByClass("totalPrice").html();
//            String link = element.getElementsByClass("tagList").html();
            String mark = element.getElementsByClass("tagList").html();
//            String clinch = element.getElementsByClass("tagList").html();
//            String rent = element.getElementsByClass("tagList").html();
            String sale = element.getElementsByClass("totalSellCount").html();
        }

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
}
