package com.gl.jxt.domain;

import java.util.List;

public class Teacher {

    private Integer id;

    private String name;

    //教师容量
    private Integer capacity;

    //学生数量
    private Integer studentCount;

    //备注
    private String content;

    //分类
    private List<Category> categories;

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

    public Integer getCapacity () {
        return capacity;
    }

    public void setCapacity (Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getStudentCount () {
        return studentCount;
    }

    public void setStudentCount (Integer studentCount) {
        this.studentCount = studentCount;
    }

    public String getContent () {
        return content;
    }

    public void setContent (String content) {
        this.content = content;
    }

    public List<Category> getCategory () {
        return categories;
    }

    public void setCategory (List<Category> category) {
        this.categories = category;
    }

    @Override
    public String toString () {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", studentCount=" + studentCount +
                ", content='" + content + '\'' +
                ", category=" + categories +
                '}';
    }
}
