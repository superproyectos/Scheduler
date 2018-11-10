package com.rolandoandrade.cards;

import com.rolandoandrade.Dimensions;
import com.rolandoandrade.HourOfClass;
import com.rolandoandrade.Information;
import com.rolandoandrade.Scheduler;
import com.rolandoandrade.actions.Draggable;
import com.rolandoandrade.actions.Dynamic;
import com.rolandoandrade.actions.Removable;
import com.rolandoandrade.color.Color;
import com.rolandoandrade.fabrics.Fabric;
import com.rolandoandrade.rectangles.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class ClassCard implements Draggable, Dynamic, Removable
{
    private List<ClassCard> copyClassCard;
    private Rectangle rectangle;
    private TextInACard textInACard;
    private Information information;
    private Fabric fabric;
    private int deep = 0;

    public ClassCard(float x, float y, float width, float height, Information information, Fabric fabric)
    {
        this.fabric=fabric;
        rectangle=fabric.createDraggableRectangle(x,y,width,height,this);
        this.information=information;
        textInACard=new TextInACard(rectangle,information.getSubject(),fabric);
        copyClassCard=new ArrayList<ClassCard>();
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
        rectangle.dragStart(x,y);
        remove();
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

    public void putCard(Dimensions dimensions)
    {
        List<HourOfClass> hourOfClasses=information.getHourOfClasses();
        for (HourOfClass h:hourOfClasses)
        {
            Dimensions d=Scheduler.validator.getPositionToPut(h);
            float height = d.getHeight() * h.getTotalHours();
            if(!d.equals(dimensions))
            {

                ClassCard c=new ClassCard(d.getX(),d.getY(),d.getWidth(),d.getHeight(),information,fabric);
                c.resize(new Dimensions(d.getX(),d.getY()-(h.getTotalHours()-1)*d.getHeight(),d.getWidth(),height));
                c.changeColor(rectangle.getColor());
                copyClassCard.add(c);
                Scheduler.validator.addToBoard(c);
            }
            else
            {
                resize(new Dimensions(dimensions.getX(), d.getY()-(h.getTotalHours()-1)*d.getHeight(), dimensions.getWidth(), height));
                copyClassCard.add(this);
            }
        }
        for (ClassCard c:copyClassCard)
        {
            List<ClassCard> a = new ArrayList<ClassCard>();
            for (ClassCard d:copyClassCard)
                if(!d.equals(c))
                    a.add(d);
            c.setBros(copyClassCard);
        }
    }
    public void setBros(List<ClassCard> c)
    {
        copyClassCard=c;
    }
    public Rectangle getRectangle()
    {
        return rectangle;
    }

    public void changeRectangle(Rectangle r)
    {
        rectangle=r;
    }
    @Override
    public void move(float delta)
    {
        rectangle.move(delta);
    }

    public Information getInformation()
    {
        return information;
    }

    @Override
    public void remove()
    {
        for (ClassCard c:copyClassCard)
        {
            if (c!=this)
                Scheduler.validator.removeOfBoard(c);
        }
        copyClassCard.clear();
    }
}
