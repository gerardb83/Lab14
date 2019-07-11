
public abstract class Player {
	
	protected String name;

	private int score = 0;
	
	public Player(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}

	public abstract Roshambo generateRoshambo();

}
