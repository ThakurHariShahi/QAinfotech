package com.qa.pom.classess;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.when;

import java.io.FileNotFoundException;

import io.restassured.response.Response;

public class BoardId {
	Response r; 
	int Bid;
	public int getBoardId(String BaseUrl,String ver,String fileType ) throws FileNotFoundException {
		r = when().
				get(BaseUrl,ver,fileType);
		System.out.println("Complete Board : "+r.asString());
		Bid = r.path("response.board.id",fileType);
		return Bid;
	}
}
