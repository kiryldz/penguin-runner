package com.iwolt.games.pengpeng.enemies;

import com.boontaran.MessageEvent;
import com.boontaran.games.platformerLib.Entity;
import com.iwolt.games.pengpeng.Bullet;
import com.iwolt.games.pengpeng.Pengpeng;

public abstract class Enemy extends Entity {
	//events
	public static final int DIE = 1;
	
	//
	protected int score = 100;
	
	
	//enemy's health level
	protected float health = 1;
	protected boolean hasDied;
	
	//damage to take when attack hero
	protected float damage = 1;
	
	public Enemy() {
		restitution = 0;
		edgeUpdateLimRatio = 0.2f;
	}
	
	//reduce health, die if out of health
	public void attackedByHero(Pengpeng hero,float damageMultiplier) {
		health -= hero.getDamage()*damageMultiplier;
		if(health <=0) die();		
	}
	public void attackHero(Pengpeng hero) {
		//implemented on subclass
	}
	public boolean isHasDied() {
		return hasDied;
	}
	public int getScore() {
		return score;
	}
	
	
	protected void die() {
		hasDied = true;
		setNoCollision(true);
		setNoLandCollision(true);
		
		//fire event indicate the enemy has die
		fire(new MessageEvent(DIE));
	}
	
	//hero's bullet hit the enemy
	public void attackedBy(Bullet bullet) {
		//reduce health
		health -= bullet.getDamage();
		if(health <=0) die();		
	}
	
	//slide by turtle type enemy
	public void attackedBy(Enemy2 slidingEnemy) {
		health = 0;
		die();
	}
	
	
	public float getDamage() {
		return damage;
	}
	public void flip() {
		//implemented on subclass
	}

}
