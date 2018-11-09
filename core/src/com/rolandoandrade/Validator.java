package com.rolandoandrade;

import com.rolandoandrade.board.Board;
import com.rolandoandrade.board.Field;
import com.rolandoandrade.cards.ClassCard;

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
            card.resize(field.getDimensions());
    }
}
