package com.iwolt.games.pengpeng.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.boontaran.games.StageGame;
import com.iwolt.games.pengpeng.SPengPeng;

public class Intro extends StageGame {
	public static final int PLAY = 1;
	public static final int HARDCORE = 2;
	public static final int MEGALEVEL = 3;
	
	@Override
	protected void create() {
		//intro bg
		Image bg = new Image(SPengPeng.atlas.findRegion("intro_bg"));
		
		//resize the bg to fill the screen, keep aspect ratio
		fillScreen(bg, true, false);
		addChild(bg);
		
		//game title
		Image title = new Image(SPengPeng.atlas.findRegion("title"));
		centerActorX(title);
		title.setY(getHeight() - title.getHeight() - 60);
		addChild(title);
		
		//play button
		ImageButton playBtn = new ImageButton(
				new TextureRegionDrawable(SPengPeng.atlas.findRegion("play_btn")), 
				new TextureRegionDrawable(SPengPeng.atlas.findRegion("play_btn_down")));
		centerActorX(playBtn);
		playBtn.setY(getHeight() - title.getHeight() - 190);
		addChild(playBtn);

		//playhardcore button
		ImageButton playhardcoreBtn = new ImageButton(
				new TextureRegionDrawable(SPengPeng.atlas.findRegion("playhardcore_btn")),
				new TextureRegionDrawable(SPengPeng.atlas.findRegion("playhardcore_btn_down")));
		centerActorX(playhardcoreBtn);
		playhardcoreBtn.setY(getHeight() - title.getHeight() - 280);
		addChild(playhardcoreBtn);

		//megalvl button
		/*ImageButton megalvlBtn = new ImageButton(
				new TextureRegionDrawable(SPengPeng.atlas.findRegion("megalvl_btn")),
				new TextureRegionDrawable(SPengPeng.atlas.findRegion("megalvl_btn_down")));
		centerActorX(megalvlBtn);
		megalvlBtn.setY(getHeight() - title.getHeight() - 370);
		addChild(megalvlBtn);
		megalvlBtn.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				SPengPeng.media.playSound("click");
				call(MEGALEVEL);
			}
		});*/

		//btn listener
		playBtn.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				SPengPeng.media.playSound("click");
				call(PLAY);
			}
			
		});

		//hardcore listener
		playhardcoreBtn.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				SPengPeng.media.playSound("click");
				call(HARDCORE);
			}

		});
	}
	
	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Keys.ESCAPE || keycode == Keys.BACK){ //if the back key pressed
			Gdx.app.exit();
			return true;
		}
		return super.keyDown(keycode);
	}


	
	
	

}
