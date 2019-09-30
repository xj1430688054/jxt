package com.gl.jxt.domain;

import java.util.Date;
import java.util.List;

public class Item {

    private Integer id ;

    private String name;

    private Integer type;

    private Integer state;

    private Date createTime;

    private List<CategoryItem> categories;

    @Override
    public String toString () {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", state=" + state +
                ", createTime=" + createTime +
                ", categories=" + categories +
                '}';
    }

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

    public Integer getType () {
        return type;
    }

    public void setType (Integer type) {
        this.type = type;
    }

    public Integer getState () {
        return state;
    }

    public void setState (Integer state) {
        this.state = state;
    }

    public Date getCreateTime () {
        return createTime;
    }

    public void setCreateTime (Date createTime) {
        this.createTime = createTime;
    }

    public List<CategoryItem> getCategories () {
        return categories;
    }

    public void setCategories (List<CategoryItem> categories) {
        this.categories = categories;
    }
}
