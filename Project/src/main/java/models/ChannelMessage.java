package models;

public class ChannelMessage extends Message{
	public String channelName;
	
	
	public ChannelMessage(Message message) {
		this.user=message.user;
		this.text=message.text;
	}

}
