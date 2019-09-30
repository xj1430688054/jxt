package com.gl.jxt.domain;

public class Member {

    private Integer id;

    //学号
    private String number;

    private String name;

    //系别名称
    private Department department;

    //班级名称
    private String className;

    //密码
    private String password;

    //联系电话
    private String contactPhone;

    //联系邮箱
    private String contactEmail;

    //选取状态
    private Integer state;

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getNumber () {
        return number;
    }

    public void setNumber (String number) {
        this.number = number;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public Department getDepartment () {
        return department;
    }

    public void setDepartment (Department department) {
        this.department = department;
    }

    public String getClassName () {
        return className;
    }

    public void setClassName (String className) {
        this.className = className;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public String getContactPhone () {
        return contactPhone;
    }

    public void setContactPhone (String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactEmail () {
        return contactEmail;
    }

    public void setContactEmail (String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public Integer getState () {
        return state;
    }

    public void setState (Integer state) {
        this.state = state;
    }

    @Override
    public String toString () {
        return "Member{" +
                "id=" + id +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", department=" + department +
                ", className='" + className + '\'' +
                ", password='" + password + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", state=" + state +
                '}';
    }
}
