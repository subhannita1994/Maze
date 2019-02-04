import java.util.Stack;
import java.util.LinkedList;

public class StackPathFinder {

	private Movement[] move = {Movement.LEFT, Movement.UP, Movement.DOWN, Movement.RIGHT};
	
	private MazePosition[] findNeighbors(Maze maze, MazePosition pos) {
		MazePosition[] neighbors = null;
		int j = 0;
		for(int i=0;i<move.length;i++) {
			if(maze.getNeighbourCoords(pos, move[i])!=null) {
				neighbors[j] = maze.getNeighbourCoords(pos, move[i]);
				j++;
			}
		}
		
		return neighbors;
		
	}
	
	public Path findPath(Maze maze) {
		
		Stack<MazePosition> path = new Stack<MazePosition>();
		MazePosition[] neighbors = null;
		MazePosition curPos = new MazePosition(0,0);
		path.push(curPos);
		
		while(!path.isEmpty()) {
			
			curPos = path.pop();
			
			switch(maze.getPosStatus(curPos)) {
			case GOAL:
				//finish
				break;
			case VISITED:
				//nothing to do
				break;
			case OBSTACLE:
				//invalid
				return null;
			case OPEN:
				//change position to visited and push valid neighbours
				maze.setPosStatus(curPos, MazeStatus.VISITED);
				neighbors = findNeighbors(maze,curPos);
				for(int i=0;i<neighbors.length;i++) {
					if(maze.getPosStatus(neighbors[i])==MazeStatus.OPEN || maze.getPosStatus(neighbors[i])==MazeStatus.GOAL)
						path.push(neighbors[i]);
				}
				
			
			}
			
		}
		
		
		
	}
	
	
	
}
