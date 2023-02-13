package no.mathias.tdt4240.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import no.mathias.tdt4240.game.TDT4240Game;

public class MenuState extends State{

    private Texture background;
    private Texture playButton;
    public MenuState(GameStateManager gameStateManager) {
        super(gameStateManager);
        background = new Texture("gameBackground.png");
        playButton = new Texture("startButton.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            gameStateManager.set(PlayState.getInstance(gameStateManager));
            dispose();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0, TDT4240Game.WIDTH, TDT4240Game.HEIGHT);
        spriteBatch.draw(playButton, (TDT4240Game.WIDTH / 2) - (playButton.getWidth() / 2), TDT4240Game.HEIGHT / 2);
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playButton.dispose();
    }
}
