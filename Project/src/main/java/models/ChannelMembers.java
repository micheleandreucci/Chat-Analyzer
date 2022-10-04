package models;

import java.util.List;

public class ChannelMembers {
	public String name;
	public List<Member> members;
	@Override
	public String toString() {
		String stringa=name;
		for(int i=0; i<members.size(); i++) {
			stringa+="\n - "+members.get(i).real_name;
		}
		
		// TODO Auto-generated method stub
		return stringa;
	}
	
	
	
	
	
}
