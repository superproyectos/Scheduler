package com.rolandoandrade.days;

public class Thursday extends Day
{
    @Override
    public boolean isMyDay(int day)
    {
        return day==3;
    }

    @Override
    public String getDayName()
    {
        return "Jueves";
    }
}
