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
			enemy.health -= damage;
		} else {
			System.out.println(this.name + " dealt " + damage + " damage to " + enemy.name);
			canHitBeBlocked = true;
			if (chance <= 0.30f && canHitBeBlocked) {
				block(chance);
			}
			enemy.health -= damage;
		}
//		if (chance <= 0.30f && canHitBeBlocked) {
//			System.out.println("blocked hit");
//			enemy.health -= (damage * 0.6);
//		}
	}

	public void critical() {
		// float chance = r.nextFloat();
		// if (chance <= 0.05f) {
		damage *= 2;
		canHitBeBlocked = false;
		System.out.println("critical damage dealt " + damage);
		// }
	}

	public void block(float chance) {
//		if (chance <= 0.30f && canHitBeBlocked) {
			enemy.health -= (damage * 0.6);
//		}
	}

	public void evade() {

	}

	boolean isDead() {
		return health <= 0;
	}
}
