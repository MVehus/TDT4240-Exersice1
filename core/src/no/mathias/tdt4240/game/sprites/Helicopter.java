package no.mathias.tdt4240.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import no.mathias.tdt4240.game.TDT4240Game;

public class Helicopter {
    private Vector3 position;
    //private Vector3 velocity;
    private Sprite helicopter;
    private int textureNumber;
    List<Sprite> sprites;
    private int direction;

    public Helicopter(int x, int y){
        position = new Vector3(x, y, 0);
        //velocity = new Vector3(0, 0,0);
        textureNumber = 0;
        direction = 1;
        initializeTextures();
        helicopter = sprites.get(0);
    }

    public void update(float dt){

        if (position.x > TDT4240Game.WIDTH - helicopter.getWidth() || position.x < 0){
            direction *= -1;
            flipSprites();
        }

        position.add(2 * direction, 0,0);

        if (textureNumber > 7)
            textureNumber = 0;
        helicopter = sprites.get(textureNumber);
        textureNumber++;
    }

    public Vector3 getPosition() {
        return position;
    }

    public Sprite getSprite(){
        return helicopter;
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
