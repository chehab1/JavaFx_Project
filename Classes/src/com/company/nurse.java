package com.company;

public class nurse extends staff implements iStaff{
    @Override
    public double staffCalculateOvertime(int overtime)
    {
        return this.staffOvertimeDays*150;
    }
}
