package sets;

public class TruthValue {
	
	private boolean value;
	
	public final static TruthValue TRUE = new TruthValue(true);
	public final static TruthValue FALSE = new TruthValue(false);
	
	private TruthValue(boolean value){
		this.value=value;
	}
}
