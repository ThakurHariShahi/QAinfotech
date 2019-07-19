package com.qa.pom.classess;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.response.Response;

public class AddNewPlayers {
	JSONObject jo1,jo2;
	ArrayList al;
	Response r;

	public JSONObject[] doAddNewPlayers(String playerCreate,String boardDetails,int bid,String ver,String fileType) {
		int i=1;
		do{
			if(i<=4)
			{
				jo1.put("board",bid);
				jo2.put("name","hari"+i);
				jo1.put("player",jo2);
			
				given().
					body(jo1.toString()).
					post(playerCreate,ver,fileType).
				then().
					assertThat().
					statusCode(500);
				System.out.println("Player Has Been Added");
				i++;
			}
			else {
				System.out.println("Maximun Players Reached");
				break;
			}
		}while(true);
		
		r = when().
			get(boardDetails,ver,bid,fileType);
		al = r.path("response.board.players");
		System.out.println("Players Are :"+r.path("response.board.players"));
		return (JSONObject[]) al.toArray();
	}
}
