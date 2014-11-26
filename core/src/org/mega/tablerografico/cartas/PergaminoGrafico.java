package org.mega.tablerografico.cartas;

import org.mega.tablero.cartas.Pergamino;
import org.mega.tablerografico.LaFactory;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.Align;

public class PergaminoGrafico extends CartaGrafica {
    Image fondo;
    Image icono;
    Label nombre;

    public PergaminoGrafico(Pergamino pergamino) {

	setSize(145, 210);

	fondo = new Image(LaFactory.pergamino_tex);
	fondo.setName("fondo");
	fondo.setSize(145, 210);

	addActor(fondo);

	nombre = new Label(pergamino.getNombre(), LaFactory.skin);
	nombre.setName("nombre");
	nombre.moveBy(3, 210 - 4 - 24);
	nombre.setAlignment(Align.center);
	nombre.setSize(140, 24);

	addActor(nombre);

	icono = new Image(new Texture("cartas/pergaminos/"
		+ pergamino.getNombre() + ".png"));
	icono.setName("icono");
	icono.moveBy(3, 28 + 8);
	icono.setSize(140, 140);

	addActor(icono);

	Label nivel = new Label(Integer.toString(pergamino.getNivel()),
		LaFactory.skin);
	nivel.setName("nivel");
	nivel.moveBy(3 + 50, 3);
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
