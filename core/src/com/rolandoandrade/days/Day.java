package com.rolandoandrade.days;

public abstract class Day
{
    public boolean isMyDay(Day day)
    {
        return day.getDayName().equals(getDayName());
    }
    public abstract boolean isMyDay(int day);
    public abstract String getDayName();
}
