package com.rolandoandrade;

import com.rolandoandrade.board.Board;
import com.rolandoandrade.board.Field;
import com.rolandoandrade.cards.ClassCard;

import java.util.List;

public class Validator
{
    private Board board;

    public Validator(Board board)
    {
        this.board=board;
    }

    public void putCard(ClassCard card, float x, float y)
    {
        Field field = board.fieldWhereIsDropped(x,y);
        if(field!=null)
        {
            Dimensions d=field.getDimensions();
            if(card.getInformation().isAtMyHour(field.getHourOfClass()))
                card.putCard(field.getDimensions());
            else
                card.resize(d);
        }
    }

    public Dimensions getPositionToPut(HourOfClass hourOfClasses)
    {
        Field f=board.getAFieldByHour(hourOfClasses);
        return f.getDimensions();
    }

    public void addToBoard(ClassCard c)
    {
        board.addCardToBoard(c);
    }

    public void removeOfBoard(ClassCard c)
    {
        board.removeFromBoard(c);
    }
}
