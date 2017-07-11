package lesson13;

import java.util.Random;

public class SuperHero {

	String name;
	int health = 100;
	int damage = 5;
	SuperHero enemy;
	
	void hit(){
		damage = new Random().nextInt(10);
		enemy.health -= damage;
		System.out.println(name + " hits " + enemy.name + " for " + damage + " damage. " + enemy.name + " is left with " + enemy.health + " health");;
	}
	
	boolean isDead(){
		return health <= 0;
	}
}
