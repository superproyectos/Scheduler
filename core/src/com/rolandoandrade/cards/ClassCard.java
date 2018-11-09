package com.rolandoandrade.cards;

import com.rolandoandrade.Dimensions;
import com.rolandoandrade.Information;
import com.rolandoandrade.Scheduler;
import com.rolandoandrade.actions.Draggable;
import com.rolandoandrade.actions.Dynamic;
import com.rolandoandrade.color.Color;
import com.rolandoandrade.fabrics.Fabric;
import com.rolandoandrade.rectangles.Rectangle;

public class ClassCard implements Draggable, Dynamic
{
    private Rectangle rectangle;
    private TextInACard textInACard;
    private Information information;
    private int deep = 0;

    public ClassCard(float x, float y, float width, float height, Information information, Fabric fabric)
    {
        rectangle=fabric.createDraggableRectangle(x,y,width,height,this);
        this.information=information;
        textInACard =new TextInACard(rectangle,information.getSubject(),fabric);
    }

    @Override
    public void drag(float x, float y)
    {
        rectangle.drag(x, y);
    }

    @Override
    public void dragEnd(float x, float y)
    {
        deep =0;
        Scheduler.validator.putCard(this, x, y);
    }

    @Override
    public void dragStart(float x, float y)
    {
        deep =1;
        rectangle.dragStart(x, y);
    }

    @Override
    public void draw()
    {
        textInACard.draw();
    }

    @Override
    public int getDeep()
    {
        return deep;
    }

    public void changeColor(Color color)
    {
        rectangle.setColor(color);
    }

    public void resize(Dimensions dimensions)
    {
        rectangle.setDimensions(dimensions);
    }

    @Override
    public void move(float delta)
    {
        rectangle.move(delta);
    }
}
