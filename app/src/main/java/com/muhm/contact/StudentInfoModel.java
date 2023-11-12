package com.muhm.contact;

public class StudentInfoModel {
    String id;
    String serialNumber;
    String name;
    String roll;
    String fatherName;
    String address;

    public StudentInfoModel() {
    }

    public StudentInfoModel(String id, String serialNumber, String name, String roll, String fatherName, String address) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.name = name;
        this.roll = roll;
        this.fatherName = fatherName;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
