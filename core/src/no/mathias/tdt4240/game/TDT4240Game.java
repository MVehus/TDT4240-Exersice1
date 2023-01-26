package no.mathias.tdt4240.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import no.mathias.tdt4240.game.states.GameStateManager;
import no.mathias.tdt4240.game.states.MenuState;

public class TDT4240Game extends ApplicationAdapter {
	public static final int WIDTH = 750;
	public static final int HEIGHT = 900;
	public static final String TITLE = "Helicopter";

	private GameStateManager gameStateManager;
	private SpriteBatch spriteBatch;

	@Override
	public void create () {
		spriteBatch = new SpriteBatch();
		gameStateManager = new GameStateManager();
		gameStateManager.push(new MenuState(gameStateManager));
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		gameStateManager.update(Gdx.graphics.getDeltaTime());
		gameStateManager.render(spriteBatch);
	}
	
	@Override
	public void dispose () {
		spriteBatch.dispose();
	}
}
