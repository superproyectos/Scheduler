package com.rolandoandrade.fabrics;

import com.rolandoandrade.board.Board;
import com.rolandoandrade.board.BoardLibGDX;
import com.rolandoandrade.text.Text;
import com.rolandoandrade.text.TextLibGDX;
import com.rolandoandrade.actions.Draggable;
import com.rolandoandrade.rectangles.Rectangle;
import com.rolandoandrade.rectangles.RectangleLibGDX;

public class LibGDXFabric implements Fabric
{
    @Override
    public Board createABoard(int rows, int columns)
    {
        return new BoardLibGDX(rows,columns,this);
    }

    @Override
    public Rectangle createDraggableRectangle(float x, float y, float width, float height, Draggable draggable)
    {
        return new RectangleLibGDX(x,y,width,height,draggable);
    }

    @Override
    public Rectangle createNormalRectangle(float x, float y, float width, float height)
    {
        return new RectangleLibGDX(x,y,width,height,null);
    }

    @Override
    public Text createText(String text, int fontSize)
    {
        return new TextLibGDX(text, fontSize);
    }


}
