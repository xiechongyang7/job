package com.seesea.job.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "boss_salary_info")
public class BossSalaryInfo implements Serializable {
    @Id
    @Column(name = "primary_key")
    private Integer primaryKey;

    private String salary;

    @Column(name = "salary_code")
    private String salaryCode;

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
     * @return salary
     */
    public String getSalary() {
        return salary;
    }

    /**
     * @param salary
     */
    public void setSalary(String salary) {
        this.salary = salary;
    }

    /**
     * @return salary_code
     */
    public String getSalaryCode() {
        return salaryCode;
    }

    /**
     * @param salaryCode
     */
    public void setSalaryCode(String salaryCode) {
        this.salaryCode = salaryCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", primaryKey=").append(primaryKey);
        sb.append(", salary=").append(salary);
        sb.append(", salaryCode=").append(salaryCode);
        sb.append("]");
        return sb.toString();
    }
}