package no.mathias.tdt4240.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;

import no.mathias.tdt4240.game.TDT4240Game;

public class HelicopterController {

    private HelicopterModel model;
    private HelicopterView view;

    public HelicopterController(){
        model = new HelicopterModel(50, 400);
        view = new HelicopterView();
    }

    public void update(float dt){
        if (Gdx.input.isKeyPressed(Input.Keys.UP) && model.getPosition().y < TDT4240Game.HEIGHT - view.getSprite().getHeight())
            model.updatePosition(0, model.getyStep(), 0, false, false);
        else if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && model.getPosition().y > 0)
            model.updatePosition(0, -model.getyStep(), 0, false, false);
        else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && model.getPosition().x < TDT4240Game.WIDTH - view.getSprite().getWidth())
            model.updatePosition(model.getxStep(), 0, 0, true, false);
        else if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && model.getPosition().x > 0)
            model.updatePosition(-model.getxStep(), 0, 0, false, true);

        view.setSprite(model.getCurrentSprite());
        view.setCoordinates(String.format("(x: %.0f, y: %.0f)", model.getPosition().x, model.getPosition().y));
    }

    public Sprite getSprite(){
        return view.getSprite();
    }

    public String getCoordinates(){
        return view.getCoordinates();
    }

    public Vector3 getPosition(){
        return model.getPosition();
    }
}
