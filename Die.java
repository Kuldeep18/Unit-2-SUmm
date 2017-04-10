
public class Die {

	private int value;
	private int faces;

	/**
	 *  Constructor for a simple Die
	 * @return 
	 */
	public Die() {
		this.faces = 6;
		this.value = 0;
	}
	/*
	 * Constructor for a different die 
	 */
	public Die(int faces) {

		this.faces = faces;
		this.value = 0;

	}
	public void rollDie(){
		this.value = (int)(Math.random()*this.faces + 1);
	}

	public int getValue(){
		return this.value;
	}	

	/**
	 * @param args
	 * self testing main
	 */
	public static void main(String[] args) {
		// create a regular  die
		Die d1 = new Die();
		int dieValue = d1.getValue();
		System.out.println(dieValue);

		d1.rollDie();


		// create a weird die with 12 faces 
		Die d2 = new Die();
		d2.rollDie();
		dieValue = d2.getValue();
		System.out.println(dieValue);
	}
	public boolean checkValue(Die die) {
		if (this.value == die.getValue()){
			return true;
		}
		return false;
	}


}
