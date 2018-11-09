package com.rolandoandrade;

import com.rolandoandrade.days.Day;

public class HourOfClass
{
    private Day day;
    private int start;
    private int end;

    public HourOfClass(Day day,int start,int end)
    {
        this.day=day;
        this.start=start;
        this.end=end;
    }

    public boolean isMe(HourOfClass hourOfClass)
    {
        return start==hourOfClass.getStart()&&end==hourOfClass.getEnd()&&
                day.isMyDay(hourOfClass.getDay());
    }

    public int getTotalHours()
    {
        return end-start;
    }

    public int getStart()
    {
        return start;
    }

    public int getEnd()
    {
        return end;
    }

    public Day getDay()
    {
        return day;
    }
}
