package com.rolandoandrade.fabrics;

import com.rolandoandrade.board.Board;
import com.rolandoandrade.text.Text;
import com.rolandoandrade.actions.Draggable;
import com.rolandoandrade.rectangles.Rectangle;

public interface Fabric
{
    Board createABoard(int rows, int columns);
    Rectangle createDraggableRectangle(float x, float y, float width, float height, Draggable draggable);
    Rectangle createNormalRectangle(float x, float y, float width, float height);
    Text createText(String text, int fontSize);
}
