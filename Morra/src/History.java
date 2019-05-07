import java.util.LinkedList;

public class History {
	static int wins = 0, losses = 0, odds = 0, evens = 0, statGameNo=0;
	Node newGameNode;
	LinkedList<Node> mainHistory = new LinkedList();

	public void newGame() {
		newGameNode = new Node();
		mainHistory.add(newGameNode);
		statGameNo++;
		newGameNode.setGameNo(statGameNo);
	}

}
