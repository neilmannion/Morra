import java.util.Iterator;
import java.util.Scanner;

/* Remake/alteration of Morra game project
 * Divsion of classes for future changes
 * Neil Mannion
 * 05/05/2019
 */
public class MorraMain {

	public static void main(String[] args) {

		// variables
		int gameNo = 1;
		boolean again = true;

		// objects
		Scanner sc = new Scanner(System.in);
		History sessHistory = new History();
		Game mGame;

		System.out.println("\t\t\t ~~~Welcome to Morra~~~");
		System.out.println("\n\t\t Do you want to go over the rules (Y/N)? \n\n");

		if (sc.nextLine().toLowerCase().contains("y")) {
			System.out.println("  Each game of morra begins with choosing if you wish to play as odds or even."
					+ "\nAfter choosing your side you have 7 rounds of picking either 1 or 2 while the computer will also pick randomly"
					+ "\nIf you are odds and the combined pick of you and the computer is odd then you gain a point, if not then the computer is given a point"
					+ "\neach game is best of 7 rounds"
					+ "\n After each set of games you will be asked if you wish to play again"
					+ "\nplay as many times as you desire and once you have had enough you can see your stats for this play session by quiting\n\n");
		}

		while (again) {
			System.out.println("\t\tGAME: " + gameNo);
			gameNo++;

			sessHistory.newGame();
			mGame = new Game(sessHistory);
			mGame.playGame();

			if (mGame.getWinner()) {
				System.out.println(
						"\nCongratulations!!!!! You won 4 games first and beat the computer. It must be your lucky day");
				History.wins++;
			} else {
				System.out
						.println("\nYou lose!! Too bad the computer got to 4 wins first, it must not be you lucky day");
				History.losses++;
			}

			System.out.println("Do you wish to play again");
			again = sc.nextLine().toLowerCase().contains("y");
		}

		System.out.println("\n\n\t\t\t ~~~Session Over~~~");
		System.out.println("\nResults:	Wins	Losses");
		System.out.println("		" + History.wins + "	" + History.losses);

		System.out.println("\nTimes odd:  " + History.odds);
		System.out.println("Times even: " + History.evens);

		for (Node temp : sessHistory.mainHistory) {

			System.out.println("\nSet " + ": " + temp.gameNo);

			System.out.println("\tPlayer(" + temp.playType + ") rounds won " + temp.playerRoundWinNo
					+ "\t Computer rounds won: " + temp.compRoundWinNo);

			
			System.out.print("\nNo. Pick: [ ");
			for (int i = 0; i < temp.roundLimit; i++) {
				System.out.print(temp.numberChoices[i] +" ");
			}
			System.out.print("]");

			
			System.out.print("\nResults:  [ ");
			for (int i = 0; i < temp.roundLimit; i++) {
				char tempResult;
				if (temp.victories[i]) {
					tempResult = 'W';
				} else {
					tempResult = 'L';
				}
				System.out.print(tempResult + " ");
			}
			System.out.print("]");

			System.out.print("\n");

		}

		System.out.print("\n\t\t\t ~~~HOPE TO ENJOYED THE GAME~~~");

	}

}