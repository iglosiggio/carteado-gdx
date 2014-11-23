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
		sorpresa_tex = new Texture("cartas/trampa.png");
		textureAtlas = new TextureAtlas("uiskin.atlas.txt");
		skin = new Skin(Gdx.files.internal("uiskin.json"));
		skin.addRegions(textureAtlas);
	}
	
	static public Actor getCarta(Guerrero guerrero) {
		Group carta = new Group();
		Image fondo = new Image(guerrero_tex);
		Label texto = new Label(guerrero.getNombre(), skin);
		texto.setAlignment(Align.center);
		texto.moveBy(3, 210 - 4 - 24);
		texto.setSize(140, 24);
		carta.addActor(fondo);
		carta.addActor(texto);

		Label vida = new Label(Integer.toString(guerrero.getVida()), skin);
		vida.moveBy(3, 3);
		Label nivel = new Label(Integer.toString(guerrero.getNivel()), skin);
		nivel.moveBy(3 + 40 + 10, 3);
		Label ataque = new Label(Integer.toString(guerrero.getAtaque()), skin);
		ataque.moveBy(3 + 40 + 10 + 40 + 10, 3);
		
		carta.addActor(vida);
		carta.addActor(nivel);
		carta.addActor(ataque);
		
		return carta;
	} 
	private CartaFactory() {}
}
