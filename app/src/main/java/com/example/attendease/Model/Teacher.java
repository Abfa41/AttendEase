package com.example.attendease.Model;

import io.realm.RealmObject;


public class Teacher extends RealmObject {
    public Teacher() {
        // Default Constructor....
    }

    public Teacher(String teacher_ID, String name, String phone) {
        this.teacher_ID = teacher_ID;
        this.name = name;
        this.phone = phone;
    }

    public String getTeacher_ID() {
        return teacher_ID;
    }

    public void setTeacher_ID(String teacher_ID) {
        this.teacher_ID = teacher_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String teacher_ID,name,phone;

}
