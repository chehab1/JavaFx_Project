package com.company;

public class tech extends staff implements iStaff{
    @Override
    public double calculateOvertime(int overtimeDays) {
        return this.overtimeDays*100;
    }
}
