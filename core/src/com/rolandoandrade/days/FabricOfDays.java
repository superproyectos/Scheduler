package com.rolandoandrade.days;

public class FabricOfDays
{
    public static Day createDay(int i)
    {
        switch (i)
        {
            case 0:
                return new Monday();
            case 1:
                return new Tuesday();
            case 2:
                return new Wednesday();
            case 3:
                return new Thursday();
            case 4:
                return new Friday();
            case 5:
                return new Saturday();
            case 6:
                return new Sunday();
        }
        return null;
    }
}
