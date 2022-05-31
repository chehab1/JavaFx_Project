package com.company;

public class nurse extends staff{
    @Override
    public double calculateOvertime(int overtime)
    {
        return this.overtimeDays*150;
    }
}
