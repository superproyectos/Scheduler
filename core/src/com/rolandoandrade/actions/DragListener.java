package com.rolandoandrade.actions;

import com.badlogic.gdx.scenes.scene2d.InputEvent;

public class DragListener extends com.badlogic.gdx.scenes.scene2d.utils.DragListener
{
    private Draggable draggable;

    public DragListener(Draggable draggable)
    {
        this.draggable=draggable;
    }

    @Override
    public void drag(InputEvent event, float x, float y, int pointer)
    {
        draggable.drag(x, y);
    }

    @Override
    public void dragStop(InputEvent event, float x, float y, int pointer)
    {
        draggable.dragEnd(event.getStageX(),event.getStageY());
    }

    @Override
    public void dragStart(InputEvent event, float x, float y, int pointer)
    {
        draggable.dragStart(x,y);
    }
}
