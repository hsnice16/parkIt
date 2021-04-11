package com.example.parkit;

import java.io.Serializable;

public class AddressDetails implements Serializable {

    private String address;
    private int pinCode;
    private String city;
    private String state;
    private String country;

    public AddressDetails(){}

    public AddressDetails(String address, int pinCode, String city, String state, String country){
        this.address = address;
        this.pinCode = pinCode;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public int getPinCode(){
        return pinCode;
    }

    public void setPinCode(int pinCode){
        this.pinCode = pinCode;
    }

    public  String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getState(){
        return state;
    }

    public void setState(String state){
        this.state = state;
    }

    public String getCountry(){
        return country;
    }

    public void setCountry(String country){
        this.country = country;
    }
}
