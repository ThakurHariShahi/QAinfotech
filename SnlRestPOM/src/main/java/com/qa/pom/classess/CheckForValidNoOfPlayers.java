package com.qa.pom.classess;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasSize;

import java.util.ArrayList;

import io.restassured.response.Response;

public class CheckForValidNoOfPlayers {
	Response r;
	ArrayList al;
	public void checkForValidNoOfPlayers(String boardDetails,int bid,String ver,String fileType) {
		when().
	     get(boardDetails,ver,bid,fileType).
	   then().
	     assertThat().
	     body("response.board.players.id",hasSize(4));
	   r = when().
			 get(boardDetails,ver,bid,fileType);
	   
	   al = r.path("response.board.players");
	   System.out.println("Valid Players: "+r.path("response.board.players",".json"));
	}

}
