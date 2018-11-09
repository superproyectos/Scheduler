package com.rolandoandrade.text;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class TextLibGDX implements Text
{
    private SpriteBatch batch;
    private BitmapFont font;
    private String text;
    private GlyphLayout glyphLayout;
    private int fontSize;

    public TextLibGDX(String text, int fontSize)
    {
        this.text = text;
        this.fontSize=fontSize;
        batch = new SpriteBatch();
        setupFonts();
    }
    private void setupFonts()
    {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/OpenSansCondensed-Light.ttf"));
        font = createFont(generator, fontSize);
        generator.dispose();
    }
    private BitmapFont createFont(FreeTypeFontGenerator generator, float dp)
    {
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = (int)(dp);
        return generator.generateFont(parameter);
    }

    private void setupLayout(float width, float height)
    {
        if(glyphLayout==null)
            glyphLayout=new GlyphLayout(font,text,Color.GREEN,width,1,true);
        while (glyphLayout.height>height)
        {
            fontSize--;
            setupFonts();
            glyphLayout=new GlyphLayout(font,text,Color.GREEN,width,1,true);
        }
    }
    @Override
    public void write(float x, float y, float width, float height)
    {
        batch.begin();
        setupLayout(width,height);
        font.draw(batch,text,x,y-(height-glyphLayout.height)/2,width,1,true);
        batch.end();
    }
}
