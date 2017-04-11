import becker.robots.*;

/**
 * @author Joshua and Kuldeep
 * Date: April 2017
 * Description: Sets up and creates the droids and galaxy. Walls and things are placed randomly within streets and avenues 2 and 12.
 * Method List: placeWall(City galaxy) - This method creates at least 20 walls and places them randomly with the galaxy.
 * 				placeThing(City galaxy) - This method creates a minimum of 512 things in the galaxy which are randomly placed throughout.
 * 				main(String[] args) - This method calls from the other methods to create the actual galaxy.
 */
public class GalaxyGame {

	public static void placeWall(City galaxy) {
		int wallAve, wallStr, howManyWalls;
		Direction dir;
		Wall w[];
		
		Die d1 = new Die();
		Die d2 = new Die();
		Die d3 = new Die(4);
		Die d4 = new Die(15);
		Die d5 = new Die(15);
		
		d4.rollDie();
		d5.rollDie();
		while (d4.getValue() + d5.getValue() < 20) {
			d4.rollDie();
			d5.rollDie();
		}
		howManyWalls = d4.getValue() + d5.getValue();
		w = new Wall[howManyWalls];

		for (int i = 0; i < howManyWalls; i++) {
			d1.rollDie();
			d2.rollDie();
			wallAve = d1.getValue() + d2.getValue();
			d1.rollDie();
			d2.rollDie();
			wallStr = d1.getValue() + d2.getValue();
			d3.rollDie();
			if (d3.getValue() == 1) {
				dir = Direction.NORTH;
				w[i] = new Wall(galaxy, wallStr, wallAve, dir);
			} else if (d3.getValue() == 2) {
				dir = Direction.EAST;
				w[i] = new Wall(galaxy, wallStr, wallAve, dir);
			} else if (d3.getValue() == 3) {
				dir = Direction.SOUTH;
				w[i] = new Wall(galaxy, wallStr, wallAve, dir);
			} else if (d3.getValue() == 4) {
				dir = Direction.WEST;
				w[i] = new Wall(galaxy, wallStr, wallAve, dir);
			}

		}
	}
	
	public static void placeThing(City galaxy) {
		int thingAve, thingStr;
		Thing t[];

		Die d1 = new Die();
		Die d2 = new Die();

		t = new Thing[512];

		for (int i = 0; i < 512; i++) {
			d1.rollDie();
			d2.rollDie();
			thingAve = d1.getValue() + d2.getValue();
			d1.rollDie();
			d2.rollDie();
			thingStr = d1.getValue() + d2.getValue();
			t[i] = new Thing(galaxy, thingStr, thingAve);
		}

		galaxy.showThingCounts(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		City galaxy = new City(0, 0, 15, 15, 40);
		
		placeThing(galaxy);	
		placeWall(galaxy);

		Droid r2d2 = new Droid (galaxy, 0, 0, Direction.EAST, 0);
		Droid c3p0 = new Droid (galaxy, 0, 14, Direction.WEST, 0);

		r2d2.move(10);


	}

}
