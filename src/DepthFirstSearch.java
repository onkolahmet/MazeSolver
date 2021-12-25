import java.util.Collections;
import java.util.Stack;

public class DepthFirstSearch extends SearchingAlgorithm {

    public DepthFirstSearch(Maze maze) {
        super(maze);
        this.frontier = new Stack<Node>();

        initializeSearch();
    }

    @Override
    public void search() {
        Stack<Node> frontier = (Stack<Node>) this.frontier;

        while (!frontier.isEmpty()) { 
            Node currentNode = frontier.pop();

            explored.add(currentNode.getState());
            
            if (currentNode.isGoal()) {
                printResults(currentNode);
                break;
            }

            currentNode.expand();
            Collections.reverse(currentNode.getChildren());
            addChildrenToFrontier(currentNode);
        }
    }
}