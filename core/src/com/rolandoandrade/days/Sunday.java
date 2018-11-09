package com.rolandoandrade.days;

public class Sunday extends Day
{
    @Override
    public boolean isMyDay(int day)
    {
        return day==6;
    }

    @Override
    public String getDayName()
    {
        return "Domingo";
    }
}
