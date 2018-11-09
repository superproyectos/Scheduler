package com.rolandoandrade.board;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.rolandoandrade.Dimensions;
import com.rolandoandrade.stage.Stage;
import com.rolandoandrade.fabrics.Fabric;
import com.rolandoandrade.actions.ScrollListener;

public class BoardLibGDX extends Board
{
    private Actor board;

    public BoardLibGDX(int rows, int columns, Fabric fabric)
    {
        super(rows, columns, fabric);
        board=new Actor();
        final float heightOfEachField=Dimensions.getScreenWidth()/(columns*Dimensions.widthDIVheight);
        board.setBounds(0,0,Dimensions.getScreenWidth(),rows*heightOfEachField);
        board.setY(Dimensions.getScreenHeight()-board.getHeight());
        super.scroll(Dimensions.getScreenHeight()-board.getHeight());
        board.addListener(new ScrollListener(this));
        Stage.addToStage(board);
    }

    @Override
    public void scroll(float deltaY)
    {
        board.moveBy(0, deltaY);
        if (board.getY() > 0)
            scrollDown(deltaY);
        else if (Dimensions.getScreenHeight() - (board.getY() + board.getHeight()) > 0)
            scrollUp(deltaY);
        else
            super.scroll(deltaY);
    }

    private void scrollDown(float deltaY)
    {
        super.scroll(deltaY-board.getY());
        board.setY(0);
    }

    private void scrollUp(float deltaY)
    {
        float yMax=Dimensions.getScreenHeight()-board.getHeight();
        float yT=yMax-board.getY();
        super.scroll(deltaY+yT);
        board.setY(yMax);
    }
}
