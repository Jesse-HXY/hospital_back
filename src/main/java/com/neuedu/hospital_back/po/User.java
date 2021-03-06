package com.neuedu.hospital_back.po;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Integer uId;

    private String uNickName;

    private String uPassword;

    private String uName;

    private Boolean isDoctor;

    private String uCategory;

    private List<Department> departments = new ArrayList<>();

    public Boolean getDoctor() {
        return isDoctor;
    }

    public void setDoctor(Boolean doctor) {
        isDoctor = doctor;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuNickName() {
        return uNickName;
    }

    public void setuNickName(String uNickName) {
        this.uNickName = uNickName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public Boolean getIsDoctor() {
        return isDoctor;
    }

    public void setIsDoctor(Boolean isDoctor) {
        this.isDoctor = isDoctor;
    }

    public String getuCategory() {
        return uCategory;
    }

    public void setuCategory(String uCategory) {
        this.uCategory = uCategory;
    }
}