package org.mega.tablerografico.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.mega.tablerografico.PuntoEntrada;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.fullscreen = true;
		config.width = 1024;
		config.height = 600;
		config.title = "Carteado!";
		new LwjglApplication(new PuntoEntrada(), config);
	}
}
