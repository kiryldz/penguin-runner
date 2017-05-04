package com.iwolt.games.pengpeng;

import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.boontaran.MessageEvent;

public class LevelFailedDialog extends Group {
	public static final int ON_CLOSE = 1;

	public LevelFailedDialog() {
		
		//create bg
		NinePatch patch = new NinePatch(SPengPeng.atlas.findRegion("dialog_bg"),60,60,60,60);
		Image bg = new Image(patch);
		bg.setSize(600, 500);
		setSize(bg.getWidth() , bg.getHeight());
		addActor(bg);
		
		//text title
		Image title = new Image(SPengPeng.atlas.findRegion("level_failed"));
		addActor(title);
		title.setX((getWidth() - title.getWidth())/2);
		title.setY(getHeight() - title.getHeight() - 100);
		
		//button retry
		ImageButton okBtn = new ImageButton(
				new TextureRegionDrawable(SPengPeng.atlas.findRegion("retry_btn")),
				new TextureRegionDrawable(SPengPeng.atlas.findRegion("retry_btn_down")));
		
		addActor(okBtn);
		okBtn.setX(getWidth()/2- okBtn.getWidth() - 15);
		okBtn.setY(60);

		//fire event when the button clicked
		okBtn.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				fire(new MessageEvent(ON_CLOSE));
			}
		});

		//button menu
		ImageButton menuButton = new ImageButton(
				new TextureRegionDrawable(SPengPeng.atlas.findRegion("menu_btn")),
				new TextureRegionDrawable(SPengPeng.atlas.findRegion("menu_btn_down")));

		addActor(menuButton);
		menuButton.setX(getWidth()/2+15);
		menuButton.setY(60);

		//fire event when the button clicked
		menuButton.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				fire(new MessageEvent(ON_CLOSE));
			}
		});
		
	}

}
