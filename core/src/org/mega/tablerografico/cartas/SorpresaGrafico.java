package org.mega.tablerografico.cartas;

import org.mega.tablero.cartas.Sorpresa;
import org.mega.tablerografico.LaFactory;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.Align;

public class SorpresaGrafico extends CartaGrafica {
    Image fondo;
    Image icono;
    Label nombre;
    Label nivel;

    public SorpresaGrafico(Sorpresa sorpresa) {

	setSize(145, 210);

	fondo = new Image(LaFactory.sorpresa_tex);
	fondo.setName("fondo");
	fondo.setSize(145, 210);

	addActor(fondo);

	nombre = new Label(sorpresa.getNombre(), LaFactory.skin);
	nombre.setName("nombre");
	nombre.moveBy(3, 210 - 4 - 24);
	nombre.setAlignment(Align.center);
	nombre.setSize(140, 24);

	addActor(nombre);

	icono = new Image(new Texture("cartas/sorpresas/"
		+ sorpresa.getNombre() + ".png"));
	icono.setName("icono");
	icono.moveBy(3, 4);
	icono.setSize(140, 140);

	addActor(icono);

	nivel = new Label(Integer.toString(sorpresa.getNivel()), LaFactory.skin);
	nivel.setName("nivel");
	nivel.moveBy(102, 150);
	nivel.setAlignment(Align.center);
	nivel.setSize(40, 28);

	addActor(nivel);
    }

    @Override
    public Label getNombre() {
	return nombre;
    }

    @Override
    public Image getIcon() {
	return icono;
    }
}
