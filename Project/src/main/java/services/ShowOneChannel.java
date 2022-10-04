package services;

import java.util.List;
import java.util.Map;

import models.Channel;
import models.ChannelMembers;
import models.Member;
import parsers.ChannelParser;
import parsers.MemberParser;
import java.lang.String;


public class ShowOneChannel {

	public void showOneChannel(Map<String, String> file, String search ){

		ChannelParser parserCanali = new ChannelParser(file);
		MemberParser parserMembri = new MemberParser(file);
		Member[] membri = parserMembri.parse();
		Channel[] canali = parserCanali.parse();
		Mappers tutto = new Mappers();
		List<ChannelMembers> listaDiCanali = tutto.mapChannelMembers(canali, membri);
		for(int i=0; i<listaDiCanali.size(); i++ ) {
			if(search.equals(listaDiCanali.get(i).name)){
				Display.showData(listaDiCanali.get(i));
				break;
			}
		}
		
	}
}