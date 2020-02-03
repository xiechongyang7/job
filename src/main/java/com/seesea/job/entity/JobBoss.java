package com.seesea.job.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "job_boss")
public class JobBoss implements Serializable {
    @Id
    @Column(name = "primary_key")
    private Integer primaryKey;

    @Column(name = "job_name")
    private String jobName;

    @Column(name = "company_name")
    private String companyName;

    private String area;

    private String city;

    private String experience;

    private String educational;

    private String url;

    @Column(name = "creat_time")
    private Date creatTime;

    @Column(name = "salary_height")
    private String salaryHeight;

    @Column(name = "salary_low")
    private String salaryLow;

    private String type;

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
     * @return job_name
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * @param jobName
     */
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    /**
     * @return company_name
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return creat_time
     */
    public Date getCreatTime() {
        return creatTime;
    }

    /**
     * @param creatTime
     */
    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    /**
     * @return salary_height
     */
    public String getSalaryHeight() {
        return salaryHeight;
    }

    /**
     * @param salaryHeight
     */
    public void setSalaryHeight(String salaryHeight) {
        this.salaryHeight = salaryHeight;
    }

    /**
     * @return salary_low
     */
    public String getSalaryLow() {
        return salaryLow;
    }

    /**
     * @param salaryLow
     */
    public void setSalaryLow(String salaryLow) {
        this.salaryLow = salaryLow;
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", primaryKey=").append(primaryKey);
        sb.append(", jobName=").append(jobName);
        sb.append(", companyName=").append(companyName);
        sb.append(", area=").append(area);
        sb.append(", city=").append(city);
        sb.append(", experience=").append(experience);
        sb.append(", educational=").append(educational);
        sb.append(", url=").append(url);
        sb.append(", creatTime=").append(creatTime);
        sb.append(", salaryHeight=").append(salaryHeight);
        sb.append(", salaryLow=").append(salaryLow);
        sb.append(", type=").append(type);
        sb.append("]");
        return sb.toString();
    }
}