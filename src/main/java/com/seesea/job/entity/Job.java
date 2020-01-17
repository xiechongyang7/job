package com.seesea.job.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Job implements Serializable {
    @Id
    @Column(name = "primary_key")
    private Integer primaryKey;

    @Column(name = "job_name")
    private String jobName;

    @Column(name = "company_name")
    private String companyName;

    private Long salary;

    private Integer area;

    private Integer city;

    private Integer experience;

    private Integer educational;

    private String url;

    @Column(name = "creat_time")
    private Date creatTime;

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
     * @return salary
     */
    public Long getSalary() {
        return salary;
    }

    /**
     * @param salary
     */
    public void setSalary(Long salary) {
        this.salary = salary;
    }

    /**
     * @return area
     */
    public Integer getArea() {
        return area;
    }

    /**
     * @param area
     */
    public void setArea(Integer area) {
        this.area = area;
    }

    /**
     * @return city
     */
    public Integer getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(Integer city) {
        this.city = city;
    }

    /**
     * @return experience
     */
    public Integer getExperience() {
        return experience;
    }

    /**
     * @param experience
     */
    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    /**
     * @return educational
     */
    public Integer getEducational() {
        return educational;
    }

    /**
     * @param educational
     */
    public void setEducational(Integer educational) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", primaryKey=").append(primaryKey);
        sb.append(", jobName=").append(jobName);
        sb.append(", companyName=").append(companyName);
        sb.append(", salary=").append(salary);
        sb.append(", area=").append(area);
        sb.append(", city=").append(city);
        sb.append(", experience=").append(experience);
        sb.append(", educational=").append(educational);
        sb.append(", url=").append(url);
        sb.append(", creatTime=").append(creatTime);
        sb.append("]");
        return sb.toString();
    }
}