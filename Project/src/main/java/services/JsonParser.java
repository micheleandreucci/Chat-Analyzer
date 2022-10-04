package services;

import com.google.gson.Gson;

public class JsonParser {
	private Gson gson;

	public JsonParser() {
		this.gson = new Gson();
	}
	
	
	public <T> T parser(String json, Class <T> type){
		return this.gson.fromJson(json, type);
	}
}
