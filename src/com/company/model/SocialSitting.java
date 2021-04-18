package com.company.model;

import com.company.interfaces.IAccounting;

/**
  @author   Volodymyr Lakusta
  @project   vsem3part2
  @class  SocialSitting
  @version  1.0.0 
  @since 07.04.2021 - 20.58
**/

public class SocialSitting implements IAccounting {

    private int number;
    private String passengerName;
    private Exemptions exemption;
    private double grossPrice;

    public SocialSitting(int number, String passengerName, Exemptions exemption, double grossPrice) {
        this.number = number;
        this.passengerName = passengerName;
        this.exemption = exemption;
        this.grossPrice = grossPrice;
    }


    @Override
    public double getPrice() {
        switch (exemption){
            case STUDENT: return grossPrice * 0.5;
            case PENSIONER: return grossPrice * 0.7;
            case OTHER: return grossPrice * 0.8;
            default: return grossPrice;
        }
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

    public Exemptions getPrivilege() {
        return exemption;
    }

    public void setPrivilege(Exemptions exemption) {
        this.exemption = exemption;
    }

    public double getGrossPrice() {
        return grossPrice;
    }

    public void setGrossPrice(double grossPrice) {
        this.grossPrice = grossPrice;
    }
}
