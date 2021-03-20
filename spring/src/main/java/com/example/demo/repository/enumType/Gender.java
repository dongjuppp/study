package com.example.demo.repository.enumType;

public enum Gender {
    M("Male"),
    F("Female");

    String gender;

    Gender(String gender){
        this.gender=gender;
    }

    public String getGender(){
        return gender;
    }
}