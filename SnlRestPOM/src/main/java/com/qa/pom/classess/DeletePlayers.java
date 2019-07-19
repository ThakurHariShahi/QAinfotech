package com.qa.pom.classess;

import static io.restassured.RestAssured.when;

import io.restassured.response.Response;

public class DeletePlayers {
	Response r;
	public void deletePlayers(String boardDetails,int bid,String ver,String fileType,Object pid) {
		 r = when().
				 get(boardDetails,ver,bid,fileType);
		 System.out.println("Players Before Deletion: "+r.path("response.board.players.name"));
		 when().
		 	delete(boardDetails,ver,(Integer)pid,fileType).
		 then().
		 	assertThat().
		 		statusCode(500);
		 r = when().
				 get(boardDetails,ver,bid,fileType);
		 
		 System.out.println("Players After Deletion: "+r.path("response.board.players.name"));
	}
}
