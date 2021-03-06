package com.neuedu.hospital_back.po;

import java.sql.Date;

public class Arrangement {
    private Integer aId;

    private Integer uId;

    private Integer plan;

    private Date aBegin;

    private Date aEnd;

    public String getdId() {
        return dId;
    }

    public void setdId(String dId) {
        this.dId = dId;
    }

    private String dId;

    public Arrangement() {
    }

    public Arrangement(Integer uId, Integer plan, Date aBegin, Date aEnd, String dId) {
        this.uId = uId;
        this.plan = plan;
        this.aBegin = aBegin;
        this.aEnd = aEnd;
        this.dId = dId;
    }

    public Arrangement(Integer aId, Integer uId, Integer plan, Date aBegin, Date aEnd, String dId) {
        this.aId = aId;
        this.uId = uId;
        this.plan = plan;
        this.aBegin = aBegin;
        this.aEnd = aEnd;
        this.dId = dId;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getPlan() {
        return plan;
    }

    public void setPlan(Integer plan) {
        this.plan = plan;
    }

    public Date getaBegin() {
        return aBegin;
    }

    public void setaBegin(Date aBegin) {
        this.aBegin = aBegin;
    }

    public Date getaEnd() {
        return aEnd;
    }

    public void setaEnd(Date aEnd) {
        this.aEnd = aEnd;
    }
}