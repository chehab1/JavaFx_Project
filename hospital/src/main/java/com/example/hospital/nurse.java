package com.example.hospital;

public class nurse extends staff implements iStaff{
    @Override
    public int staffCalculateOvertime(int overtime)
    {
        return overtime*150;
    }
}
