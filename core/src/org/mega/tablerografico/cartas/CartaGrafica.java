package org.mega.tablerografico.cartas;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public abstract class CartaGrafica extends Group {
    abstract public Label getNombre();
    abstract public Image getIcon();
}
