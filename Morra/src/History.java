import java.util.LinkedList;


public class History {
	static int wins=0, losses=0, odds=0, evens=0;
	Node newGameNode;
	LinkedList<Node> mainHistory = new LinkedList();
	
		
	
	public void newGame() {
		newGameNode = new Node();	
		mainHistory.add(newGameNode);
		newGameNode.gameNo++;
	}
	
	public void increaseGame() {
		newGameNode.gameNo++;
	}
	
	
	
	
	public class Node{
		
		int gameNo =0, roundLimit=0, playerRoundWinNo=0, compRoundWinNo=0;
		boolean playType;
		boolean[] victories = new boolean[7];
		int[] numberChoices = new int[7];
		
	}
}
