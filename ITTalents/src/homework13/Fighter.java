package homework13;

import java.util.Random;

public class Fighter {
	String name;
	int health = 100;
	int damage;
	Fighter enemy;
	boolean canHitBeBlocked = true;

	Random r = new Random();

	public void hit() {
		System.out.println(enemy.name + " health " + enemy.health);
		damage = new Random().nextInt(10);
		float chance = r.nextFloat();
		if (chance <= 0.05f) {
			System.err.println("critical hit to " + enemy.name);
			critical();
		} else {
			canHitBeBlocked = true;
			if (chance <= 0.15f) {
				evade();
			} else {
				if (chance <= 0.30f && canHitBeBlocked) {
					block();
				} else {
					enemy.health -= damage;
					System.out.println(this.name + " dealt " + damage + " damage to " + enemy.name);
				}
			}
		}
	}

	public void critical() {
		damage *= 2;
		canHitBeBlocked = false;
		enemy.health -= damage;
		System.out.println("critical damage dealt " + damage);
	}

	public void block() {
		enemy.health -= (damage * 0.6);
		System.out.println("Hit blocked!");
	}

	public void evade() {
		System.out.println("Hit evaded!");
	}

	boolean isDead() {
		return health <= 0;
	}
}
