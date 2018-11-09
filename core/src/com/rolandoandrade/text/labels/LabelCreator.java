package com.rolandoandrade.text.labels;

public class LabelCreator
{
    public static Label createLabel(final String s)
    {
        return new Label()
        {
            @Override
            public String getLabel()
            {
                return s;
            }
        };
    }
}
