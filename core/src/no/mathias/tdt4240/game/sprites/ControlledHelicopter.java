package no.mathias.tdt4240.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import no.mathias.tdt4240.game.TDT4240Game;

public class ControlledHelicopter extends Helicopter{

    Boolean orientedRight = true;

    public ControlledHelicopter(int x, int y, int speedX, int ySpeed) {
        super(x, y, speedX, ySpeed);
    }


    public void update(float dt){
        if (Gdx.input.isKeyPressed(Input.Keys.UP) && position.y < TDT4240Game.HEIGHT - helicopter.getHeight())
            position.add(0, yStep, 0);
        else if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && position.y > 0)
            position.add(0, -yStep, 0);
        else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && position.x < TDT4240Game.WIDTH - helicopter.getWidth()) {
            if (!orientedRight)
                flipSprites();
            position.add(xStep, 0, 0);
            orientedRight = true;
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && position.x > 0) {
            if (orientedRight)
                flipSprites();
            position.add(-xStep, 0, 0);
            orientedRight = false;
        }
        if (textureNumber > 7)
            textureNumber = 0;
        helicopter = sprites.get(textureNumber);
        textureNumber++;

        coordinates = String.format("(x: %.0f, y: %.0f)", position.x, position.y);
    }
}
