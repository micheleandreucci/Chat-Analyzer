package services;

import java.util.Map;

import models.Channel;
import parsers.ChannelParser;

public class ShowChannels {

	public void showChannels(Map<String, String> file){
		ChannelParser parserCanali = new ChannelParser(file);
		Channel[] canali = parserCanali.parse();
		Display.showData(canali);
	}
}
