package com.rolandoandrade.actions;

public interface Draggable
{
    void drag(float x, float y);
    void dragEnd(float x, float y);
    void dragStart(float x, float y);
}
