package com.rolandoandrade.cards;

import com.rolandoandrade.text.FontSize;
import com.rolandoandrade.text.FontSizeToHoursOfClass;
import com.rolandoandrade.actions.Dynamic;
import com.rolandoandrade.text.Text;
import com.rolandoandrade.fabrics.Fabric;
import com.rolandoandrade.rectangles.Rectangle;

public class TextInACard implements Dynamic
{
    private Text text;
    private Rectangle rectangle;

    public TextInACard(Rectangle rectangle, String label, Fabric fabric)
    {
        this.rectangle=rectangle;
        FontSize f=new FontSizeToHoursOfClass(18);
        int fontSize=f.getFontSize(rectangle.getWidth());
        text=fabric.createText(label, fontSize);
    }

    @Override
    public void draw()
    {
        rectangle.draw();
        text.write(rectangle.getX(),rectangle.getY()+rectangle.getHeight(),rectangle.getWidth(),rectangle.getHeight());
    }

    @Override
    public int getDeep()
    {
        return 0;
    }

    @Override
    public void move(float delta)
    {
        rectangle.move(delta);
    }
}
