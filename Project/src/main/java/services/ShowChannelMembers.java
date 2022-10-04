package services;

import java.util.List;
import java.util.Map;

import models.Channel;
import models.ChannelMembers;
import models.Member;
import parsers.ChannelParser;
import parsers.MemberParser;

public class ShowChannelMembers {

	public void showChannelMembers(Map<String, String> file)
	{
		ChannelParser parserCanali = new ChannelParser(file);
		MemberParser parserMembri = new MemberParser(file);
		Member[] membri = parserMembri.parse();
		Channel[] canali = parserCanali.parse();
		Mappers tutto = new Mappers();
		List<ChannelMembers> listaDiCanali = tutto.mapChannelMembers(canali, membri);
		Display.showData(listaDiCanali);
	}
}