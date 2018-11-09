package com.rolandoandrade;

import com.rolandoandrade.cards.TextInACard;
import com.rolandoandrade.color.Color;
import com.rolandoandrade.fabrics.Fabric;
import com.rolandoandrade.actions.Drawable;
import com.rolandoandrade.days.FabricOfDays;
import com.rolandoandrade.rectangles.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class DayHeader implements Drawable
{
    private List<TextInACard> days;
    private final String dragASubjectLabel="¡Arrastra la materia!";
    private final String hourLabel="Hora";

    public DayHeader(int columns, Fabric fabric)
    {
        days=new ArrayList<TextInACard>();
        createHeader(columns,fabric);
    }

    private void createHeader(int columns, Fabric fabric)
    {
        final float width = Dimensions.getScreenWidth() / columns;
        final float height = width * 1/Dimensions.widthDIVheight;
        final float y=Dimensions.getScreenHeight()-height;
        addToHeader(-1,hourLabel,y,width,height,fabric,Color.PRIMARY_HEADER);
        for(int i=0;i<columns-2;i++)
            addToHeader(i,FabricOfDays.createDay(i).getDayName(),y,width,height,fabric, Color.PRIMARY_HEADER);
        addToHeader(columns-2,dragASubjectLabel,y,width,height,fabric,Color.SECONDARY_HEADER);
    }

    private void addToHeader(int i, String labelToShow, float y, float width, float height, Fabric fabric, Color color)
    {
        Rectangle rectangle;
        rectangle=fabric.createNormalRectangle((i+1) * width,y,width,height);
        rectangle.setColor(color);
        days.add(new TextInACard(rectangle, labelToShow,fabric));
    }

    @Override
    public void draw()
    {
        for (Drawable d:days)
            d.draw();
    }

    @Override
    public int getDeep()
    {
        return 1;
    }
}
