package no.mathias.tdt4240.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;
import java.util.List;

import no.mathias.tdt4240.game.TDT4240Game;

public class AutomatedHelicopter extends Helicopter{

    protected int xDirection;
    protected int yDirection;
    public AutomatedHelicopter(int x, int y) {
        super(x, y);
        xDirection = 1;
        yDirection = 1;
    }

    public void update(float dt){

        if (position.x > TDT4240Game.WIDTH - helicopter.getWidth() || position.x < 0){
            xDirection *= -1;
            flipSprites();
        }

        if (position.y > TDT4240Game.HEIGHT - helicopter.getHeight() || position.y < 0)
            yDirection *= -1;

        position.add(xStep * xDirection, yStep * yDirection,0);

        if (textureNumber > 7)
            textureNumber = 0;
        helicopter = sprites.get(textureNumber);
        textureNumber++;

        coordinates = String.format("(x: %.0f, y: %.0f)", position.x, position.y);

    }
}
