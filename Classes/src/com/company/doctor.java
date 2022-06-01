package com.company;

public class doctor extends staff implements iStaff{
    private String speciality;

    @Override
    public double calculateOvertime(int overtimeDays)
    {
        return this.overtimeDays*250;
    }
}
