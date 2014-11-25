package org.mega.tablerografico;

import java.util.Arrays;
import java.util.Collection;

import org.mega.tablero.SlotDeCampo;
import org.mega.tablero.cartas.Guerrero;
import org.mega.tablero.cartas.Pergamino;
import org.mega.tablero.cartas.Sorpresa;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class PuntoEntrada extends ApplicationAdapter {
    Stage stage;
    Viewport screen;
    InputProcessor entrada = new GlobalKeysInput();

    @Override
    public void create() {
	screen = new FitViewport(1024, 600);
	stage = new Stage();
	Collection<SlotDeCampo> campoJ1 = Arrays.asList(SlotDeCampo
		.getSlotBase(), SlotDeCampo.getSlotBase(),
		new SlotDeCampo(new Guerrero(10, "Consolero", "algo", 4, 6, 0),
			Pergamino.getCartaBase(), Sorpresa.getCartaBase()));
	Collection<SlotDeCampo> campoJ2 = Arrays.asList(
		SlotDeCampo.getSlotBase(), SlotDeCampo.getSlotBase(),
		SlotDeCampo.getSlotBase());
	stage.addActor(LaFactory.createCampoDeJuego(campoJ1, campoJ2));
	Gdx.input.setInputProcessor(new InputMultiplexer(entrada, stage));
    }

    @Override
    public void render() {
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
