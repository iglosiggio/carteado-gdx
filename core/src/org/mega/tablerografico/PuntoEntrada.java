package org.mega.tablerografico;

import org.mega.tablero.SlotDeCampo;
import org.mega.tablero.cartas.Guerrero;
import org.mega.tablero.cartas.Pergamino;
import org.mega.tablero.cartas.Sorpresa;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
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
		Actor guerrero = LaFactory.getCarta(new Guerrero(10, "Consolero", "algo", 4, 6, 0));
		Actor sorpresa = LaFactory.getCarta(Sorpresa.getCartaBase());
		Actor pergamino = LaFactory.getCarta(Pergamino.getCartaBase());
		guerrero.moveBy(0, 0);
		pergamino.moveBy(0, 32);
		sorpresa.moveBy(0, 64);
		Actor slot = LaFactory.createSlot(SlotDeCampo.getSlotBase());
		slot.moveBy(200, 10);
		stage.addActor(sorpresa);
		stage.addActor(pergamino);
		stage.addActor(guerrero);
		stage.addActor(slot);
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
