package com.rolandoandrade.color;

public class Color
{
     public static final Color BLUE=new Color(40, 116, 166 ,1);
     public static final Color PURPLE= new Color(118, 68, 138,1);
     public static final Color RED= new Color(203, 67, 53,1);
     public static final Color GREEN=new Color(46, 204, 113,1);
     public static final Color YELLOW= new Color(244, 208, 63,1);
     public static final Color DEEP_PURPLE= new Color(165, 105, 189,1);
     public static final Color ORANGE= new Color(214, 137, 16,1);
     public static final Color GRAY=new Color(149, 165, 166,1);
     public static final Color PINK= new Color(187, 143, 206,1);
     public static final Color CYAN= new Color(133, 193, 233,1);
     public static final Color GRAY_BLUE=new Color(40, 55, 71,1);
     public static final Color WHITE= new Color(229, 231, 233,1);
     public static final Color PRIMARY_HEADER = new Color(25, 118, 210,1);
     public static final Color SECONDARY_HEADER = new Color(33, 150, 243,1);
     public static final Color ACCENT_HEADER = new Color(3, 249, 244,1);
     public float r,g,b,a;

     public Color(int r, int g, int b, float a)
     {
         this.r=r/255f;
         this.g=g/255f;
         this.b=b/255f;
         this.a=a;
     }
    public Color(float r, float g, float b, float a)
    {
        this.r=r/255f;
        this.g=g/255f;
        this.b=b/255f;
        this.a=a;
    }

    public static Color changeAlpha(Color color, float alpha)
    {
        return new Color(color.r*255,color.g*255,color.b*255,alpha);
    }

}
