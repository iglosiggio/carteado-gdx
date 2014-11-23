package org.mega.tablerografico;

import org.mega.tablero.cartas.Guerrero;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class PuntoEntrada extends ApplicationAdapter {
	Stage stage;
	Viewport screen;
	InputProcessor entrada = new GlobalKeysInput();
	
	@Override
	public void create () {
		screen = new FitViewport(1024, 600);
		stage = new Stage();
		Actor carta = CartaFactory.getCarta(new Guerrero(10, "Sucio consolero", "algo", 4, 6, 0));
		carta.addAction(Actions.rotateTo(360, 2));
		carta.moveBy(100, 100);
		stage.addActor(carta);
		Gdx.input.setInputProcessor(new InputMultiplexer(entrada, stage));
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();
	}
	
	@Override
	public void dispose() {
		stage.dispose();
	}
}
