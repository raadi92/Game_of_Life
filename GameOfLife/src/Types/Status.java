package Types;

public enum Status {
	ALIVE (true),
	DEAD (false);
	
	private boolean boolvalue;
	
	Status (boolean boolvalue){
		this.boolvalue = boolvalue;
	}

	public boolean boolvalue() {
		return boolvalue;
	}
	
}
