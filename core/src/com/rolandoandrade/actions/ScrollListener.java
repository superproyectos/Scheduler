package com.rolandoandrade.actions;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;

public class ScrollListener extends DragListener
{
    private Scrollable scrollable;

    private float start;

    public ScrollListener(Scrollable scrollable)
    {
        this.scrollable=scrollable;
    }


    @Override
    public void dragStart(InputEvent event, float x, float y, int pointer)
    {
        start=y;
    }

    @Override
    public void drag(InputEvent event, float x, float y, int pointer)
    {
        scrollable.scroll(y - start);
        start = y;
    }
}
