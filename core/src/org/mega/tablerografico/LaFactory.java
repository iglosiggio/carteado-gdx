package org.mega.tablerografico;

import org.mega.tablero.SlotDeCampo;
import org.mega.tablero.cartas.Guerrero;
import org.mega.tablero.cartas.Pergamino;
import org.mega.tablero.cartas.Sorpresa;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Align;

public class LaFactory {
	static Texture guerrero_tex;
	static Texture pergamino_tex;
	static Texture sorpresa_tex;
	static Skin skin;
	static TextureAtlas textureAtlas;
	static {
		guerrero_tex = new Texture("cartas/guerrero.png");
		pergamino_tex = new Texture("cartas/pergamino.png");
		sorpresa_tex = new Texture("cartas/sorpresa.png");
		textureAtlas = new TextureAtlas("uiskin.atlas.txt");
		skin = new Skin(Gdx.files.internal("uiskin.json"));
		skin.addRegions(textureAtlas);
	}
	
	static public Actor getCarta(Guerrero guerrero) {
		Group carta;
		Image fondo;
		Image icono;
		Label nombre;
		carta = createGroup();
		carta.setSize(145, 210);
		
		fondo = new Image(guerrero_tex);
		fondo.setSize(145, 210);
		
		carta.addActor(fondo);
		
		nombre = new Label(guerrero.getNombre(), skin);
		nombre.moveBy(3, 210 - 4 - 24);
		nombre.setAlignment(Align.center);
		nombre.setSize(140, 24);
		
		carta.addActor(nombre);
		
		icono = new Image(new Texture("cartas/guerreros/" + guerrero.getNombre() + ".png"));
		icono.moveBy(3, 28 + 8);
		icono.setSize(140, 140);
		
		carta.addActor(icono);

		Label vida = new Label(Integer.toString(guerrero.getVida()), skin);
		vida.moveBy(3, 3);
		vida.setAlignment(Align.center);
		vida.setSize(60, 28);
		
		carta.addActor(vida);
		
		Label nivel = new Label(Integer.toString(guerrero.getNivel()), skin);
		nivel.moveBy(3 + 60 + 5, 3);
		nivel.setAlignment(Align.center);
		nivel.setSize(40, 28);
		
		carta.addActor(nivel);
		
		Label ataque = new Label(Integer.toString(guerrero.getAtaque()), skin);
		ataque.moveBy(3 + 60 + 5 + 40 + 5, 3);
		ataque.setAlignment(Align.center);
		ataque.setSize(30, 28);
		
		carta.addActor(ataque);
		
		return carta;
	}
	
	static public Actor getCarta(Sorpresa sorpresa) {
		Group carta;
		Image fondo;
		Image icono;
		Label nombre;
		Label nivel;
		
		carta = createGroup();
		carta.setSize(145, 210);
		
		fondo = new Image(sorpresa_tex);
		fondo.setSize(145, 210);
		
		carta.addActor(fondo);
		
		nombre = new Label(sorpresa.getNombre(), skin);
		nombre.moveBy(3, 210 - 4 - 24);
		nombre.setAlignment(Align.center);
		nombre.setSize(140, 24);
		
		carta.addActor(nombre);
		
		icono = new Image(new Texture("cartas/sorpresas/" + sorpresa.getNombre() + ".png"));
		icono.moveBy(3, 4);
		icono.setSize(140, 140);
		
		carta.addActor(icono);
		
		nivel = new Label(Integer.toString(sorpresa.getNivel()), skin);
		nivel.moveBy(102, 150);
		nivel.setAlignment(Align.center);
		nivel.setSize(40, 28);
		
		carta.addActor(nivel);
		
		return carta;
	}
	
	static public Actor getCarta(Pergamino pergamino) {
		Group carta;
		Image fondo;
		Image icono;
		Label nombre;
		carta = createGroup();
		carta.setSize(145, 210);
		
		fondo = new Image(pergamino_tex);
		fondo.setSize(145, 210);
		
		carta.addActor(fondo);
		
		nombre = new Label(pergamino.getNombre(), skin);
		nombre.moveBy(3, 210 - 4 - 24);
		nombre.setAlignment(Align.center);
		nombre.setSize(140, 24);
		
		carta.addActor(nombre);
		
		icono = new Image(new Texture("cartas/pergaminos/" + pergamino.getNombre() + ".png"));
		icono.moveBy(3, 28 + 8);
		icono.setSize(140, 140);
		
		carta.addActor(icono);
		
		Label nivel = new Label(Integer.toString(pergamino.getNivel()), skin);
		nivel.moveBy(3 + 50, 3);
		nivel.setAlignment(Align.center);
		nivel.setSize(40, 28);
		
		carta.addActor(nivel);
		
		return carta;
	}
	
	static private Group createGroup() {
		final Group grupo = new Group();
		grupo.addListener(new InputListener() {
			int zIndex = grupo.getZIndex();
			@Override
			public void enter(InputEvent event, float x, float y, int pointer,
					Actor fromActor) {
				zIndex = grupo.getZIndex();
				grupo.toFront();
			}
			@Override
			public void exit(InputEvent event, float x, float y, int pointer,
					Actor toActor) {
				grupo.setZIndex(zIndex);
			}
		});
		return grupo;
	}
	
	static public Actor createSlot(SlotDeCampo slot) {
		return createSlot(slot.getGuerrero(), slot.getPergamino(), slot.getSorpresa());
	}
	
	static public Actor createSlot(Guerrero guerrero, Pergamino pergamino, Sorpresa sorpresa) {
		Group slot = new Group();
		Actor g = getCarta(guerrero);
		Actor p = getCarta(pergamino);
		Actor s = getCarta(sorpresa);
		
		p.moveBy(0, 32);
		s.moveBy(0, 64);
		
		slot.addActor(s);
		slot.addActor(p);
		slot.addActor(g);
		
		return slot;
	}
	
	private LaFactory() {}
}
