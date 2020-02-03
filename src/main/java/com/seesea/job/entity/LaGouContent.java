package com.seesea.job.entity;

/**
 * @description
 * @since JDK1.8
 * @createTime 2020/1/21 上午 10:57
 * @author xiechongyang
 */
public class LaGouContent {


    private String showId;
    private String hrInfoMap;
    private String pageNo;
    private LaGouResult positionResult;


    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public String getHrInfoMap() {
        return hrInfoMap;
    }

    public void setHrInfoMap(String hrInfoMap) {
        this.hrInfoMap = hrInfoMap;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public LaGouResult getPositionResult() {
        return positionResult;
    }

    public void setPositionResult(LaGouResult positionResult) {
        this.positionResult = positionResult;
    }
}
