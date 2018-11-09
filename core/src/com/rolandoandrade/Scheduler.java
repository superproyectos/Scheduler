package com.rolandoandrade;

import com.rolandoandrade.board.Board;
import com.rolandoandrade.cards.ClassCard;
import com.rolandoandrade.color.Color;
import com.rolandoandrade.days.Monday;
import com.rolandoandrade.fabrics.Fabric;
import com.rolandoandrade.actions.Drawable;

public class Scheduler implements Drawable
{
    private Board board;
    private DayHeader dayHeader;
    public static Validator validator;
    private Color[] colors={Color.BLUE,Color.CYAN,Color.PURPLE,Color.GREEN,Color.ORANGE,Color.PINK,Color.RED,Color.YELLOW};
    private String[] sub={"Cálculo IV", "Circuitos electrónicos", "Laboratorio de circuitos electrónicos", "Ingeniería del software",
    "Sistemas de operación", "Interacción humano computador", "Robótica", "Ajedrez"};
    public Scheduler(Fabric fabric)
    {
        board=fabric.createABoard(14,7);
        dayHeader=new DayHeader(7,fabric);
        validator=new Validator(board);
        float width=Dimensions.getScreenWidth()/7,height=Dimensions.getScreenWidth()*5/63;
        float x=Dimensions.getScreenWidth()-width,y=Dimensions.getScreenHeight()-2*height;
        ClassCard c;
        Information info;
        for(int i=0;i<colors.length;i++)
        {
            info=new Information(sub[i],"ab","123");
            info.addClass(new HourOfClass(new Monday(),7,9));
            c = new ClassCard(x, y, width, height,info, fabric);
            c.changeColor(colors[i]);
            board.addCardToBoard(c);
            y-=height;
        }

    }

    @Override
    public void draw()
    {
        board.draw();
        dayHeader.draw();
    }

    @Override
    public int getDeep()
    {
        return 0;
    }
}
