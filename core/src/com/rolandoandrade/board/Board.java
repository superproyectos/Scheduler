package com.rolandoandrade.board;

import com.rolandoandrade.Dimensions;
import com.rolandoandrade.HourOfClass;
import com.rolandoandrade.text.labels.HourRangeLabel;
import com.rolandoandrade.cards.ClassCard;
import com.rolandoandrade.cards.TextInACard;
import com.rolandoandrade.color.Color;
import com.rolandoandrade.fabrics.Fabric;
import com.rolandoandrade.actions.Dynamic;
import com.rolandoandrade.actions.Drawable;
import com.rolandoandrade.actions.Scrollable;
import com.rolandoandrade.rectangles.Rectangle;

import java.util.ArrayList;
import java.util.List;

public abstract class Board implements Drawable, Scrollable
{
    private List<List<Field>> fields;
    private List<Dynamic> cards;

    public Board(int rows, int columns, Fabric fabric)
    {
        fields=new ArrayList<List<Field>>();
        cards=new ArrayList<Dynamic>();
        generateBoard(rows,columns,fabric);
        putHours(rows,fabric);
    }

    private void generateBoard(int rows, int columns, Fabric fabric)
    {
        for(int i=0;i<rows;i++)
        {
            List<Field> f=new ArrayList<Field>();
            for (int j = 0; j < columns; j++)
                f.add(new Field(i,j,columns,fabric));
            fields.add(f);
        }
    }

    private void putHours(int rows, Fabric fabric)
    {
        final Field f=fields.get(0).get(0);
        final Dimensions d=f.getDimensions();
        Rectangle r;
        for(int i=0;i<rows;i++)
        {
            r=fabric.createNormalRectangle(0,d.getHeight()*i,d.getWidth(), d.getHeight());
            r.setColor(Color.SECONDARY_HEADER);
            cards.add(new TextInACard(r,new HourRangeLabel(19-i).getLabel(),fabric));
        }
    }

    public Field fieldWhereIsDropped(float x, float y)
    {
        for (List<Field> f:fields)
            for (Field a:f)
                if(a.contains(x,y))
                    return a;
        return null;
    }

    public Field getAFieldByHour(HourOfClass hourOfClass)
    {
        for (List<Field> fiel:fields)
            for(Field f:fiel)
                if(hourOfClass.isMe(f.getHourOfClass()))
                    return f;
        return null;
    }

    public void removeFromBoard(ClassCard card)
    {
        cards.remove(card);
    }
    @Override
    public void draw()
    {
        for (List<Field> f:fields)
            for (Drawable a:f)
                a.draw();
        int i=0, sort=-1;
        for (Dynamic d:cards)
        {
            d.draw();
            if(d.getDeep()>0)
                sort=i;
            i++;
        }
        if (sort!=-1)
            sort(sort);

    }

    private void sort(int i)
    {
        Dynamic d=cards.get(i);
        cards.remove(i);
        cards.add(d);
    }
    public void scroll(float deltaY)
    {
        for (List<Field> f:fields)
            for (Dynamic a:f)
                a.move(deltaY);
        for (Dynamic d:cards)
            d.move(deltaY);
    }

    public void addCardToBoard(ClassCard card)
    {
        cards.add(card);
    }

    @Override
    public int getDeep()
    {
        return -1;
    }
}
