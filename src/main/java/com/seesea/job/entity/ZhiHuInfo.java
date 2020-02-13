package com.seesea.job.entity;

import javax.persistence.Column;
import java.util.Date;

public class ZhiHuInfo {

//    {
//        "id": 89557274,
//            "type": "answer",
//            "answer_type": "normal",
//            "question": {
//        "type": "question",
//                "id": 39501641,
//                "title": "被不会撩妹的男人强撩是种怎样的体验？",
//                "question_type": "normal",
//                "created": 1452823329,
//                "updated_time": 1580284852,
//                "url": "https://www.zhihu.com/api/v4/questions/39501641",
//                "relationship": {}
//    },
//        "author": {
//        "id": "cc787c1c7a9a63f07619907e25cd86f8",
//                "url_token": "sun-quan-77-95",
//                "name": "孙泉",
//                "avatar_url": "https://pic4.zhimg.com/292743f2c7b7206d04f899db1cbd2665_is.jpg",
//                "avatar_url_template": "https://pic4.zhimg.com/292743f2c7b7206d04f899db1cbd2665_{size}.jpg",
//                "is_org": false,
//                "type": "people",
//                "url": "https://www.zhihu.com/api/v4/people/cc787c1c7a9a63f07619907e25cd86f8",
//                "user_type": "people",
//                "headline": "深腐多年的旅游从业者，泰国贸易，辣妈",
//                "badge": [],
//        "gender": 0,
//                "is_advertiser": false,
//                "is_privacy": false
//    },
//        "url": "https://www.zhihu.com/api/v4/answers/89557274",
//            "is_collapsed": false,
//            "created_time": 1457309824,
//            "updated_time": 1457309824,
//            "extras": "",
//            "is_copyable": true,
//            "relationship": {
//        "upvoted_followees": []
//    },
//        "ad_answer": null
//    }
    private ZhiHuAuthor author;
    private String url;
    private String createdTime;
    private String updatedTime;
    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

    public ZhiHuAuthor getAuthor() {
        return author;
    }

    public void setAuthor(ZhiHuAuthor author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
