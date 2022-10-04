package services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import models.ChannelMessage;
import models.Mention;
import models.Message;

public class FindMentions {
	private Pattern pattern;

	public FindMentions() {
		this.pattern = Pattern.compile("<@([A-Z0-9]{9})>");
	}

	public Set<Mention> findAllMentions(List<ChannelMessage> messages) {
		Set<Mention> mention = new HashSet<>();
		for (Message message : messages) {
			if (message.user != null) {
				mention.addAll(findMentionInMessage(message));
			}

		}
		return mention;

	}

	private List<Mention> findMentionInMessage(Message message) {
		List<Mention> mention = new ArrayList<>();
		Matcher matcher = pattern.matcher(message.text);
		while (matcher.find()) {
			Mention m = new Mention();
			m.from = message.user;
			m.to = matcher.group(1);
			if (!(m.from.equals(m.to))) {
				mention.add(m);
			}
		}
		return mention;

	}


	public Set<Mention> mentionTo(List<ChannelMessage> message, String id) {
		Set<Mention> mentions = findAllMentions(message);
		Set<Mention> mentionToUser = new HashSet<>();
		for (Mention mention : mentions) {
			if (mention.to.equals(id)) {
				mentionToUser.add(mention);
			}
		}
		return mentionToUser;
  }
  
  
	public Set<Mention> mentionFrom(List<ChannelMessage> message, String id) {
		Set<Mention> mentions = findAllMentions(message);
		Set<Mention> mentionFromUser = new HashSet<>();
		for (Mention mention : mentions) {
			if (mention.from.equals(id)) {
				mentionFromUser.add(mention);
			}
		}
		return mentionFromUser;
	}
}
