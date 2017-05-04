package com.iwolt.games.pengpeng;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.boontaran.MessageEvent;
import com.iwolt.games.pengpeng.control.AnimatedImage;

public class LevelCompletedDialog extends Group {
	public static final int ON_CLOSE = 1;
	public static final int ON_NEXT = 2;
	public static final int ON_RETRY = 3;
	
	public LevelCompletedDialog(int score, int stars) {
		//create bg
		NinePatch patch = new NinePatch(SPengPeng.atlas.findRegion("dialog_bg"),60,60,60,60);
		Image bg = new Image(patch);
		bg.setSize(600, 500);
		setSize(bg.getWidth() , bg.getHeight());
		addActor(bg);
		
		//the text 
		Image title = new Image(SPengPeng.atlas.findRegion("level_completed"));
		addActor(title);
		title.setX((getWidth() - title.getWidth())/2);
		title.setY(getHeight() - title.getHeight() - 100);




		//the text
		Image star2 = new Image(SPengPeng.atlas.findRegion("star_g"));
		addActor(star2);
		star2.setHeight(star2.getHeight()*2);
		star2.setWidth(star2.getWidth()*2);
		star2.setX(getWidth()/2 - star2.getWidth()/2);
		star2.setY(title.getY() - 60);
		//the text
		Image star1 = new Image(SPengPeng.atlas.findRegion("star_g"));
		addActor(star1);
		star1.setHeight(star1.getHeight()*2);
		star1.setWidth(star1.getWidth()*2);
		star1.setX(star2.getX() - star1.getWidth()-10);
		star1.setY(title.getY() - 60);
		//the text
		Image star3 = new Image(SPengPeng.atlas.findRegion("star_g"));
		addActor(star3);
		star3.setHeight(star3.getHeight()*2);
		star3.setWidth(star3.getWidth()*2);
		star3.setX(star2.getX()+star2.getWidth()+10);
		star3.setY(title.getY() - 60);

		for (int i=1;i<=stars;i++){
			if(i==1){
				Image starg1 = new AnimatedImage(SPengPeng.atlas.findRegion("star_y"),0f);
				addActor(starg1);
				starg1.setX(star1.getX());
				starg1.setY(star1.getY());
			}
			if(i==2){
				Image starg2 = new AnimatedImage(SPengPeng.atlas.findRegion("star_y"),0.5f);
				addActor(starg2);
				starg2.setX(star2.getX());
				starg2.setY(star2.getY());
			}
			if(i==3){
				Image starg3 = new AnimatedImage(SPengPeng.atlas.findRegion("star_y"),1f);
				addActor(starg3);
				starg3.setX(star3.getX());
				starg3.setY(star3.getY());
			}
		}

		//score label
		LabelStyle style = new LabelStyle();
		style.font = SPengPeng.font1;
		style.fontColor = new Color(0x243E60ff);

		Label label = new Label("Score :", style);
		addActor(label);
		label.setPosition((getWidth() - label.getWidth())/2, title.getY() - 140);
		
		LabelStyle style2 = new LabelStyle();
		style2.font = SPengPeng.font2;
		style2.fontColor = new Color(0x243E60ff);
		
		//the score 
		Label scoreLabel = new Label(String.valueOf(score) , style2);
		addActor(scoreLabel);
		scoreLabel.setPosition((getWidth() - scoreLabel.getWidth())/2, label.getY() - 50);

		// NEXT RETRY MENU

		//RETRY button
		ImageButton retryBtn = new ImageButton(
				new TextureRegionDrawable(SPengPeng.atlas.findRegion("retry_btn")),
				new TextureRegionDrawable(SPengPeng.atlas.findRegion("retry_btn_down")));

		addActor(retryBtn);
		retryBtn.setX(getWidth()/2 - retryBtn.getWidth()/2);
		retryBtn.setY(60);

		//fire event on button click
		retryBtn.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				fire(new MessageEvent(ON_RETRY));
			}
		});

		//NEXT button
		ImageButton okBtn = new ImageButton(
				new TextureRegionDrawable(SPengPeng.atlas.findRegion("next_btn")),
				new TextureRegionDrawable(SPengPeng.atlas.findRegion("next_btn_down")));
		
		addActor(okBtn);
		okBtn.setX(retryBtn.getX()-15-okBtn.getWidth());
		okBtn.setY(60);
		
		//fire event on button click
		okBtn.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				fire(new MessageEvent(ON_NEXT));
			}
		});


		//MENU button
		ImageButton menuBtn = new ImageButton(
				new TextureRegionDrawable(SPengPeng.atlas.findRegion("menu_btn")),
				new TextureRegionDrawable(SPengPeng.atlas.findRegion("menu_btn_down")));

		addActor(menuBtn);
		menuBtn.setX(retryBtn.getX()+retryBtn.getWidth()+15);
		menuBtn.setY(60);

		//fire event on button click
		menuBtn.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				fire(new MessageEvent(ON_CLOSE));
			}
		});
	}

}
