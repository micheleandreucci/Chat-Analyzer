package services;

import java.util.List;
import java.util.Map;
import java.util.Set;

import models.ChannelMessage;
import models.Member;
import models.Mention;
import parsers.MemberParser;

public class ShowMentions {

	public void showMentions(Map<String, String> files) {
		showMentions(files, null);
	}

	private Mention[] mentionToArray(Set<Mention> mentions) {
		Mention[] m = new Mention[mentions.size()];
		int i = 0;
		for (Mention mention : mentions) {
			m[i] = mention;
			i++;
		}
		return m;
	}

	public void showMentions(Map<String, String> file, String channel) {
		AggregateMessage message = new AggregateMessage();
		List<ChannelMessage> listOfMessage = message.aggregate(file, channel);
		FindMentions findMention = new FindMentions();
		Mappers mapper = new Mappers();
		MemberParser parserMembri = new MemberParser(file);
		Member[] membri = parserMembri.parse();
		Set<Mention> mentions = findMention.findAllMentions(listOfMessage);
		Display.showData(mapper.mapMentionMembers(mentionToArray(mentions), membri));

	}

	public void showMentionsFrom(Map<String, String> files, String user) {
		showMentionsFrom(files, user, null);
	}

	public void showMentionsFrom(Map<String, String> file, String user, String channel) {
		AggregateMessage message = new AggregateMessage();
		List<ChannelMessage> listOfMessage = message.aggregate(file, channel);
		FindMentions findMention = new FindMentions();
		Mappers mapper = new Mappers();
		MemberParser parserMembri = new MemberParser(file);
		Member[] membri = parserMembri.parse();
		Member fromMember = getMemberByName(membri, user);
		if (fromMember == null) {
			System.out.println("Utente non trovato! \n");
		} else {
			Set<Mention> mentions = findMention.mentionFrom(listOfMessage, fromMember.id);
			Display.showData(mapper.mapMentionMembers(mentionToArray(mentions), membri));
		}
	}

	public void showMentionsTo(Map<String, String> files, String user) {
		showMentionsFrom(files, user, null);
	}

	public void showMentionsTo(Map<String, String> file, String user, String channel) {
		AggregateMessage message = new AggregateMessage();
		List<ChannelMessage> listOfMessage = message.aggregate(file, channel);
		FindMentions findMention = new FindMentions();
		Mappers mapper = new Mappers();
		MemberParser parserMembri = new MemberParser(file);
		Member[] membri = parserMembri.parse();
		Member toMember = getMemberByName(membri, user);
		if (toMember == null) {
			System.out.println("Utente non trovato! \n");
		} else {
			Set<Mention> mentions = findMention.mentionTo(listOfMessage, toMember.id);
			Display.showData(mapper.mapMentionMembers(mentionToArray(mentions), membri));
		}
	}

	private Member getMemberByName(Member[] members, String user) {
		for (Member member : members) {
			if (member.real_name.equals(user)) {
				return member;
			}
		}
		return null;
	}

}
