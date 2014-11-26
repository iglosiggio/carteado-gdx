package org.mega.tablerografico.cartas;

import org.mega.tablerografico.LaFactory;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.Align;

public class CartaLabel extends Group {
    Label nombre;
    Image fondo;
    
    public CartaLabel(CartaGrafica carta) {
	Label nombre = new Label(carta.getNombre().getText(), LaFactory.skin);
	nombre.setAlignment(Align.center);
	nombre.setName("nombre");
	nombre.setSize(145, 32);
	addActor(nombre);
	setSize(145, 32);
    }

}
