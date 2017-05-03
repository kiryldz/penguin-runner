package com.boontaran.games.pengpeng.panel;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.boontaran.games.pengpeng.SPengPeng;

public class CoinCounter extends Group {
	private Label label;
	
	public CoinCounter() {
		setTransform(false);
		//coin image
		Image coin = new Image(SPengPeng.atlas.findRegion("coin_icon"));
		addActor(coin);
		
		//label for coin number
		LabelStyle style = new LabelStyle();
		style.font = SPengPeng.font1;
		style.fontColor = new Color(0x404040ff);
		label = new Label("555", style);
		setSize(label.getRight() + 30 , coin.getHeight());
		
		addActor(label);
		label.setX(36);
		label.setY(-5);
		label.setText("0");
	}
	
	//set the text
	public void setCount(int count) {
		label.setText(String.valueOf(count));
	}

}
