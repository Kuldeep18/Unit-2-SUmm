import becker.robots.*;

/**
 * @author Joshua and Kuldeep
 * Date: April 2017
 * Description: Sets up and creates the droids and galaxy. Walls and things are placed randomly within streets and avenues 2 and 12.
 * Method List: placeWall(City galaxy) - This method creates at least 20 walls and places them randomly with the galaxy.
 * 				placeThing(City galaxy) - This method creates a minimum of 512 things in the galaxy which are randomly placed throughout.
 * 				main(String[] args) - This method calls from the other methods to create the galaxy.
 */
public class GalaxyGame {

	public static void placeWall(City galaxy) {
		// Declares int variables, Direction variable, and a Wall array.
		int wallAve, wallStr, howManyWalls;
		Direction dir;
		Wall w[];
		
		// Create 5 new Dice. With three special dice. One with 4 faces and two with 15 faces.
		Die d1 = new Die();
		Die d2 = new Die();
		Die d3 = new Die(4);
		Die d4 = new Die(15);
		Die d5 = new Die(15);
		
		// Rolls the 15 faced dice until the added value of both dice is greater than 20.
		d4.rollDie();
		d5.rollDie();
		while (d4.getValue() + d5.getValue() < 20) {
			d4.rollDie();
			d5.rollDie();
		}
		// Assigns the added rolled value to a int variable then array.
		howManyWalls = d4.getValue() + d5.getValue();
		w = new Wall[howManyWalls];

		/* For loop which takes values of the rolled dice and places walls based on their values. 
		 * It will also place the wall in a certain orientation depending on the value of the special 4 faced die.
		 */
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
		// Declares int variables and thing array. 
		int thingAve, thingStr;
		Thing t[];

		// Creates two new dice.
		Die d1 = new Die();
		Die d2 = new Die();

		// Assign 512 elements to the thing array
		t = new Thing[512];

		/* For loop which rolls the dice and assigns the the added value to thingAve then repeats for thingStr.
		 * Then places the thing in the assigned streets and avenues. Repeats until 512 things have been placed down.
		 */
		for (int i = 0; i < 512; i++) {
			d1.rollDie();
			d2.rollDie();
			thingAve = d1.getValue() + d2.getValue();
			d1.rollDie();
			d2.rollDie();
			thingStr = d1.getValue() + d2.getValue();
			t[i] = new Thing(galaxy, thingStr, thingAve);
		}

		galaxy.showThingCounts(true); // Shows the amount of things on an intersection.
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Creates a new city called galaxy.
		City galaxy = new City(0, 0, 15, 15, 40);
		
		// Places things and walls within the galaxy.
		placeThing(galaxy);	
		placeWall(galaxy);

		// Creates the droid r2d2 and c3p0.
		Droid r2d2 = new Droid (galaxy, 0, 0, Direction.EAST, 0);
		Droid c3p0 = new Droid (galaxy, 0, 14, Direction.WEST, 0);

		// Creates two dice
		Die d1 = new Die();
		Die d2 = new Die();
		
		// Declare int variable.
		int a;
		
		// Roll dice to determine the number of things to be picked up
		d1.rollDie();
		d2.rollDie();
		
		// Assign a the value of the rolled dice to determine how much things the droid must pick up.
		a = d1.getValue() + d2.getValue();
		
		//r2d2.

		d1.rollDie();
		d2.rollDie();
		
		a = d1.getValue() + d2.getValue();
		
		//c3p0.
	}

}
