
public class Node {
	
	
	int roundLimit = 0, playerRoundWinNo = 0, compRoundWinNo = 0, gameNo=0;
	boolean playType;
	boolean[] victories = new boolean[7];
	int[] numberChoices = new int[7];

	public void setGameNo(int a) {
		gameNo = a;
	}
}
