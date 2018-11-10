package com.rolandoandrade.days;

public class NullDay extends Day
{
    @Override
    public boolean isMyDay(int day)
    {
        return day==-1;
    }

    @Override
    public String getDayName()
    {
        return "null";
    }
}
