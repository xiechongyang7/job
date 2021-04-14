package com.seesea.job.service.impl;

import com.seesea.job.service.GetBookImgService;
import com.seesea.job.util.ConnectionPool;
import com.seesea.job.util.HttpConnectionPoolUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;


import java.sql.Connection;
import java.sql.Statement;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/11/2 17:30
 * @Author xie
 */
@Service
public class GetImg implements GetBookImgService {

    @Override
    public void GetBookImg() {
        Statement statement = null;
        Connection conn = null;

        try {
            conn = ConnectionPool.getConnection();
            //关键 设置为手动提交
            conn.setAutoCommit(false);
            statement = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            System.out.println("sql报错");
        }
        for (int i = 640; i < 10000; i++) {
            try {
                String a1 = HttpConnectionPoolUtil.get("http://www.duokan.com/book/" + i);
                Document doc = Jsoup.parse(a1);
                Elements e = doc.getElementsByTag("img");
                for (int y = 2; y < e.size(); y++) {
                    Element element = e.get(y);
                    String name = element.attr("alt");
                    String src = element.attr("src");
                    if (!"".equals(name)) {
                        StringBuilder builder = new StringBuilder("insert into department (dname,address) values(");
                        builder.append("'");
                        builder.append(name);
                        builder.append("'");
                        builder.append(",");
                        builder.append("'");
                        builder.append(src);
                        builder.append("'");
                        builder.append(")");
                        System.out.println(builder);
                        statement.addBatch(builder.toString());
                    }
                }
            } catch (Exception e) {
                System.out.println("第" + i + "获取出错了" + ":::::::::::::::::::::::");
            }
            if (i % 100 == 0) {
                try {
                    System.out.println("第" + i + "个提交");
                    statement.executeBatch();
                    conn.commit();
                    System.out.println("提交完毕");
                } catch (Exception e) {
                    System.out.println("第" + i + "sql出错了::::::::::::::::::::::::::::::::::::::::::::");
                }

            }
        }

    }
}
/**
 * //                    String title = doc.title();
 * //        long a  = System.currentTimeMillis();
 * <p>
 * //            String sql = "insert into department (dname,address) values(?,?)";
 * //            PreparedStatement pstmt;
 * //            pstmt = conn.prepareStatement(sql);
 * //                            pstmt.setString(1,name);
 * //                            pstmt.setString(2,src);
 *///                    System.out.println("出错了" + ":::::::::::::::::::::::");

//        long b  = System.currentTimeMillis();
//            System.out.println(b-a);
//        Document doc = null;
//        try {
//            long a  = System.currentTimeMillis();
//            for(int i = 2;i<5000;i++){
//                try {
//                    doc = Jsoup.connect("http://www.duokan.com/book/"+i).get();
//                    String title = doc.title();
//                    System.out.println(title);
//                }catch (Exception e){
//                    System.out.println(i+"出错了"+":::::::::::::::::::::::");
//                }
//
//            }
//            long b  = System.currentTimeMillis();
//            System.out.println(b-a);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        String title = doc.title();

/**
 * //            String sql = "insert into department (dname,address) values(?,?)";
 * //            PreparedStatement pstmt;
 * //            pstmt = conn.prepareStatement(sql);
 *             //                            pstmt.setString(1,name);
 * //                            pstmt.setString(2,src);
 */