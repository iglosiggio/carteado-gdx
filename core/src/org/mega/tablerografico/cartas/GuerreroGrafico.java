package org.mega.tablerografico.cartas;

import org.mega.tablero.Juego;
import org.mega.tablero.cartas.Guerrero;
import org.mega.tablero.eventos.ProperNotificationFilter;
import org.mega.tablero.eventos.PropiedadChanged;
import org.mega.tablero.eventos.PropiedadesAceptadas;
import org.mega.tablerografico.LaFactory;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.Align;

import net.engio.mbassy.listener.Handler;
import net.engio.mbassy.listener.Filter;

public class GuerreroGrafico extends CartaGrafica {
    Image fondo;
    Image icono;
    Label nombre;
    Label vida;
    Label nivel;
    Label ataque;
    Label dañoRecibido;

    public GuerreroGrafico(Guerrero guerrero) {

	setSize(145, 210);

	fondo = new Image(LaFactory.guerrero_tex);
	fondo.setName("fondo");
	fondo.setSize(145, 210);

	addActor(fondo);

	nombre = new Label(guerrero.getNombre(), LaFactory.skin);
	nombre.setName("nombre");
	nombre.moveBy(3, 210 - 4 - 24);
	nombre.setAlignment(Align.center);
	nombre.setSize(140, 24);

	addActor(nombre);

	icono = new Image(new Texture("cartas/guerreros/"
		+ guerrero.getNombre() + ".png"));
	icono.setName("icono");
	icono.moveBy(3, 28 + 8);
	icono.setSize(140, 140);

	addActor(icono);

	vida = new Label(Integer.toString(guerrero.getVida()), LaFactory.skin);
	vida.setName("vida");
	vida.moveBy(3, 3);
	vida.setAlignment(Align.center);
	vida.setSize(60, 28);

	addActor(vida);

	nivel = new Label(Integer.toString(guerrero.getNivel()), LaFactory.skin);
	nivel.setName("nivel");
	nivel.moveBy(3 + 60 + 5, 3);
	nivel.setAlignment(Align.center);
	nivel.setSize(40, 28);

	addActor(nivel);

	ataque = new Label(Integer.toString(guerrero.getAtaque()),
		LaFactory.skin);
	ataque.setName("ataque");
	ataque.moveBy(3 + 60 + 5 + 40 + 5, 3);
	ataque.setAlignment(Align.center);
	ataque.setSize(30, 28);

	addActor(ataque);
	
	Juego.getEventBus().subscribe(this);
    }
    
    @Override
    public Label getNombre() {
	return nombre;
    }
    
    @Override
    public Image getIcon() {
	return icono;
    }
    
    @PropiedadesAceptadas(propiedades = "vida", desde = Guerrero.class, dato = Integer.class)
    @Handler(filters = @Filter(ProperNotificationFilter.class))
    void vidaChanged(PropiedadChanged<Integer, Guerrero> evento) {
	
    }
}
