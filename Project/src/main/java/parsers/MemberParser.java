package parsers;

import java.util.Map;

import models.Member;

public class MemberParser extends BaseParser<Member[]>{
	

	public MemberParser(Map<String, String> files) 
	{
		super(files.get("users.json"), Member[].class);
	}
	
	

}
