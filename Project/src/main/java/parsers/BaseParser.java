package parsers;

import services.JsonParser;

public abstract class BaseParser <T> {
	
	String json;
	Class<T> type;
	
	private JsonParser parser = new JsonParser();
	
	public BaseParser(String json, Class <T> type) {
		this.json=json;
		this.type=type;
		
	}
	
	public T parse() {
		return parser.parser(json, type);
	}

}
