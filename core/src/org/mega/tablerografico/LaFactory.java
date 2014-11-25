package org.mega.tablerografico;

import java.util.Collection;

import org.mega.tablero.SlotDeCampo;
import org.mega.tablero.cartas.Guerrero;
import org.mega.tablero.cartas.Pergamino;
import org.mega.tablero.cartas.Sorpresa;
import org.mega.tablerografico.cartas.GuerreroGrafico;
import org.mega.tablerografico.cartas.PergaminoGrafico;
import org.mega.tablerografico.cartas.SlotGrafico;
import org.mega.tablerografico.cartas.SorpresaGrafico;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;

public class LaFactory {
    public static Texture guerrero_tex;
    public static Texture pergamino_tex;
    public static Texture sorpresa_tex;
    public static Skin skin;
    public static TextureAtlas textureAtlas;
    static {
	guerrero_tex = new Texture("cartas/guerrero.png");
	pergamino_tex = new Texture("cartas/pergamino.png");
	sorpresa_tex = new Texture("cartas/sorpresa.png");
	textureAtlas = new TextureAtlas("uiskin.atlas.txt");
	skin = new Skin(Gdx.files.internal("uiskin.json"));
	skin.addRegions(textureAtlas);
    }

    static public Group getCarta(Guerrero guerrero) {
	return new GuerreroGrafico(guerrero);
    }

    static public Group getCarta(Sorpresa sorpresa) {
	return new SorpresaGrafico(sorpresa);
    }

    static public Group getCarta(Pergamino pergamino) {
	return new PergaminoGrafico(pergamino);
    }

    static public Group createSlot(SlotDeCampo slot) {
	return new SlotGrafico(slot);
    }

    static public HorizontalGroup createCampo(Collection<SlotDeCampo> slots) {
	HorizontalGroup campo = new HorizontalGroup();
	for (SlotDeCampo slot : slots) {
	    campo.addActor(new SlotGrafico(slot));
	}
	return campo;
    }

    static public VerticalGroup createCampoDeJuego(
	    Collection<SlotDeCampo> slotsJ1, Collection<SlotDeCampo> slotsJ2) {
	VerticalGroup campo = new VerticalGroup();
	Actor campoJ1 = createCampo(slotsJ1);
	Actor campoJ2 = createCampo(slotsJ2);
	campo.addActor(campoJ2);
	campo.addActor(campoJ1);
	campo.setFillParent(true);
	campo.space(600 - (210 + 32 + 32) * 2 - 10).pad(5);
	return campo;
    }

    private LaFactory() {
    }
}
