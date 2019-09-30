package com.gl.jxt.domain;

public class MemberOrder {

    private Integer id;

    private Member member;

    private Item item;

    private Category category;

    private Group group;

    private Teacher teacher;

    @Override
    public String toString () {
        return "MemberOrder{" +
                "id=" + id +
                ", member=" + member +
                ", item=" + item +
                ", category=" + category +
                ", group=" + group +
                ", teacher=" + teacher +
                '}';
    }

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public Member getMember () {
        return member;
    }

    public void setMember (Member member) {
        this.member = member;
    }

    public Item getItem () {
        return item;
    }

    public void setItem (Item item) {
        this.item = item;
    }

    public Category getCategory () {
        return category;
    }

    public void setCategory (Category category) {
        this.category = category;
    }

    public Group getGroup () {
        return group;
    }

    public void setGroup (Group group) {
        this.group = group;
    }

    public Teacher getTeacher () {
        return teacher;
    }

    public void setTeacher (Teacher teacher) {
        this.teacher = teacher;
    }
}
