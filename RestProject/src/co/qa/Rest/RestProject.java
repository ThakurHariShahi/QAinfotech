package co.qa.Rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class RestProject {
	String GetMethod(String url1) throws IOException {
		
		URL url=new URL(url1);
		HttpURLConnection con=(HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		//con.setRequestProperty("userID", "abcd");
		String readLine;
		StringBuffer response=null;
		int responseCode = con.getResponseCode();
	    if (responseCode == HttpURLConnection.HTTP_OK) {
	        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	        response = new StringBuffer();
	        while ((readLine = in .readLine()) != null) {
	            response.append(readLine);
	        } 
	        in .close();
	        System.out.println("Success");
	    }
	    else {
	        System.out.println("GET Fail");
	    }
	    return response.toString();
	}
	void PostMethod(String url) throws IOException {
		URL obj = new URL(url);
		HttpURLConnection pCon = (HttpURLConnection) obj.openConnection();
		pCon.setRequestMethod("POST");
		pCon.setRequestProperty("Content-Type", "application/json");
		pCon.setDoOutput(true);
		int responseCode = pCon.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_CREATED) {
		    System.out.println("Success");
		    } 
		else {
			System.out.println("Fail");
		}
		   
	}
}