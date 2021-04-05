package com.seesea.job.entity;

import java.io.Serializable;
import javax.persistence.*;

public class Town implements Serializable {
    @Id
    private Integer id;

    private String town;

    private String name;

    private String pinyin;

    private Integer num;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return pinyin
     */
    public String getPinyin() {
        return pinyin;
    }

    /**
     * @param pinyin
     */
    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    /**
     * @return num
     */
    public Integer getNum() {
        return num;
    }

    /**
     * @param num
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", town=").append(town);
        sb.append(", name=").append(name);
        sb.append(", pinyin=").append(pinyin);
        sb.append(", num=").append(num);
        sb.append("]");
        return sb.toString();
    }
}