package com.company;

public abstract class staff {
     String name;
     int remainingVacationDays=30;
     int overtimeDays;

    public abstract double calculateOvertime(int overtimeDays);
    public int calculateRemainingVacationDays()
    {
        return remainingVacationDays;
    }

}
