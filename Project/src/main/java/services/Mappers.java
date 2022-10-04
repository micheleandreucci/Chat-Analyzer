package services;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import models.Channel;
import models.ChannelMembers;
import models.Member;
import models.Mention;

public class Mappers {

	public Mappers()
	{
		// TODO Auto-generated constructor stub
	}
	
	
	public List<ChannelMembers> mapChannelMembers(Channel[] channel, Member[] member)
	{
		List<ChannelMembers> listMembers = new LinkedList<>();
		Map<String, Member> mapMember = mapMember(member);
		for(int i=0 ; i<channel.length; i++) 
		{
			ChannelMembers channelMember = new ChannelMembers();
			channelMember.name=channel[i].name;
			channelMember.members=loadMember(channel[i],mapMember);
			listMembers.add(channelMember);
		}
		return listMembers;
	}
	
	
	public List<Mention> mapMentionMembers(Mention[] mentions, Member[] member){
		List<Mention> listMention = new LinkedList<>();
		Map<String, Member> mapMember = mapMember(member);
		for(int i=0; i<mentions.length; i++) {
			Mention mention=new Mention();
			mention.from=mapMember.get(mentions[i].from).real_name;
			mention.to=mapMember.get(mentions[i].to).real_name;
			listMention.add(mention);
		}
		return listMention;
	}
	
	
	private List<Member> loadMember(Channel channel, Map<String, Member> mapMember) 
	{
		List<Member> member = new LinkedList<>();
		for(int i=0; i<channel.members.length; i++) {
			Member m = mapMember.get(channel.members[i]);
			member.add(m);
		}
		return member;
	}


	private Map<String , Member> mapMember(Member[] member)
	{
		Map<String, Member> mapMember = new HashMap<>();///hashmap inizializza mappa
		for(int i=0 ; i < member.length; i++) 
		{
			mapMember.put(member[i].id ,member[i]);
		}
		return mapMember;
	}
	
	

}
