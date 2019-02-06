
public class Path {
	
	private PathStep first;
	private PathStep last;
	
	public Path() {
		first = last = null;
	}
	
	
	public void insertFirst(int i, int j) {
		PathStep step = new PathStep(i,j);
		step.setNext(first);
		if(first!=null)
		    first.setPrev(step);
		first = step;
	}
	public void insertLast(int i,int j) {
		PathStep step = new PathStep(i,j);
		if(last!=null)
		    last.setNext(step);
		step.setPrev(last);
		last = step;
	}
	public int[] extractFirst() {
		PathStep step = first;
		if(first==null)
		    return null;
		first = first.getNext();
		if(first!=null)
		    first.setPrev(null);
		return step.getcoords();
	}
	public int[] extractLast() {
		PathStep step = last;
		if(last==null)
		    return null;
		last = last.getPrev();
		if(last!=null)
		    last.setNext(null);
		return step.getcoords();
	}
	
	public String toString() {
		String path="";
		PathStep step=first;
		int[] coords;
		while(step!=null) {
			coords = step.getcoords();
			path.concat("("+Integer.toString(coords[0])+","+Integer.toString(coords[1])+")");
			
		}
		return path;
	}

}
