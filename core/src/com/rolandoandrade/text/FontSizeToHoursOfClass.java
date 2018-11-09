package com.rolandoandrade.text;

import com.rolandoandrade.text.FontSize;

public class FontSizeToHoursOfClass implements FontSize
{
    private int fontSize;

    public FontSizeToHoursOfClass(int fontSize)
    {
        this.fontSize=fontSize;
    }

    @Override
    public int getFontSize(float width)
    {
        return (int)(width*fontSize/102.85714);
    }
}
