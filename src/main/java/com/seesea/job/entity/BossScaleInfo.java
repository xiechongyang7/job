package com.seesea.job.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "boss_scale_info")
public class BossScaleInfo implements Serializable {
    @Id
    @Column(name = "primary_key")
    private Integer primaryKey;

    private String scale;

    @Column(name = "scale_code")
    private String scaleCode;

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
     * @return scale
     */
    public String getScale() {
        return scale;
    }

    /**
     * @param scale
     */
    public void setScale(String scale) {
        this.scale = scale;
    }

    /**
     * @return scale_code
     */
    public String getScaleCode() {
        return scaleCode;
    }

    /**
     * @param scaleCode
     */
    public void setScaleCode(String scaleCode) {
        this.scaleCode = scaleCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", primaryKey=").append(primaryKey);
        sb.append(", scale=").append(scale);
        sb.append(", scaleCode=").append(scaleCode);
        sb.append("]");
        return sb.toString();
    }
}