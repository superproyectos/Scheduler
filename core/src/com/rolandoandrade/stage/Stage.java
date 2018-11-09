package com.rolandoandrade.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.rolandoandrade.Dimensions;

public class Stage
{
    private static com.badlogic.gdx.scenes.scene2d.Stage stage;

    public Stage()
    {
        stage=new com.badlogic.gdx.scenes.scene2d.Stage();
        Dimensions.setScreenWidth(Gdx.graphics.getWidth());
        Dimensions.setScreenHeight(Gdx.graphics.getHeight());
        Gdx.input.setInputProcessor(stage);
    }

    public static void addToStage(Actor actor)
    {
        if(stage!=null)
            stage.addActor(actor);
    }

    public static void putActorBack(Actor actor)
    {
        if (stage!=null)
        {
            stage.getActors().removeValue(actor,false);
            stage.getActors().add(actor);
        }
    }
}
