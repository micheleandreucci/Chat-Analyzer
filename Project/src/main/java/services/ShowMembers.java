package services;

import java.util.Map;

import models.Member;
import parsers.MemberParser;

public class ShowMembers 
{

	public void showMembers(Map<String, String> file)
	{
		MemberParser parserMembri = new MemberParser(file);
		Member[] membri = parserMembri.parse();
		Display.showData(membri);
	}

}
