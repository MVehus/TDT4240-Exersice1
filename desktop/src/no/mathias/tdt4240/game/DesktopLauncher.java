package no.mathias.tdt4240.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import no.mathias.tdt4240.game.TDT4240Game;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle(TDT4240Game.TITLE);
		config.setWindowedMode(TDT4240Game.WIDTH, TDT4240Game.HEIGHT);
		new Lwjgl3Application(new TDT4240Game(), config);
	}
}
