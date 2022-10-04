package services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import models.ChannelMessage;
import models.Message;
import parsers.MessageParser;

public class AggregateMessage {
	private String[] excludedFiles = new String[] {"channels.json","users.json","integration_logs.json" };
	public AggregateMessage() {
		// TODO Auto-generated constructor stub
	}
	public List<String> mapFilesReturn(Map<String, String> map) {
		List<String> path = new ArrayList<>();
		for(String fileName: map.keySet()) {
			if(!Arrays.asList(excludedFiles).contains(fileName)) {
				path.add(fileName);
			}
		}
		
		return path;
	}
	public List<ChannelMessage> aggregate(Map<String, String> files ){
		return aggregate(files,null);
	}
	
	public List<ChannelMessage> aggregate(Map<String, String> files, String channel ) {
		List<String> listFiles=mapFilesReturn(files);
		List<ChannelMessage> message = new LinkedList<>();
		for(String fileName: listFiles) {
			if(!fileName.endsWith("/")) {
				if(channel==null || fileName.startsWith(channel+"/")) {
					MessageParser parser = new MessageParser(files, fileName);
					message.addAll(messageEnhancer(parser.parse(),getChannelName(fileName)));
				}
			}
		}
		return message;
	}
	
	private String getChannelName(String fileName) {
		return fileName.substring(0, fileName.indexOf("/"));
	}
	
	private List<ChannelMessage> messageEnhancer(Message[] messages, String channelName){
		List<ChannelMessage> listChannelM = new ArrayList<>();
		for(Message message:messages) {
			ChannelMessage cm = new ChannelMessage(message);
			cm.channelName=channelName;
			listChannelM.add(cm);
		}
		return listChannelM;
	}
	
}
