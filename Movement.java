
public enum Movement {
	LEFT('<',0,-1),RIGHT('>',0,1),UP('^',-1,0),DOWN('v',0,1);
	
	private char text;
	private int vShift;
	private int hShift;
	
	Movement(char text, int v, int h){
		this.text = text; this.vShift=v; this.hShift=h;
	}
	public char text() { return this.text;}
	public int vShift() {return this.vShift;}
	public int hShift() { return this.hShift;}

}
