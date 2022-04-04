package com.tondz.apiretrofit;

public class Student {
    private int ID;
    private String Name;
    private String DateOfBirth;
    private int ClassRoom;
    private String Address;
    private String Avatar;

    public Student(int ID, String name, String dateOfBirth, int classRoom, String address, String avatar) {
        this.ID = ID;
        Name = name;
        DateOfBirth = dateOfBirth;
        ClassRoom = classRoom;
        Address = address;
        Avatar = avatar;
    }
    public Student( String name, String dateOfBirth, int classRoom, String address, String avatar) {
        Name = name;
        DateOfBirth = dateOfBirth;
        ClassRoom = classRoom;
        Address = address;
        Avatar = avatar;
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
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

    public int getClassRoom() {
        return ClassRoom;
    }

    public void setClassRoom(int classRoom) {
        ClassRoom = classRoom;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String avatar) {
        Avatar = avatar;
    }
}
