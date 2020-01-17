package com.seesea.job.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "boss_area_info")
public class BossAreaInfo implements Serializable {
    @Id
    @Column(name = "primary_key")
    private Integer primaryKey;

    private String area;

    @Column(name = "area_code")
    private String areaCode;

    @Column(name = "province_key")
    private Integer provinceKey;

    @Column(name = "city_key")
    private Integer cityKey;

    private static final long serialVersionUID = 1L;

    /**
     * @return primary_key
     */
    public Integer getPrimaryKey() {
        return primaryKey;
    }

    /**
     * @param primaryKey
     */
    public void setPrimaryKey(Integer primaryKey) {
        this.primaryKey = primaryKey;
    }

    /**
     * @return area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return area_code
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * @param areaCode
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * @return province_key
     */
    public Integer getProvinceKey() {
        return provinceKey;
    }

    /**
     * @param provinceKey
     */
    public void setProvinceKey(Integer provinceKey) {
        this.provinceKey = provinceKey;
    }

    /**
     * @return city_key
     */
    public Integer getCityKey() {
        return cityKey;
    }

    /**
     * @param cityKey
     */
    public void setCityKey(Integer cityKey) {
        this.cityKey = cityKey;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", primaryKey=").append(primaryKey);
        sb.append(", area=").append(area);
        sb.append(", areaCode=").append(areaCode);
        sb.append(", provinceKey=").append(provinceKey);
        sb.append(", cityKey=").append(cityKey);
        sb.append("]");
        return sb.toString();
    }
}