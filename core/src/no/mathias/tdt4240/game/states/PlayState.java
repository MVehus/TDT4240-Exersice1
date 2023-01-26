package no.mathias.tdt4240.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import no.mathias.tdt4240.game.TDT4240Game;
import no.mathias.tdt4240.game.sprites.AutomatedHelicopter;
import no.mathias.tdt4240.game.sprites.ControlledHelicopter;

public class PlayState extends State{

    private AutomatedHelicopter automatedHelicopter;
    private ControlledHelicopter controlledHelicopter;
    private Texture background;
    private BitmapFont font;

    public PlayState(GameStateManager gameStateManager) {
        super(gameStateManager);
        automatedHelicopter = new AutomatedHelicopter(50, 400);
        controlledHelicopter = new ControlledHelicopter(50, 400);
        //camera.setToOrtho(false, TDT4240Game.WIDTH / 2, TDT4240Game.HEIGHT / 2);
        background = new Texture("gameBackground.png");
        font = new BitmapFont();
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {
        handleInput();
        controlledHelicopter.update(dt);
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        //spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.draw(background, 0,0, TDT4240Game.WIDTH, TDT4240Game.HEIGHT);
        //spriteBatch.draw(automatedHelicopter.getSprite(), automatedHelicopter.getPosition().x, automatedHelicopter.getPosition().y);
        spriteBatch.draw(controlledHelicopter.getSprite(), controlledHelicopter.getPosition().x, controlledHelicopter.getPosition().y);
        font.draw(spriteBatch, controlledHelicopter.getCoordinates(), 0, TDT4240Game.HEIGHT);
        spriteBatch.end();
    }

    @Override
    public void dispose() {

    }
}
