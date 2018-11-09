package com.rolandoandrade.days;

public class Monday extends Day
{
    @Override
    public boolean isMyDay(int day)
    {
        return day==0;
    }

    @Override
    public String getDayName()
    {
        return "Lunes";
    }
}
