package no.mathias.tdt4240.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import no.mathias.tdt4240.game.TDT4240Game;
import no.mathias.tdt4240.game.sprites.Helicopter;

public class PlayState extends State{

    private Helicopter helicopter;

    private Texture background;

    public PlayState(GameStateManager gameStateManager) {
        super(gameStateManager);
        helicopter = new Helicopter(50, 400);
        //camera.setToOrtho(false, TDT4240Game.WIDTH / 2, TDT4240Game.HEIGHT / 2);
        background = new Texture("gameBackground.png");
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {
        handleInput();
        helicopter.update(dt);
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        //spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.draw(background, 0,0, TDT4240Game.WIDTH, TDT4240Game.HEIGHT);
        spriteBatch.draw(helicopter.getSprite(), helicopter.getPosition().x, helicopter.getPosition().y);
        spriteBatch.end();
    }

    @Override
    public void dispose() {

    }
}
