package com.rolandoandrade.cards;

import com.rolandoandrade.Validator;
import com.rolandoandrade.actions.Draggable;
import com.rolandoandrade.actions.Dynamic;
import com.rolandoandrade.fabrics.Fabric;
import com.rolandoandrade.rectangles.Rectangle;

public class Card implements Dynamic,Draggable
{
    private Rectangle rectangle;
    private Validator validator;

    public Card(float x, float y, float width, float height, Fabric fabric, Validator validator)
    {
        rectangle=fabric.createDraggableRectangle(x,y,width,height,this);
    }

    @Override
    public void drag(float x, float y)
    {

    }

    @Override
    public void dragEnd(float x, float y)
    {

    }

    @Override
    public void dragStart(float x, float y)
    {

    }

    @Override
    public void move(float delta)
    {

    }

    @Override
    public void draw()
    {

    }

    @Override
    public int getDeep()
    {
        return 0;
    }
}
