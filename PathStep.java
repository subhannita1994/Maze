
public class PathStep {
	
	private int i;	private int j;	
	private PathStep next;
	private PathStep prev;
	
	public PathStep(int i, int j) {
		this.i = i; this.j=j;
		this.next=this.prev=null;
	}
	
	public int[] getcoords() { int[] coords= {i,j}; return coords;}	
	public void setcoords(int[] coords) { this.i = coords[0]; this.j=coords[1];}
	public PathStep getNext() { return this.next;}
	public void setNext(PathStep next) {this.next=next;}
	public PathStep getPrev() {return this.prev;}
	public void setPrev(PathStep prev) { this.prev=prev;}

}
