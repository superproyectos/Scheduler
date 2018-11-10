package com.rolandoandrade;

public class Dimensions
{
    public static final float widthDIVheight=9/5f;
    private float x;
    private float y;
    private float width;
    private float height;
    private static float screenWidth=720;
    private static float screenHeight=400;

    public Dimensions()
    {
        x=y=width=height=0;
    }

    public Dimensions(float x, float y)
    {
        this.x = x;
        this.y = y;
        width=height=0;
    }

    public Dimensions(float x, float y, float width, float height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public static float getScreenWidth()
    {
        return screenWidth;
    }

    public static void setScreenWidth(float screenWidth)
    {
        Dimensions.screenWidth = screenWidth;
    }

    public static float getScreenHeight()
    {
        return screenHeight;
    }

    public static void setScreenHeight(float screenHeight)
    {
        Dimensions.screenHeight = screenHeight;
    }


    public float getX()
    {
        return x;
    }

    public void setX(float x)
    {
        this.x = x;
    }

    public float getY()
    {
        return y;
    }

    public void setY(float y)
    {
        this.y = y;
    }

    public float getWidth()
    {
        return width;
    }

    public void setWidth(float width)
    {
        this.width = width;
    }

    public float getHeight()
    {
        return height;
    }

    public void setHeight(float height)
    {
        this.height = height;
    }

    public boolean equals(Dimensions d)
    {
        return d.getHeight()==getHeight()&&d.getWidth()==getWidth()&&d.getX()==getX()&&d.getY()==getY();
    }
}
