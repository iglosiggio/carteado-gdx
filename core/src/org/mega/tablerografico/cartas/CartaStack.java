package org.mega.tablerografico.cartas;

import org.mega.tablerografico.ZIndexChanger;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import com.badlogic.gdx.utils.Array;

public class CartaStack extends WidgetGroup {
    int selectedCard;
    Array<CartaGrafica> cartas = new Array<CartaGrafica>();
    Array<CartaLabel> nombreCartas = new Array<CartaLabel>();
    Group capaCartas = new Group();
    Group capaNombres = new Group();
    
    public CartaStack() {
	capaCartas.setName("cartas");
	capaNombres.setName("nombres");
	addActor(capaCartas);
	addActor(capaNombres);
    }
    
    public void addCarta(CartaGrafica carta) {
	CartaLabel nombreCarta = new CartaLabel(carta);
	ZIndexChanger listener = new ZIndexChanger(carta);
	carta.addListener(new SelectionListener(cartas.size));
	carta.addListener(new ZIndexChanger(carta));
	nombreCarta.addListener(listener);
	cartas.add(carta);
	nombreCartas.add(nombreCarta);
	capaNombres.addActor(nombreCarta);
	capaCartas.addActor(carta);
	invalidateHierarchy();
    }

    @Override
    public void layout() {
	float currY = (cartas.size - 1) * 32;
	for(int i = 0; i < cartas.size; i++) {
	    CartaGrafica carta = cartas.get(i);
	    CartaLabel nombre = nombreCartas.get(i);
	    carta.setY(currY);
	    nombre.setVisible(false);
	    nombre.setY(currY);
	    currY -= 32;
	}
    }
    
    class SelectionListener extends InputListener {
	private int nextActorIndex;

	public SelectionListener(int actorIndex) {
	    this.nextActorIndex = actorIndex + 1;
	}
	
	@Override
	public void enter(InputEvent event, float x, float y, int pointer,
		Actor fromActor) {
	    if(pointer == -1) {
		for(int i = nextActorIndex; i < nombreCartas.size; i++) {
		    nombreCartas.get(i).setVisible(true);
		}
	    }
	}
	
	@Override
	public void exit(InputEvent event, float x, float y, int pointer,
		Actor toActor) {
	    if(pointer == -1) {
		for(int i = nextActorIndex; i < nombreCartas.size; i++) {
		    nombreCartas.get(i).setVisible(false);
		}
	    }
	}
    }
    
    @Override
    public float getPrefWidth() {
        return 145;
    }
    
    @Override
    public float getPrefHeight() {
        return (cartas.size - 1) * 32 + 210;
    }
}
