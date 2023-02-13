package no.mathias.tdt4240.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class HelicopterView {

    private Sprite helicopter;

    private String coordinates;

    public HelicopterView(){
        helicopter = new Sprite(new Texture("helicopterFrames/helicopter_1.png"));
        coordinates = "";
    }

    public Sprite getSprite(){
        return helicopter;
    }

    public void setSprite(Sprite sprite){
        helicopter = sprite;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }


}
