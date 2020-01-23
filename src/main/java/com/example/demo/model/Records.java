package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Records {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int RollNo;
    private String Myname;
    private String Hobby;
    private String gender;
    public int getRollNo() {
        return RollNo;
    }

    public void setRollNo(int rollNo) {
        RollNo = rollNo;
    }

    public String getMyname() {
        return Myname;
    }

    public void setMyname(String myname) {
        Myname = myname;
    }

    public String getHobby() {
        return Hobby;
    }

    public void setHobby(String hobby) {
        Hobby = hobby;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
