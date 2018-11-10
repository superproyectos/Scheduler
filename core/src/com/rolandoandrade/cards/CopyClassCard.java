package com.rolandoandrade.cards;

import com.rolandoandrade.Information;
import com.rolandoandrade.fabrics.Fabric;

public class CopyClassCard extends ClassCard
{
    private ClassCard parent;

    public CopyClassCard(float x, float y, float width, float height, Information information, Fabric fabric, ClassCard parent)
    {
        super(x, y, width, height, information, fabric);
        this.parent=parent;
    }

    @Override
    public void dragStart(float x, float y)
    {
        parent.changeRectangle(getRectangle());
        this.remove();
    }
}
