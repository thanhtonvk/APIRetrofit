package com.tondz.apiretrofit;

import com.google.gson.annotations.SerializedName;

public class Student {
    @SerializedName("_id")
    private String ID;
    @SerializedName("name")
    private String Name;
    @SerializedName("dateofbirth")
    private String DateOfBirth;
    @SerializedName("gender")
    private String Gender;
    @SerializedName("address")
    private String Address;


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Student(String ID, String name, String dateOfBirth, String gender, String address) {
        this.ID = ID;
        Name = name;
        DateOfBirth = dateOfBirth;
        Gender = gender;
        Address = address;
    }

    public Student(String name, String dateOfBirth, String gender, String address) {
        Name = name;
        DateOfBirth = dateOfBirth;
        Gender = gender;
        Address = address;
    }
}
