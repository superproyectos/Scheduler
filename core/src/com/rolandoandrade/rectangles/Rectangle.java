package com.rolandoandrade.rectangles;

import com.rolandoandrade.actions.Removable;
import com.rolandoandrade.color.Color;
import com.rolandoandrade.Dimensions;
import com.rolandoandrade.actions.Dynamic;
import com.rolandoandrade.actions.Draggable;
import com.rolandoandrade.actions.Drawable;

public abstract class Rectangle implements Drawable,Draggable,Dynamic, Removable
{
    private Dimensions dimensions;

    private Color color;

    private int deep =0;

    public Rectangle(Dimensions dimensions)
    {
        this.dimensions = dimensions;
    }

    public Rectangle(float x, float y, float width, float height)
    {
        this.dimensions =new Dimensions(x,y,width,height);
    }

    public float getX()
    {
        return dimensions.getX();
    }

    public void setX(float x)
    {
        dimensions.setX(x);
    }

    public void setPosition(float x, float y)
    {
        setX(x);
        setY(y);
    }

    public float getY()
    {
        return dimensions.getY();
    }

    public void setY(float y)
    {
        dimensions.setY(y);
    }

    public float getWidth()
    {
        return dimensions.getWidth();
    }

    public void setWidth(int width)
    {
        if(width>=0)
            dimensions.setWidth(width);
    }

    public float getHeight()
    {
        return dimensions.getHeight();
    }

    public void setHeight(float height)
    {
        if(height>=0)
            dimensions.setHeight(height);
    }

    public void setColor(Color color)
    {
        this.color=color;
        paintRectangleWithColor();
    }

    public Color getColor()
    {
        return color;
    }

    public boolean contains(float x, float y)
    {
        return x>=getX()&&x<=getX()+getWidth()&&y>=getY()&&y<=getHeight()+getY();
    }

    public Dimensions getDimensions()
    {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions)
    {
        this.dimensions=new Dimensions(dimensions.getX(),dimensions.getY(),dimensions.getWidth(),dimensions.getHeight());
    }

    public void move(float delta)
    {
        setY(getY()+delta);
    }

    @Override
    public int getDeep()
    {
        return deep;
    }

    public abstract void paintRectangleWithColor();

}
