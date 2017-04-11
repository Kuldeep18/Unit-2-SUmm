import becker.robots.*;
/**
This class is what allows the Droids to do many of their functions, like movement capabilities, problems solving with obstacles,
as well as score checkers and limit definers.
Method List: checkWall, BeepCount, maxBeepLimit, checkObject
 */

/**
 * @author Kuldeep and Joshua
 * Date: April 2017
 */
public class Droid extends BetterRobot { //Inherits Robot

	public Droid(City c, int street, int avenue, Direction dir, int numThings) { //Creating City

		// Calls the Robot constructor
		super(c, street, avenue, dir, numThings);
	}

	private int steps = 0;
	/**
	 * @param args
	 */
	public boolean checkWall() { //WallCheck Detection
		if (frontIsClear()) {
			move(steps);
		}
		else {
			while (!frontIsClear()) { //If there is a wall, then it will recalibrate to avoid the obstacle
				turnLeft();  
				move();          
				turnRight();
			}
			move();
			turnLeft();
		}
		return false; //If there is no obstacle, then it will not do anything and return a false

	}
	public int beepCount (Die d1, Die d2){ //Rolls the Die's 2x
		for(int i =0; i < 2; i++){
			d1.rollDie();
			d2.rollDie();
		}
		return steps;
		}
		public boolean maxBeepLimit (Die d1, Die d2){//Checks if Die's are 2, 3 or 12
			int restrictedRoll1 = d1.getValue(), restrictedRoll2 = d2.getValue();

			//Check if Sum Value is restricted
			if(restrictedRoll1 + restrictedRoll2 == 2){}
			else if ((restrictedRoll1 + restrictedRoll2 == 3) || (restrictedRoll1 + restrictedRoll2 == 12)){
				return false; //If none of the restricted numbers are rolled then the program continues as normal
			}
			return false;

		}
		public boolean checkObject (int pickUpBeeper){ //Picks up the Beeper
			for(int i = 0; i <= steps; i++){
				move();
				for(int j = 0; j <=steps; j++){
					if(canPickThing()){
						pickThing();
					}
				}
			}
			return false; //returns false if there is not an object that cannot be picked up
		}
		
		public void behaviorTest(){ //Self testing method to show that R2D2 can detect and recalibrate when there is a wall placed.
			
			move();
			turnRight();
			move();
			turnLeft();
			turnLeft();
			turnRight();
			checkWall();
			move();
			turnLeft();
			
		}
		public static void main (String [] args){
			City galaxy = new City (16, 16);
			Droid r2d2 = new Droid(galaxy, 3, 4, Direction.EAST, 0);
			new Wall (galaxy, 4, 6, Direction.WEST);
			
			r2d2.behaviorTest();
			
			
		}
	}

