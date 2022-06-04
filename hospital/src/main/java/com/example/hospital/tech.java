package com.example.hospital;

public class tech extends staff implements iStaff{
    @Override
    public int staffCalculateOvertime(int overtimeDays) {
        return overtimeDays*100;
    }
}
