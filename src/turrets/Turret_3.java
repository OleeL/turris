package turrets;

/**
 * @author Team 62
 * Oliver Legg - sgolegg - 201244658
 *
 */
public class Turret_3 extends Turret {

	
	/**
	 * @param float x position 
	 * @param float y position 
	 * @param float grid_size
	 */
	public Turret_3(float x, float y, float grid_size){
		super("turrets/turret_3", x, y, grid_size);
		range = 225;
		damage = 5;
		rateOfFire = 100;
		cost = 500;
		arrowSpeed = 10;
		upgrade_cost = 250;
	}

	public int upgrade() {
		int cost = 0;
		if (level < MAX_LEVEL) {
			level++;
			range += 0.2;
			damage += 2;
			rateOfFire -= 0.002;
			cost = upgrade_cost;
			upgrade_cost *= 1.8;
		}
		return cost;
	}

}