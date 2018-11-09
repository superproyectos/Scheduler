package com.rolandoandrade.days;

public class Friday extends Day
{
    @Override
    public boolean isMyDay(int day)
    {
        return day==4;
    }

    @Override
    public String getDayName()
    {
        return "Viernes";
    }
}
