package controller;



public class MenuController {

	public void showHelp(){
		System.out.println("Per avviare il programma digitare il percorso del file da aprire e un comando ");
		System.out.println("\nPer visualizzare la lista dei membri digitare /members ");
		System.out.println("Per visualizzare la lista dei canali digitare /channels ");
		System.out.println("Per visualizzare la lista dei canali e i loro membri appartenti digitare /showall ");
		System.out.println("Per visualizzare i membri di un solo channell digitare /search <nome_channel> ");
		System.out.println("Per visualizzare l'elenco dei @mention digitare /showAllMentions"); 
	    System.out.println("Per visualizzare l'elenco dei @mention di un canale digitare /showMentions <none_channel> "); 
		System.out.println("Per visualizzare l'elenco dei @mention che partono da un membro digitare /showMentionsFrom <nome_user> ");
		System.out.println("Per visualizzare l'elenco dei @mention che partono da un membro in un channel digitare /showMentionsFrom <nome_user> <nome_channel>");
        System.out.println("Per visualizzare l'elenco dei @mention ricevuti da un membro digitare /showMentionsTo <nome_user> "); 
        System.out.println("Per visualizzare l'elenco dei @mention ricevuti da un membro in un channel digitare /showMentionsTo <nome_user> <nome_channel>"); 
        System.out.println("Per visualizzare l'help digitare /help");
	}
	 
	
	
}
