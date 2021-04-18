package com.company.model;

import com.company.interfaces.IAccounting;

/**
  @author   Volodymyr Lakusta
  @project   vsem3part2
  @class  BusinessSitting
  @version  1.0.0 
  @since 07.04.2021 - 20.59
**/

public class BusinessSitting implements IAccounting {

    private int number;
    private String passengerName;
    private double price;

    public BusinessSitting(int number, String passengerName, double price) {
        this.number = number;
        this.passengerName = passengerName;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int seatNumber() {
        return number;
    }

    @Override
    public String passengerName() {
        return passengerName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
