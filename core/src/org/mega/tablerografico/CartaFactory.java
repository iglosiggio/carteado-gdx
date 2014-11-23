package org.mega.tablerografico;

import org.mega.tablero.cartas.Guerrero;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Align;

public class CartaFactory {
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
		carta = new Group();
		
		fondo = new Image(guerrero_tex);
		
		carta.addActor(fondo);
		
		nombre = new Label(guerrero.getNombre(), skin);
		nombre.moveBy(3, 210 - 4 - 24);
		nombre.setAlignment(Align.center);
		nombre.setSize(140, 24);
		
		carta.addActor(nombre);
		
		icono = new Image(new Texture("guerreros/" + guerrero.getNombre() + ".png"));
		icono.moveBy(3, 28 + 5);
		icono.sizeBy(140, 140);
		
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
	private CartaFactory() {}
}
