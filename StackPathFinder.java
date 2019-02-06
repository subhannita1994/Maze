import java.util.Stack;

public class StackPathFinder {

	//preference of movement directions
	private Movement[] move = {Movement.LEFT, Movement.UP, Movement.DOWN, Movement.RIGHT};
	
	private MazePosition[] findNeighbors(Maze maze, MazePosition pos) {
		//finds neighbors of pos within maze and returns according to preference of directions
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
		//finds a path from (0,0) to GOAL
		
		//initiating stack to explore maze from (0,0)
		Stack<MazePosition> explore = new Stack<MazePosition>();
		MazePosition[] neighbors = null;
		MazePosition curPos = new MazePosition(0,0);
		MazePosition goal = null;
		explore.push(curPos);
		
		//exploring path through Maze following DFS until all positions are explored or GOAL is found
		while(!explore.isEmpty() && goal!=null) {
			curPos = explore.pop();
			System.out.println("Exploring "+ curPos.getCoords()[0] + "," + curPos.getCoords()[1]);
			switch(maze.getPosStatus(curPos)) {
			case GOAL:
				//finish
				goal = curPos;
				System.out.println("Goal found");
				break;
			case VISITED:
				//nothing to do
				System.out.println("Visited found");
				break;
			case OBSTACLE:
				//invalid
				System.out.println("Obstacle found");
				return null;
			case OPEN:
				//change position to visited and push valid neighbors
				System.out.println("Open found");
				maze.setPosStatus(curPos, MazeStatus.VISITED);
				neighbors = findNeighbors(maze,curPos);
				for(int i=0;i<neighbors.length;i++) {
					if(maze.getPosStatus(neighbors[i])==MazeStatus.OPEN || maze.getPosStatus(neighbors[i])==MazeStatus.GOAL) {
						neighbors[i].setFrom(curPos);
						explore.push(neighbors[i]);
					}
				}
			}
		}
		
		//building path backward from GOAL to (0,0)
		curPos = goal;
		Path path = new Path();
		path.insertFirst(curPos.getCoords()[0],curPos.getCoords()[1]);
		while(curPos.getFrom()!=null) {
			curPos = curPos.getFrom();
			System.out.println("Building "+ curPos.getCoords()[0] + "," + curPos.getCoords()[1]);
			path.insertFirst(curPos.getCoords()[0],curPos.getCoords()[1]);
		}
		
		return path;
		
	}
	
	
	
}
