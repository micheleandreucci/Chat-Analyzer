package parsers;

import java.util.Map;

import models.Channel;


public class ChannelParser extends BaseParser<Channel[]>{
	


	public ChannelParser(Map<String, String> files) {
		super(files.get("channels.json"), Channel[].class);
	}

}
