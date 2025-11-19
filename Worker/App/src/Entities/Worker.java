package Entities;

import Enumeration.WorkLevel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Worker {

    private String name;
    private WorkLevel level;
    private double baseSalary;
    private List<HourContract> hourContractList;
    private Department dp;

    public Worker(String name, WorkLevel level, double baseSalary, Department dp) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.dp = dp;
        this.hourContractList = new ArrayList<>();
    }

    public void addContract(HourContract contract){

        this.hourContractList.add(contract);

    }

    public void removeContract(HourContract contract){

        this.hourContractList.remove(contract);

    }

    public double income(int year, int month){

        double sum = 0.0;

        Calendar cal = Calendar.getInstance();

        for (HourContract c : hourContractList){

            cal.setTime(c.getDate());

            int c_year = cal.get(Calendar.YEAR);
            int c_month = 1 + cal.get(Calendar.MONTH);
            // IMPORTANTE: MONTH começa em 0 → janeiro = 0

            if (c_year == year && c_month == month){
                sum += c.totalValue();
            }
        }

        return sum;

    }

    public String getName() {
        return name;
    }

    public Department getDp() {
        return dp;
    }
}
