package com.gl.jxt.domain;

import java.util.Date;

public class Order {

    private Integer id;

    private Integer type;

    private MemberOrder memberOrder;

    private Group group;

    private Date createTime;

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public Integer getType () {
        return type;
    }

    public void setType (Integer type) {
        this.type = type;
    }

    public MemberOrder getMemberOrder () {
        return memberOrder;
    }

    public void setMemberOrder (MemberOrder memberOrder) {
        this.memberOrder = memberOrder;
    }

    public Group getGroup () {
        return group;
    }

    public void setGroup (Group group) {
        this.group = group;
    }

    public Date getCreateTime () {
        return createTime;
    }

    public void setCreateTime (Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString () {
        return "Order{" +
                "id=" + id +
                ", type=" + type +
                ", memberOrder=" + memberOrder +
                ", group=" + group +
                ", createTime=" + createTime +
                '}';
    }
}
