import java.util.Random;
import java.util.Scanner;

public class Round {

	// vars
	int playerPick, compPick;
	boolean roundWinner, playerType, compType; // false=odds true=evens
	// objects
	History sessHistory;
	Scanner sc = new Scanner(System.in);
	Random rn = new Random();

	public Round(boolean playerType, boolean compType, History sessHistory) {
		this.playerType = playerType;
		this.compType = compType;
		this.sessHistory = sessHistory;
	}

	public void playRound() {

		System.out.println("pick 1 or 2");
		playerPick = sc.nextInt(); // make a method of this
		compPick = rn.nextInt(2) + 1;
		if (playerPick==1) {
			sessHistory.newGameNode.numberChoices[sessHistory.newGameNode.roundLimit] = 1 ;				
		} else {
			sessHistory.newGameNode.numberChoices[sessHistory.newGameNode.roundLimit] = 2 ;							
		}
		// method for winner
		roundWinner = calcRoundWinner(playerPick, compPick);

	}

	// game picks odd or even
	// play rounds as needed
	// round pick 1 or 2 and computer is opposite
	// discover winner
	public boolean calcRoundWinner(int player, int comp) {
		if (player + comp == 3) {
			if (playerType == false) {
				return true;
			} else {
				return false;
			}
		} else {
			if (playerType == true) {
				return true;
			} else {
				return false;
			}
		}
	}

	public boolean getRoundWinner() {
		return roundWinner;
	}

}
