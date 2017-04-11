import becker.robots.*;
//This is the class file that Droid draws its movement abilties, object movement, as well as wall detection abilties from.
public class BetterRobot extends Robot { //extends Robot's exisiting features onto itself and is made better

	public BetterRobot(City c, int street, int avenue, Direction dir, int numThings) { //declaring and creating our city 

		// Calls the Robot constructor
		super(c, street, avenue, dir, numThings);
	}

	public void move(int steps) { //Allows our robot to move varying amounts of steps
		for (int i = 0; i < steps; i++) {
			move(); // Calls the move from Robot
		}
	}

	public void turnAround() { //Allows our robot to turn around, left
		for (int i = 0; i < 2; i++) {
			turnLeft();
		}
	}

	public void turnRight() { //Allows our robot to turn around, right
		for (int i = 0; i < 3; i++) {
			turnLeft();
		}
	}

	public void pickRow(int steps) { //Checks if the robot can pick something up, if so then it picks it up. Designed for usage in rows
		for (int i = 0; i < steps; i++) {
			move();
			for (int j = 0; j < steps; j++) {
				if (canPickThing()) {
					pickThing();
				}
			}
		}
	}
	
	public void checkWall(int thingStr) { //Wall dectection method, checks for walls and recalibrates movement to avoid them
		
		if (frontIsClear()) {
			move(thingStr);
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
	}
	
	public void pickThing(int steps, boolean check) { //True or false checker for if something is able to be picked up
		if (canPickThing()) {

		}
	}

}
