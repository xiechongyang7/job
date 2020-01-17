package com.seesea.job.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "boss_experience_info")
public class BossExperienceInfo implements Serializable {
    @Id
    @Column(name = "primary_key")
    private Integer primaryKey;

    private String experience;

    @Column(name = "experience_code")
    private String experienceCode;

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
     * @return experience
     */
    public String getExperience() {
        return experience;
    }

    /**
     * @param experience
     */
    public void setExperience(String experience) {
        this.experience = experience;
    }

    /**
     * @return experience_code
     */
    public String getExperienceCode() {
        return experienceCode;
    }

    /**
     * @param experienceCode
     */
    public void setExperienceCode(String experienceCode) {
        this.experienceCode = experienceCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", primaryKey=").append(primaryKey);
        sb.append(", experience=").append(experience);
        sb.append(", experienceCode=").append(experienceCode);
        sb.append("]");
        return sb.toString();
    }
}