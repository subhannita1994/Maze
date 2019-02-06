
public class MazePosition {

	private int[] coords = new int[2];
	private MazePosition from;
	
	public MazePosition(int i, int j) {
		this.coords[0] = i; this.coords[1] = j;
		this.from = null;
	}
	public MazePosition(int i, int j, MazePosition from) {
		this.coords[0] = i; this.coords[1] = j;
		this.from = from;
	}
	
	public int[] getCoords() {return coords;}
	public void setFrom(MazePosition from) {this.from = from;}
	public MazePosition getFrom() {return this.from;}
	
	
}
