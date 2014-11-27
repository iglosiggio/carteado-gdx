package org.mega.tablerografico.desktop;

import com.badlogic.gdx.Graphics.DisplayMode;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import org.mega.tablerografico.PuntoEntrada;

public class DesktopLauncher {
    public static void main(String[] arg) {
	DisplayMode display = LwjglApplicationConfiguration.getDesktopDisplayMode();;
	LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
	config.fullscreen = true;
	config.width = display.width;
	config.height = display.height;
	config.title = "Carteado!";
	new LwjglApplication(new PuntoEntrada(), config);
    }
}
