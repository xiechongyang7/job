package com.seesea.job.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "boss_city_info")
public class BossCityInfo implements Serializable {
    @Id
    @Column(name = "primary_key")
    private Integer primaryKey;

    private String city;

    @Column(name = "city_code")
    private String cityCode;

    @Column(name = "province_key")
    private Integer provinceKey;

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
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return city_code
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * @param cityCode
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", primaryKey=").append(primaryKey);
        sb.append(", city=").append(city);
        sb.append(", cityCode=").append(cityCode);
        sb.append(", provinceKey=").append(provinceKey);
        sb.append("]");
        return sb.toString();
    }
}