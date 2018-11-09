package com.rolandoandrade;

import com.rolandoandrade.days.Day;
import java.util.ArrayList;
import java.util.List;

public class Information
{
    private String subject;
    private String teachersName;
    private String nrc;
    private List<HourOfClass> hourOfClasses;

    public Information(String subject, String teachersName, String nrc)
    {
        this.subject=subject;
        this.teachersName=teachersName;
        this.nrc=nrc;
        hourOfClasses=new ArrayList<HourOfClass>();
    }

    public void addClass(HourOfClass hourOfClass)
    {
        hourOfClasses.add(hourOfClass);
    }

    public String getSubject()
    {
        return subject;
    }

    public String getTeachersName()
    {
        return teachersName;
    }

    public String getNrc()
    {
        return nrc;
    }

    public int getClassDurationOn(Day day)
    {
        for (HourOfClass h:hourOfClasses)
            if(h.getDay().isMyDay(day))
                return h.getTotalHours();
        return 0;
    }

    public boolean isAtMyHour(HourOfClass hourOfClass)
    {
        for (HourOfClass h:hourOfClasses)
            if(h.isMe(hourOfClass))
                return true;
        return false;
    }
}
