
public class PlayerRandom extends Player {

	public PlayerRandom(String name) {
		super(name);
	}
	
	public Roshambo generateRoshambo() {
		Roshambo pick;
		int num = 1 + (int)(Math.random() * ((3 - 1) + 1));
		if(num == 1) {
			pick = Roshambo.ROCK;
		} else if (num == 2) {
			pick = Roshambo.PAPER;
		} else {
			pick = Roshambo.SCISSORS;
		}
		return pick;
	}
}
