package com.rolandoandrade.days;

public class Wednesday extends Day
{
    @Override
    public boolean isMyDay(int day)
    {
        return day==2;
    }

    @Override
    public String getDayName()
    {
        return "Miércoles";
    }
}
