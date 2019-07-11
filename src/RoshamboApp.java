import java.util.*;

public class RoshamboApp {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean keepGoing = true;
		String userName = "";
		int round = 0;

		System.out.println("Let's Ro Sham Bo!\n");
		userName = Validation.capitalizeFullName(Validation.getString(scan, "Enter your name: "));
		System.out.println("Select an opponent: Rocky or Rando");
		Player player1 = new PlayerConsole(userName);
		Player player2;
		String userChoice = scan.nextLine();
		if (userChoice.equalsIgnoreCase("rando")) {
			player2 = new PlayerRandom("Rando");
		} else {
			player2 = new PlayerRocky("Rocky");
		}
		System.out.println("\nTo quit at anytime, type 'quit'");

		do {
			System.out.println("\n=============================");
			System.out.println("\nRound: " + (++round));
			keepGoing = playRound(player1, player2);
			System.out.println("\n" + player1.getName() + "'s score: \t" + player2.getName() + "'s score:");
			System.out.println("    " + player1.getScore() + "\t\t\t" + player2.getScore());
		} while (keepGoing == true);

		System.out.println();
		if(player1.getScore() == player2.getScore()) {
			System.out.println("Running away, are you?");
		} else if (player1.getScore() < player2.getScore()) {
			System.out.println("It's all in the wrist, you know.");
		} else {
			System.out.println("Not bad, " + player1.getName() + ". Next time won't be so easy.");
		}
		scan.close();
	}

	public static boolean playRound(Player player1, Player player2) {
		boolean keepGoing = true;
		Roshambo pick1 = player1.generateRoshambo();
		Roshambo pick2 = player2.generateRoshambo();
		System.out.println("\n" + player1.getName() + " plays: " + pick1);
		System.out.println(player2.getName() + " plays: " + pick2);
		if (pick1 == Roshambo.QUIT) {
			keepGoing = false;
		} else if (pick1 == pick2) {
			System.out.println("\nTIE!");
		} else if ((pick1 == Roshambo.ROCK) && (pick2 == Roshambo.PAPER)
				|| (pick1 == Roshambo.PAPER) && (pick2 == Roshambo.SCISSORS)
				|| (pick1 == Roshambo.SCISSORS && pick2 == Roshambo.ROCK)) {
			System.out.println("You LOSE!");
			player2.setScore(player2.getScore() + 1);
		} else {
			System.out.println("You WIN!");
			player1.setScore(player1.getScore() + 1);
		}
		return keepGoing;

	}

}
