import becker.robots.*;
/**
 *
 */

/**
 * @author Kuldeep and Joshua
 *
 */
public class Droid extends BetterRobot {

	public Droid(City c, int street, int avenue, Direction dir, int numThings) {

		// Calls the Robot constructor
		super(c, street, avenue, dir, numThings);
	}

	private int steps = 0;

	private int score, tempScore (int getValue)
	{
		int tempScore = getValue;
		score = 


	}


	/**
	 * @param args
	 */
	public boolean checkWall() {
		if (frontIsClear()) {
			move(steps);
		}
		else {
			while (!frontIsClear()) {
				turnLeft();  
				move();          
				turnRight();
			}
			move();
			turnLeft();
		}
		return false;

	}
	public int BeepCount (Die d1, Die d2){ //Rolls the Die's 2x
		for(int i =0; i < 2; i++){
			d1.rollDie();
			d2.rollDie();
		}
		public boolean maxBeepLimit (Die d1, Die d2){//Checks if Die's are 2, 3 or 12
			int restrictedRoll1, restrictedRoll2, restrictedRoll3;

			//Check if Sum Value is restriced
			if(restrictedRoll1 + restrictedRoll2 + restrictedRoll3 == 2){}
			else if ((restrictedRoll1 + restrictedRoll2 + restrictedRoll3 == 3) || (restrictedRoll1 + restrictedRoll2 + restrictedRoll3 == 12)){
				return false;
			}

		}
		public boolean checkObject (int pickUpBeeper){
			for(int i = 0; i <= steps; i++){
				move();
				for(int j = 0; j <=steps; j++){
					if(canPickThing()){
						pickThing();
					}
				}
			}
		}
	}

