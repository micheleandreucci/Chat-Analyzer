package parsers;

import java.util.Map;

import models.Message;

public class MessageParser extends BaseParser<Message[]>{

	public MessageParser(Map<String, String> files, String path) {
		
		
		super(files.get(path),Message[].class);
	}

}
