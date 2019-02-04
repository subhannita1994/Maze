
public enum MazeStatus {

	OPEN(' '),OBSTACLE('#'),GOAL('x'),VISITED('.');
	private char text;
	MazeStatus(char text) {
		this.text = text;
	}
	public char text() {
		return this.text;
	}
	
}
