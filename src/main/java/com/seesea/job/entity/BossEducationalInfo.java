package com.seesea.job.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "boss_educational_info")
public class BossEducationalInfo implements Serializable {
    @Id
    @Column(name = "primary_key")
    private Integer primaryKey;

    private String educational;

    @Column(name = "educational_code")
    private String educationalCode;

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
     * @return educational
     */
    public String getEducational() {
        return educational;
    }

    /**
     * @param educational
     */
    public void setEducational(String educational) {
        this.educational = educational;
    }

    /**
     * @return educational_code
     */
    public String getEducationalCode() {
        return educationalCode;
    }

    /**
     * @param educationalCode
     */
    public void setEducationalCode(String educationalCode) {
        this.educationalCode = educationalCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", primaryKey=").append(primaryKey);
        sb.append(", educational=").append(educational);
        sb.append(", educationalCode=").append(educationalCode);
        sb.append("]");
        return sb.toString();
    }
}