package no.mathias.tdt4240.game.states;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import no.mathias.tdt4240.game.TDT4240Game;
import no.mathias.tdt4240.game.sprites.HelicopterController;

public class PlayState extends State{

    private static volatile PlayState instance = null;
    private HelicopterController controller;
    private Texture background;
    private BitmapFont font;

    private PlayState(GameStateManager gameStateManager) {
        super(gameStateManager);
        controller = new HelicopterController();
        background = new Texture("gameBackground.png");
        font = new BitmapFont();
    }

    public static PlayState getInstance(GameStateManager gameStateManager) {
        if (instance == null)
            instance = new PlayState(gameStateManager);
        return instance;
    }

    @Override
    public void handleInput() {
    }

    @Override
    public void update(float dt) {
        handleInput();
        controller.update(dt);
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();
        spriteBatch.draw(background, 0,0, TDT4240Game.WIDTH, TDT4240Game.HEIGHT);
        spriteBatch.draw(controller.getSprite(), controller.getPosition().x, controller.getPosition().y);
        font.draw(spriteBatch, controller.getCoordinates(), 0, TDT4240Game.HEIGHT);
        spriteBatch.end();
    }

    @Override
    public void dispose() {

    }
}
