import becker.robots.*;

public class BetterRobot extends Robot {

	public BetterRobot(City c, int street, int avenue, Direction dir, int numThings) {

		// Calls the Robot constructor
		super(c, street, avenue, dir, numThings);
	}

	public void move(int steps) {
		for (int i = 0; i < steps; i++) {
			move(); // Calls the move from Robot
		}
	}

	public void turnAround() {
		for (int i = 0; i < 2; i++) {
			turnLeft();
		}
	}

	public void turnRight() {
		for (int i = 0; i < 3; i++) {
			turnLeft();
		}
	}

	public void pickRow(int steps) {
		for (int i = 0; i < steps; i++) {
			move();
			for (int j = 0; j < steps; j++) {
				if (canPickThing()) {
					pickThing();
				}
			}
		}
	}
	
	public void checkWall(int thingStr) {
		
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
	
	public void pickThing(int steps, boolean check) {
		if (canPickThing()) {

		}
	}

}
