package com.iwolt.games.pengpeng.control;

/**
 * Created by DubininK on 04.05.2017.
 */

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

/**
 * Animated scene2d actor. Similar to {@link Image} but uses {@link Animation} instead of a {@link Drawable}.
 * @author Pimentoso
 */
public class AnimatedImage extends Image {

    private float animationTime=0.5f;
    private float animationStart=0f;
    private float whenStart=0f;
    private float delay;

    public AnimatedImage(TextureRegion tr){
        super(tr);
    }

    public AnimatedImage(TextureRegion tr, float delay){
        super(tr);
        this.delay=delay;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(whenStart>=delay){
            if(animationStart<animationTime) {
                this.scaleBy(delta*2);
                animationStart+=delta;
            }
        }else{
            whenStart+=delta;
        }
    }
}