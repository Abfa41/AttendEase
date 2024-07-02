package com.example.attendease.Model;

import io.realm.RealmObject;

public class Student extends RealmObject {
    private String pin,name,phone;

    public Student() {
        // Default Constructor...
    }

    public Student(String pin, String name, String phone) {
        this.pin = pin;
        this.name = name;
        this.phone = phone;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
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
}
