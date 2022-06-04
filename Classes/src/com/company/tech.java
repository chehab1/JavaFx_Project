package com.company;

public class tech extends staff implements iStaff{
    @Override
    public double staffCalculateOvertime(int overtimeDays) {
        return this.staffOvertimeDays*100;
    }
}
