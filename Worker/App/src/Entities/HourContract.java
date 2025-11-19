package Entities;

import java.util.Date;

public class HourContract {
    private Date date;
    private double valuePerHour;
    private Integer hours;

    public Date getDate() {
        return date;
    }

    public double getValuePerHour() {
        return valuePerHour;
    }

    public Integer getHours() {
        return hours;
    }

    public HourContract(Date date, double valuePerHour, Integer hours) {
        this.date = date;
        this.valuePerHour = valuePerHour;
        this.hours = hours;
    }

    public double totalValue(){

        return this.valuePerHour * this.hours;
    }
}



