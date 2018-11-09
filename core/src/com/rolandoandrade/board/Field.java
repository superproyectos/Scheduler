package com.rolandoandrade.board;

import com.rolandoandrade.color.Color;
import com.rolandoandrade.Dimensions;
import com.rolandoandrade.fabrics.Fabric;
import com.rolandoandrade.actions.Dynamic;
import com.rolandoandrade.actions.Drawable;
import com.rolandoandrade.rectangles.Rectangle;

public class Field implements Drawable,Dynamic
{
    private Rectangle field;

    public Field(int row, int column, int totalColumns, Fabric fabric)
    {
        createRectangle(row,column,totalColumns,fabric);
    }

    private void createRectangle(int row, int column, int totalColumns, Fabric fabric)
    {
        final float width = Dimensions.getScreenWidth() / totalColumns;
        final float height = width * 1/Dimensions.widthDIVheight;
        final float x = column * width;
        final float y = row * height;
        field=fabric.createNormalRectangle(x,y,width,height);
        field.setColor(row%2==0?Color.CYAN:Color.changeAlpha(Color.CYAN,0.8f));
        field.setColor(column%2==0?field.getColor():Color.changeAlpha(field.getColor(),field.getColor().a-0.1f));
    }

    @Override
    public void draw()
    {
        field.draw();
    }

    @Override
    public int getDeep()
    {
        return -1;
    }

    public void move(float delta)
    {
        field.move(delta);
    }

    public Dimensions getDimensions()
    {
        return field.getDimensions();
    }

    public boolean contains(float x, float y)
    {
        return field.contains(x,y);
    }
}