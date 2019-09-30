package com.gl.jxt.domain;

import java.util.Date;
import java.util.List;

public class Group {

    private Integer id;

    private String name;

    private Member captain;

    private Integer captainId;

    private Date creatTime;

    private List<MemberOrder> members;

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public Member getCaptain () {
        return captain;
    }

    public void setCaptain (Member captain) {
        this.captain = captain;
    }

    public Integer getCaptainId () {
        return captainId;
    }

    public void setCaptainId (Integer captainId) {
        this.captainId = captainId;
    }

    public Date getCreatTime () {
        return creatTime;
    }

    public void setCreatTime (Date creatTime) {
        this.creatTime = creatTime;
    }

    public List<MemberOrder> getMembers () {
        return members;
    }

    public void setMembers (List<MemberOrder> members) {
        this.members = members;
    }

    @Override
    public String toString () {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", captain=" + captain +
                ", captainId=" + captainId +
                ", creatTime=" + creatTime +
                ", members=" + members +
                '}';
    }
}
