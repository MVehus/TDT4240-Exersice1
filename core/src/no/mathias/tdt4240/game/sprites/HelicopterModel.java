package no.mathias.tdt4240.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;
import java.util.List;

public class HelicopterModel {

    private final Vector3 position;
    private  int textureNumber;
    private List<Sprite> sprites;
    private  int xStep;
    private int yStep;
    private Boolean orientedRight = true;


    public HelicopterModel(int x, int y){
        position = new Vector3(x, y, 0);
        textureNumber = 0;
        xStep = 4;
        yStep = 2;
        initializeTextures();
    }

    public Vector3 getPosition() {
        return position;
    }

    public int getxStep() { return xStep; }

    public int getyStep() { return yStep; }

    public void updatePosition(int x, int y, int z, boolean right, boolean left){
        position.add(x, y, z);
        if (right && !orientedRight){
            flipSprites();
            orientedRight = true;
        } else if (left && orientedRight){
            flipSprites();
            orientedRight = false;
        }
    }

    public Sprite getCurrentSprite(){
        Sprite currentSprite;
        if (textureNumber > 7)
            textureNumber = 0;
        currentSprite = sprites.get(textureNumber);
        textureNumber++;

        return currentSprite;
    }

    private void initializeTextures(){
        sprites = new ArrayList<>();
        for (int txtNr=1; txtNr<9; txtNr++){
            sprites.add(new Sprite(new Texture(String.format("helicopterFrames/helicopter_%d.png", txtNr))));
        }
    }

    private void flipSprites(){
        for (Sprite sprite : sprites){
            sprite.flip(true, false);
        }
    }

}
