package com.company;

public class nurse extends staff implements iStaff{
    @Override
    public double calculateOvertime(int overtime)
    {
        return this.overtimeDays*150;
    }
}
