package no.mathias.tdt4240.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;
import java.util.List;

import no.mathias.tdt4240.game.TDT4240Game;
import no.mathias.tdt4240.game.sprites.AutomatedHelicopter;

public class PlayState extends State{

    //private AutomatedHelicopter automatedHelicopter;
    //private ControlledHelicopter controlledHelicopter;
    //private BitmapFont font;
    private AutomatedHelicopter heli1;
    private AutomatedHelicopter heli2;
    private AutomatedHelicopter heli3;
    private List<AutomatedHelicopter> helicopters;
    private Texture background;


    public PlayState(GameStateManager gameStateManager) {
        super(gameStateManager);
        heli1 = new AutomatedHelicopter(30, 200, 3, 1, true, true);
        heli2 = new AutomatedHelicopter(300, 30, 2, 3, false, true);
        heli3 = new AutomatedHelicopter(400, 600, 1, 1, false, false);
        helicopters = new ArrayList<>();
        helicopters.add(heli1);
        helicopters.add(heli2);
        helicopters.add(heli3);
        background = new Texture("gameBackground.png");
        //automatedHelicopter = new AutomatedHelicopter(50, 400, true, true);
        //controlledHelicopter = new ControlledHelicopter(50, 400);
        //camera.setToOrtho(false, TDT4240Game.WIDTH / 2, TDT4240Game.HEIGHT / 2);
        //font = new BitmapFont();
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {
        handleInput();
        for (AutomatedHelicopter helicopter : helicopters){
            helicopter.update(dt);
        }
        detectCollision();
        //controlledHelicopter.update(dt);
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        //spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.draw(background, 0,0, TDT4240Game.WIDTH, TDT4240Game.HEIGHT);
        for (AutomatedHelicopter helicopter : helicopters){
            spriteBatch.draw(helicopter.getSprite(), helicopter.getPosition().x, helicopter.getPosition().y);
        }
        //spriteBatch.draw(automatedHelicopter.getSprite(), automatedHelicopter.getPosition().x, automatedHelicopter.getPosition().y);
        //spriteBatch.draw(controlledHelicopter.getSprite(), controlledHelicopter.getPosition().x, controlledHelicopter.getPosition().y);
        //font.draw(spriteBatch, controlledHelicopter.getCoordinates(), 0, TDT4240Game.HEIGHT);
        spriteBatch.end();
    }

    @Override
    public void dispose() {

    }

    private void detectCollision(){
        for (int i = 0; i < helicopters.size(); i++){
            for (int j = i + 1; j < helicopters.size(); j++){
                Vector3 pos1 = helicopters.get(i).getPosition();
                Vector3 pos2 = helicopters.get(j).getPosition();

                float offset = helicopters.get(i).getSprite().getWidth() / 2;

                if (Math.abs(pos1.x - pos2.x) < offset && Math.abs(pos1.y - pos2.y) < offset) {
                    helicopters.get(i).Bounce();
                    helicopters.get(j).Bounce();
                }
            }
        }
    }
}
