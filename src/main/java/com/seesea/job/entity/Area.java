package com.seesea.job.entity;

import java.io.Serializable;
import javax.persistence.*;

public class Area implements Serializable {
    private String id;

    @Column(name = "area_name")
    private String areaName;

    private String region;

    private String town;

    private String year;

    private String value;

    private String link;

    private String mark;

    private String clinch;

    private String rent;

    private String sale;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return area_name
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * @param areaName
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * @return region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * @return town
     */
    public String getTown() {
        return town;
    }

    /**
     * @param town
     */
    public void setTown(String town) {
        this.town = town;
    }

    /**
     * @return year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * @return value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * @return mark
     */
    public String getMark() {
        return mark;
    }

    /**
     * @param mark
     */
    public void setMark(String mark) {
        this.mark = mark;
    }

    /**
     * @return clinch
     */
    public String getClinch() {
        return clinch;
    }

    /**
     * @param clinch
     */
    public void setClinch(String clinch) {
        this.clinch = clinch;
    }

    /**
     * @return rent
     */
    public String getRent() {
        return rent;
    }

    /**
     * @param rent
     */
    public void setRent(String rent) {
        this.rent = rent;
    }

    /**
     * @return sale
     */
    public String getSale() {
        return sale;
    }

    /**
     * @param sale
     */
    public void setSale(String sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", areaName=").append(areaName);
        sb.append(", region=").append(region);
        sb.append(", town=").append(town);
        sb.append(", year=").append(year);
        sb.append(", value=").append(value);
        sb.append(", link=").append(link);
        sb.append(", mark=").append(mark);
        sb.append(", clinch=").append(clinch);
        sb.append(", rent=").append(rent);
        sb.append(", sale=").append(sale);
        sb.append("]");
        return sb.toString();
    }
}