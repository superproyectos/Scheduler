package com.rolandoandrade.rectangles;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.rolandoandrade.Dimensions;
import com.rolandoandrade.actions.DragListener;
import com.rolandoandrade.actions.Draggable;
import com.rolandoandrade.stage.Stage;

public class RectangleLibGDX extends Rectangle
{
    private ShapeRenderer renderer;
    private Actor rectangle;
    private float height;

    public RectangleLibGDX(float x, float y, float width, float height, Draggable context)
    {
        super(x, y, width, height);
        this.height=height;
        setUp(context);
    }

    private void setUp(Draggable context)
    {
        renderer=new ShapeRenderer();
        if(context!=null)
        {
            rectangle = new Actor();
            rectangle.setBounds(getX(), getY(), getWidth(), getHeight());
            rectangle.addListener(new DragListener(context));
            Stage.addToStage(rectangle);
        }
    }
    @Override
    public void paintRectangleWithColor()
    {
        renderer.setColor(getColor().r,getColor().g,getColor().b,getColor().a);
    }

    private void validationsOfPosition()
    {
        if(rectangle.getX()<getWidth())
            rectangle.setX(getWidth());
        else if (rectangle.getX()>Dimensions.getScreenWidth()-getWidth())
            rectangle.setX(Dimensions.getScreenWidth()-getWidth());
        if(rectangle.getY()>Dimensions.getScreenHeight()-2*height)
            rectangle.setY(Dimensions.getScreenHeight()-2*height);
    }

    @Override
    public void drag(float x, float y)
    {
        rectangle.moveBy(x - getWidth() / 2, y - getHeight() / 2);
        validationsOfPosition();
        setPosition(rectangle.getX(), rectangle.getY());
    }
    @Override
    public void dragEnd(float x, float y)
    {

    }

    @Override
    public void dragStart(float x, float y)
    {
        Stage.putActorBack(rectangle);
        Stage.addToStage(rectangle);
        setHeight(height);
    }

    @Override
    public void draw()
    {
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.rect(getX(),getY(),getWidth(),getHeight());
        renderer.end();
    }

    @Override
    public void move(float delta)
    {
        super.move(delta);
        if(rectangle!=null)
            rectangle.setPosition(getX(),getY());
    }

    @Override
    public void setDimensions(Dimensions dimensions)
    {
        super.setDimensions(dimensions);
        rectangle.setBounds(getX(),getY(),getWidth(),getHeight());
        validationsOfPosition();
        setPosition(rectangle.getX(),rectangle.getY());
    }

    @Override
    public void remove()
    {
        Stage.removeActor(rectangle);
    }

}
