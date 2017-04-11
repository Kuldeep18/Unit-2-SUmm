import becker.robots.*;
//This is the class file that Droid draws its movement abilties, object movement, as well as wall detection abilties from.
/*Method List: Void Move - Move Command
turnAround - Left Turn
turnRight - Right Turn
pickrow - Checks if something can be picked up and then picks it up
checkwall - wall detection, recalibrates if there is an obstacle
pick thing - picks thing if it can
 */

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
	public void pickGrid (int rows, int cols){
		for (int i = 0; i < rows; i++){
			pickRow(cols);
			turnRight();
			pickRow(cols);
			turnRight();
		}

	}
	public void putGrid (int rows, int cols){
		for(int i = 0; i < rows; i++)
		{
			putRow(cols);
			turnAround();
			move(cols);
			if(i<rows-1){
				turnLeft();
				move();
				turnLeft();
			}
		}
	}



	public void putRow(int cols) {
		for (int i = 0; i < cols; i ++)
		{
			putThing();
			move();
		}
		// TODO Auto-generated method stub

	}
}
