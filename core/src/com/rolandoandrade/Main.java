package com.rolandoandrade;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.rolandoandrade.fabrics.Fabric;
import com.rolandoandrade.fabrics.LibGDXFabric;
import com.rolandoandrade.stage.Stage;

public class Main extends ApplicationAdapter
{
	Stage stage;
	Fabric fabric;
	Scheduler scheduler;
	@Override
	public void create ()
	{
		stage=new Stage();
		fabric=new LibGDXFabric();
		scheduler=new Scheduler(fabric);
	}
	@Override
	public void render ()
	{
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		scheduler.draw();
	}
	
	@Override
	public void dispose ()
	{
	}
}
