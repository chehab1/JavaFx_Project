package com.example.hospital;

public class doctor extends staff implements iStaff{
    private String drSpeciality;

    public void setDrSpeciality(String drSpeciality) {
        this.drSpeciality = drSpeciality;
    }

    public String getDrSpeciality() {
        return drSpeciality;
    }

    @Override
    public int staffCalculateOvertime(int overtimeDays)
    {
        return overtimeDays*250;
    }
}
