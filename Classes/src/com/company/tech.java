package com.company;

public class tech extends staff{
    @Override
    public double calculateOvertime(int overtimeDays) {
        return this.overtimeDays*100;
    }
}
