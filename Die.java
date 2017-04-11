// This Class file allows for the user and computer to roll dice and be able to move accordingly in a randomized, generated function.
//Author: Joshua V & Kuldeep M
public class Die {

	private int value; //declaring hidden int values
	private int faces; //declaring hidden face values

	/**
	 *  Constructor for a simple Die
	 * @return 
	 */
	public Die() { //public method initialization
		this.faces = 6; //sets the number of faces for the die
		this.value = 0; //Initializes the value of the faces @ 0
	}
	/*
	 * Constructor for a different die 
	 */
	public Die(int faces) { //Starts to apply a value amount to faces

		this.faces = faces;
		this.value = 0; //initializes the value of the faces to 0

	}
	public void rollDie(){ //Rolling dice to a generated numeric value
		this.value = (int)(Math.random()*this.faces + 1); //equation for the generator
	}

	public int getValue(){ //public int to return the value that was rolled
		return this.value;
	}	

	/**
	 * @param args
	 * self testing main
	 */
	public static void main(String[] args) { //main self testing
		// create a regular  die
		Die d1 = new Die();
		int dieValue = d1.getValue(); //takes the existing value of the die
		System.out.println(dieValue);//displayes the received value

		d1.rollDie();


		// create a weird die with 12 faces 
		Die d2 = new Die();
		d2.rollDie(); //rolls die 2
		dieValue = d2.getValue(); //receives the value
		System.out.println(dieValue); //prints the rolled value
	}
	public boolean checkValue(Die die) {
		if (this.value == die.getValue()){
			return true;
		}
		return false;
	}


}
