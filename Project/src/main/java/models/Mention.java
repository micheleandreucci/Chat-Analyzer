package models;

public class Mention {
	public String from;
	public String to;
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Mention)) {
			return false;
		}
		Mention mention = (Mention) obj;
		return this.from.equals(mention.from) && this.to.equals(mention.to);
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		return "(From: " + from + ", To: " + to + ")";
	}


	@Override
	public int hashCode() {
		return this.from.hashCode()+this.to.hashCode();
	}
	
	

}
