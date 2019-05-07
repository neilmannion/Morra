import java.util.Scanner;

public class Game {

	History sessHistory;

	public Game() {
	}

	public Game(History sessHistory) {
		this.sessHistory = sessHistory;
	}

	// vars
	boolean playerType, compType; // false=odds true=evens
	int playerScore = 0, compScore = 0;

	// objects
	Scanner sc = new Scanner(System.in);
	Round round;

	public void playGame() {

		oddsOrEvens();
		int roundNo = 1;

		while (playerScore < 4 && compScore < 4) {

			round = new Round(playerType, compType, sessHistory);

			System.out.println("\tRound: " + roundNo);
			roundNo++;

			round.playRound();

			if (round.getRoundWinner()) {
				playerScore++;
				System.out.println("Congrats you won this round");
				sessHistory.newGameNode.victories[sessHistory.newGameNode.roundLimit] = true;
			} else {
				compScore++;
				System.out.println("Too bad you lost this round");
				sessHistory.newGameNode.victories[sessHistory.newGameNode.roundLimit] = false;
			}

			sessHistory.newGameNode.roundLimit++;
			System.out.println("The current score is \nPlayer: " + playerScore + "	Computer: " + compScore + "\n");
		}

	}

	public boolean getWinner() {
		if (playerScore == 4) {
			return true;
		} else {
			return false;
		}
	}

	public void oddsOrEvens() {
		System.out.println("Do you wish to play as ODDs (enter 'odd') or EVENs (enter 'even')");
		if (sc.nextLine().toLowerCase().contains("odd")) {
			playerType = false;
			compType = true;
			History.odds++;
			sessHistory.newGameNode.playType = false;
			sessHistory.newGameNode.playerRoundWinNo++;
		} else {
			playerType = true;
			compType = false;
			History.evens++;
			sessHistory.newGameNode.playType = true;
			sessHistory.newGameNode.compRoundWinNo++;
		}
	}

	// play round
	// get roundWinner
	// check if 4 rounds won

}
