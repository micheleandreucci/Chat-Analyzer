package controller;

import java.util.Map;
import services.ShowChannelMembers;
import services.ShowChannels;
import services.ShowMembers;
import services.ShowMentions;
import services.ShowOneChannel;
import services.OpenFile;

public class ApplicationController {

	private MenuController menu;

	public ApplicationController() {
		menu = new MenuController();
	}

	public void start(String[] args) {

		if (args[0].equals("/help")) {
			menu.showHelp();
		} else {
			OpenFile zip = new OpenFile();
			Map<String, String> file = zip.openFile(args[0]);
			String scelta = args[1];
			switch (scelta) {
			case "/members":
				ShowMembers members = new ShowMembers();
				members.showMembers(file);
				break;
			case "/channels":
				ShowChannels channels = new ShowChannels();
				channels.showChannels(file);
				break;
			case "/showall":
				ShowChannelMembers channelMembers = new ShowChannelMembers();
				channelMembers.showChannelMembers(file);
				break;
			case "/search":
				ShowOneChannel oneChannel = new ShowOneChannel();
				oneChannel.showOneChannel(file, args[2]);
				break;
			case "/showAllMentions":
				ShowMentions allMentions = new ShowMentions();
				allMentions.showMentions(file);
				break;
			case "/showMentions":
				ShowMentions mentions = new ShowMentions();
				mentions.showMentions(file, args[2]);
				break;
			case "/showMentionsTo":
				ShowMentions mentionsTo = new ShowMentions();
				if (args.length == 4) {
					mentionsTo.showMentionsTo(file, args[2], args[3]);
				} else {
					mentionsTo.showMentionsTo(file, args[2]);
				}
				break;
			case "/showMentionsFrom":
				ShowMentions mentionsFrom = new ShowMentions();
				if (args.length == 4) {
					mentionsFrom.showMentionsFrom(file, args[2], args[3]);
				} else {
					mentionsFrom.showMentionsFrom(file, args[2]);
				}
				break;
			default:
				System.out.println("Comando errato");
				menu.showHelp();
			}

		}

	}

}
