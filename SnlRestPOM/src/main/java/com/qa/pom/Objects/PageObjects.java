package com.qa.pom.Objects;

import com.qa.pom.BaseUrls.BaseUrls;
import com.qa.pom.classess.BoardId;
import com.qa.pom.classess.CheckForValidNoOfPlayers;
import com.qa.pom.classess.DeletePlayers;
import com.qa.pom.classess.AddNewPlayers;

public class PageObjects {
	public BaseUrls baseUrl;
	
	public BoardId bid;
	public AddNewPlayers addNewPlayer;
	public CheckForValidNoOfPlayers checkForValidNoOfPlayer;
	public DeletePlayers deletePlayer;
	
	public PageObjects() {
		baseUrl = new BaseUrls();
		bid = new BoardId();
		addNewPlayer = new AddNewPlayers();
		checkForValidNoOfPlayer = new CheckForValidNoOfPlayers();
		deletePlayer = new DeletePlayers();
	}
}
