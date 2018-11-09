package com.rolandoandrade.text.labels;

public class HourRangeLabel implements Label
{
    private int start;
    public HourRangeLabel(int start)
    {
        this.start = start;
    }

    @Override
    public String getLabel()
    {
        return start+":00 a "+(start+1)+":00";
    }
}
