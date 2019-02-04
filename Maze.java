// https://courses.edx.org/courses/course-v1:UC3Mx+IT.1.3x+1T2019/courseware/18d6bcc3f441464280b54f62e9b7cf18/5b15eb31c2b74001a0e095bd608e47f4/3?activate_block_id=block-v1%3AUC3Mx%2BIT.1.3x%2B1T2019%2Btype%40vertical%2Bblock%401696e17b5aed4bc99877a09c69b18670


public class Maze {
	
	private MazeStatus[][] maze;
	
	public Maze(int size) {
		this(size,size);
	}
	public Maze(int height, int width) {
		this.maze = new MazeStatus[height][width];
		for(int i=0;i<height;i++)
		    for(int j=0;j<width;j++)
		        maze[i][j] = MazeStatus.OPEN;
// 		Arrays.fill(maze,  MazeStatus.OPEN);
	}
	public Maze(String s) {
		this.maze = stringToMaze(s);
	}
	
	
	
	
	public MazeStatus getposStatus(int i, int j) {
		return maze[i][j];
	}
	public MazeStatus getPosStatus(MazePosition pos) {
		return maze[pos.getCoords()[0]][pos.getCoords()[1]];
	}
	public void setposStatus(int i, int j, MazeStatus status) {
		maze[i][j] = status;
	}
	public void setPosStatus(MazePosition pos, MazeStatus status) {
		maze[pos.getCoords()[0]][pos.getCoords()[1]] = status;
	}
	
	public String toString() {
		String m = "";

		for(int i=0;i<maze.length;i++) {
			for(int j=0;j<maze[0].length;j++) {
				m.concat(Character.toString(maze[i][j].text()));
			}
			m.concat(Character.toString('\n'));
		}
		return m;
	}
	public MazeStatus[][] stringToMaze(String m) {
		
		String[] lines = m.split("\n");
		char[] chars=new char[lines[0].length()];
		maze = new MazeStatus[lines.length][lines[0].length()];
		for(int i=0;i<lines.length;i++) {
			chars = lines[i].toCharArray();
			for(int j=0;j<chars.length;j++) {
				switch(chars[j]) {
				case ' ':
					maze[i][j] = MazeStatus.OPEN;
					break;
				case '#':
					maze[i][j] = MazeStatus.OBSTACLE;
					break;
				case 'x':
					maze[i][j] = MazeStatus.GOAL;
					break;
				case '.':
					maze[i][j] = MazeStatus.VISITED;
					break;
				}
			}
		}
		
		return maze;
	}
	
	public int[] getNeighbourCoords(int i, int j, Movement move) {
		int desi = i + move.vShift();	int desj = j + move.hShift();
		int[] desPos = {desi,desj};
		if(desi*desj < 0 || desi >= maze.length || desj>=maze[0].length)
			return null;
		else
			return desPos;
	}
	public MazePosition getNeighbourCoords(MazePosition pos, Movement move) {
		int desi = pos.getCoords()[0] + move.vShift();	int desj = pos.getCoords()[1] + move.hShift();
		if(desi*desj < 0 || desi >= maze.length || desj>=maze[0].length)
			return null;
		else {
			MazePosition newPos = new MazePosition(desi,desj);
			return newPos;
		}
	}
	
	public void followPath(Path path) {
		int[] coords=path.extractFirst();
		while(coords!=null) {
			if(coords[0]*coords[1]<0 || coords[0]>=maze.length ||coords[1]>=maze[0].length) {
				//outside array limits
				return;
			}
			else if(this.getposStatus(coords[0], coords[1])==MazeStatus.OBSTACLE) {
				//obstacle
				return;
			}
			else if(this.getposStatus(coords[0], coords[1])==MazeStatus.OPEN) {
				//open->visited
				this.setposStatus(coords[0],  coords[1], MazeStatus.VISITED);
			}
			coords = path.extractFirst();
			
		}
		
	}
	

}
