package org.mega.tablerografico;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;

import com.badlogic.gdx.scenes.scene2d.InputListener;

public class ZIndexChanger extends InputListener {
    Actor actor;
    int zIndex;

    public ZIndexChanger(Actor actor) {
	this.actor = actor;
    }

    @Override
    public void enter(InputEvent event, float x, float y, int pointer,
	    Actor fromActor) {
	if (pointer == -1) {
	    zIndex = actor.getZIndex();
	    actor.toFront();
	}
    }

    @Override
    public void exit(InputEvent event, float x, float y, int pointer,
	    Actor toActor) {
	actor.setZIndex(zIndex);
    }
}
