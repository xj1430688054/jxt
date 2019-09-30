package com.gl.jxt.domain;

import java.util.List;
import java.util.Objects;

public class Category {

    private Integer id;

    private String name;

    private Department department;

    private List<Teacher> teachers;

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

    public Department getDepartment () {
        return department;
    }

    public void setDepartment (Department department) {
        this.department = department;
    }

    public List<Teacher> getTeachers () {
        return teachers;
    }

    public void setTeachers (List<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString () {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department=" + department +
                ", teachers=" + teachers +
                '}';
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
        return Objects.equals(getName(), category.getName());
    }

    @Override
    public int hashCode () {

        return Objects.hash(getName());
    }
}
