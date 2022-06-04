package com.company;

public class doctor extends staff implements iStaff{
    private String drSpeciality;

    @Override
    public double staffCalculateOvertime(int overtimeDays)
    {
        return this.staffOvertimeDays*250;
    }
}
