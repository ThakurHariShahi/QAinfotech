package qainfotech.SnlRestFul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetAndPost {
String GetMethod(URL url ) throws IOException {
		
		HttpURLConnection con=(HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		//con.setRequestProperty("userID", "abcd");
		String readLine;
		int responseCode = con.getResponseCode();
		StringBuffer response = null;
	    if (responseCode == HttpURLConnection.HTTP_OK) {
	        BufferedReader in = new BufferedReader(
	            new InputStreamReader(con.getInputStream()));
	        response = new StringBuffer();
	        while ((readLine = in .readLine()) != null) {
	            response.append(readLine);
	        } in .close();
	        System.out.println(response.toString());
	    }
	    else {
	        System.out.println("GET NOT WORKED");
	    }
	    return response.toString();
	    
	}
	void PostMethod(URL url,String Data) throws IOException {
		//final String Data = "{\n" + "\"userId\": 101,\r\n" +"    \"id\": 101,\r\n" +"    \"title\": \"Test Title\",\r\n" +"    \"body\": \"Test Body\"" + "\n}";
		    
		URL obj = new URL("https://jsonplaceholder.typicode.com/posts");
		HttpURLConnection pCon = (HttpURLConnection) obj.openConnection();
		pCon.setRequestMethod("POST");
		pCon.setRequestProperty("userId", "abcd");
		pCon.setRequestProperty("Content-Type", "application/json");
		pCon.setDoOutput(true);
		OutputStream os =(OutputStream) pCon.getOutputStream();
		os.write(Data.getBytes());
		os.flush();
		os.close();
		int responseCode = pCon.getResponseCode();
		System.out.println(pCon.getResponseMessage());
		if (responseCode == HttpURLConnection.HTTP_CREATED) {
			System.out.println("POST WORKED");
		    } 
		else {
			System.out.println("POST NOT WORKED");
		}
		   
	}
}
