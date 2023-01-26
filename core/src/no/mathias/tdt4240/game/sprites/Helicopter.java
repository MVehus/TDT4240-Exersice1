package no.mathias.tdt4240.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;
import java.util.List;

import no.mathias.tdt4240.game.TDT4240Game;

public class Helicopter {
    protected final Vector3 position;
    protected Sprite helicopter;
    protected int textureNumber;
    List<Sprite> sprites;
    protected int xStep;
    protected int yStep;
    protected String coordinates;

    public Helicopter(int x, int y){
        position = new Vector3(x, y, 0);
        textureNumber = 0;
        xStep = 4;
        yStep = 2;
        initializeTextures();
        helicopter = sprites.get(0);
        coordinates = "";
    }

    public Vector3 getPosition() {
        return position;
    }

    public Sprite getSprite(){
        return helicopter;
    }

    public String getCoordinates() {
        return coordinates;
    }

    private void initializeTextures(){
        sprites = new ArrayList<>();
        for (int txtNr=1; txtNr<9; txtNr++){
            sprites.add(new Sprite(new Texture(String.format("helicopterFrames/helicopter_%d.png", txtNr))));
        }
    }

    protected void flipSprites(){
        for (Sprite sprite : sprites){
            sprite.flip(true, false);
        }
    }
}
