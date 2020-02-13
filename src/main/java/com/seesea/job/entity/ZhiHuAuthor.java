package com.seesea.job.entity;

public class ZhiHuAuthor {
    /**
     * "author": {
     * //        "id": "cc787c1c7a9a63f07619907e25cd86f8",
     * //                "url_token": "sun-quan-77-95",
     * //                "name": "孙泉",
     * //                "avatar_url": "https://pic4.zhimg.com/292743f2c7b7206d04f899db1cbd2665_is.jpg",
     * //                "avatar_url_template": "https://pic4.zhimg.com/292743f2c7b7206d04f899db1cbd2665_{size}.jpg",
     * //                "is_org": false,
     * //                "type": "people",
     * //                "url": "https://www.zhihu.com/api/v4/people/cc787c1c7a9a63f07619907e25cd86f8",
     * //                "user_type": "people",
     * //                "headline": "深腐多年的旅游从业者，泰国贸易，辣妈",
     * //                "badge": [],
     * //        "gender": 0,
     * //                "is_advertiser": false,
     * //                "is_privacy": false
     * //    },
     */

    private String id;
    private String url_token;
    private String name;
    private String url;
    private String headline;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl_token() {
        return url_token;
    }

    public void setUrl_token(String url_token) {
        this.url_token = url_token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }
}
