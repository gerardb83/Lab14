import java.util.*;

public class PlayerConsole extends Player {
	static Scanner scan = new Scanner(System.in);
	
	public PlayerConsole(String name) {
		super(name);
	}
	
	public Roshambo generateRoshambo() {
		Roshambo pick = null;
		String userInput = Validation.matchString(scan, "Enter rock, paper, scissors: ", "rock", "paper", "scissors", "quit");
		if (userInput.equalsIgnoreCase("rock")) {
			pick = Roshambo.ROCK; 
		} else if (userInput.equalsIgnoreCase("paper")) {
			pick = Roshambo.PAPER; 
		} else if (userInput.equalsIgnoreCase("scissors")) {
			pick = Roshambo.SCISSORS; 
		} else if (userInput.equalsIgnoreCase("quit")) {
			pick = Roshambo.QUIT; 
		} 
		return pick;
	}

}
