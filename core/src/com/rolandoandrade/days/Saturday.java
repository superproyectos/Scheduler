package com.rolandoandrade.days;

public class Saturday extends Day
{
    @Override
    public boolean isMyDay(int day)
    {
        return day==5;
    }

    @Override
    public String getDayName()
    {
        return "Sábado";
    }
}
