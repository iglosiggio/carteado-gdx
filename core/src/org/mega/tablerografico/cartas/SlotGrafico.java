package org.mega.tablerografico.cartas;

import org.mega.tablero.SlotDeCampo;
import org.mega.tablero.cartas.Guerrero;
import org.mega.tablero.cartas.Pergamino;
import org.mega.tablero.cartas.Sorpresa;

public class SlotGrafico extends CartaStack {
    SlotDeCampo slot;
    GuerreroGrafico guerrero;
    PergaminoGrafico pergamino;
    SorpresaGrafico sorpresa;

    /*public SlotGrafico(SlotDeCampo slotDeCampo) {
	slot = slotDeCampo;

	Guerrero tGuerrero = slot.getGuerrero();
	Pergamino tPergamino = slot.getPergamino();
	Sorpresa tSorpresa = slot.getSorpresa();

	guerrero = new GuerreroGrafico(tGuerrero);
	guerrero.setName("guerrero");
	pergamino = new PergaminoGrafico(tPergamino);
	pergamino.setName("pergamino");
	sorpresa = new SorpresaGrafico(tSorpresa);
	sorpresa.setName("sorpresa");

	pergamino.moveBy(0, 32);
	sorpresa.moveBy(0, 64);

	addActor(sorpresa);
	addActor(pergamino);
	addActor(guerrero);

	setSize(145, 210 + 32 + 32);
    }*/
    
    public SlotGrafico(SlotDeCampo slotDeCampo) {
	slot = slotDeCampo;

	Guerrero tGuerrero = slot.getGuerrero();
	Pergamino tPergamino = slot.getPergamino();
	Sorpresa tSorpresa = slot.getSorpresa();

	guerrero = new GuerreroGrafico(tGuerrero);
	guerrero.setName("guerrero");
	pergamino = new PergaminoGrafico(tPergamino);
	pergamino.setName("pergamino");
	sorpresa = new SorpresaGrafico(tSorpresa);
	sorpresa.setName("sorpresa");

	//pergamino.moveBy(0, 32);
	//sorpresa.moveBy(0, 64);

	addCarta(sorpresa);
	addCarta(pergamino);
	addCarta(guerrero);

	setSize(145, 210 + 32 + 32);
    }
}
