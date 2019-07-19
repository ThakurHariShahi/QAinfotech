package com.qa.pom.scripts;

import java.io.FileNotFoundException;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.qa.pom.Objects.PageObjects;
import com.qa.pom.classess.CheckForValidNoOfPlayers;

public class SnlRest {
	PageObjects PageObject;
	String ver,fileType;
	String boardCompleteDetails,boardCreate,boardDetails,playerCreate,playerDetails,playerMove;
	
	int bid;
	JSONObject[] o;
  @Test
  public void Test() throws FileNotFoundException {
	  
	  boardCompleteDetails = PageObject.baseUrl.getBaseUrl("boardCompleteDetails");
	  boardCreate = PageObject.baseUrl.getBaseUrl("boardCreate");
	  boardDetails = PageObject.baseUrl.getBaseUrl("boardDetails");
	  playerCreate = PageObject.baseUrl.getBaseUrl("playerCreate");
	  playerDetails = PageObject.baseUrl.getBaseUrl("playerDetails");
	  playerMove = PageObject.baseUrl.getBaseUrl("playerMove");
	  
	  bid = PageObject.bid.getBoardId(boardCreate,ver,fileType);
	  o = PageObject.addNewPlayer.doAddNewPlayers(playerCreate,boardDetails,bid,ver,fileType);
	  PageObject.checkForValidNoOfPlayer.checkForValidNoOfPlayers(boardDetails,bid,ver,fileType);
	  PageObject.deletePlayer.deletePlayers(boardDetails,bid,ver,fileType,o[0].get("id"));


  }
}
