package com.seesea.job.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "boss_financing_info")
public class BossFinancingInfo implements Serializable {
    @Id
    @Column(name = "primary_key")
    private Integer primaryKey;

    private String financing;

    @Column(name = "financing_code")
    private String financingCode;

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
     * @return financing
     */
    public String getFinancing() {
        return financing;
    }

    /**
     * @param financing
     */
    public void setFinancing(String financing) {
        this.financing = financing;
    }

    /**
     * @return financing_code
     */
    public String getFinancingCode() {
        return financingCode;
    }

    /**
     * @param financingCode
     */
    public void setFinancingCode(String financingCode) {
        this.financingCode = financingCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", primaryKey=").append(primaryKey);
        sb.append(", financing=").append(financing);
        sb.append(", financingCode=").append(financingCode);
        sb.append("]");
        return sb.toString();
    }
}