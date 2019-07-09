package qainfotech.SnlRestFul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
public class App 
{
void GetMethod() throws IOException {
		
		URL url=new URL("https://jsonplaceholder.typicode.com/posts/100");
		HttpURLConnection con=(HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("userID", "abcd");
		String readLine;
		int responseCode = con.getResponseCode();
	    if (responseCode == con.HTTP_OK) {
	        BufferedReader in = new BufferedReader(
	            new InputStreamReader(con.getInputStream()));
	        StringBuffer response = new StringBuffer();
	        while ((readLine = in .readLine()) != null) {
	            response.append(readLine);
	        } in .close();
	        System.out.println(response.toString());
	    }
	    else {
	        System.out.println("GET NOT WORKED");
	    }
	    
	}
	void PostMethod() throws IOException {
		final String Data = "{\n" + "\"userId\": 101,\r\n" +"    \"id\": 101,\r\n" +"    \"title\": \"Test Title\",\r\n" +"    \"body\": \"Test Body\"" + "\n}";
		    
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
			BufferedReader in = new BufferedReader(new InputStreamReader(
		    pCon.getInputStream()));
		    String inputLine;
		    StringBuffer response = new StringBuffer();
		    while ((inputLine = in .readLine()) != null) {
		    		response.append(inputLine);
		    }
		    in .close();
		    System.out.println(response.toString());
		    } 
		else {
			System.out.println("POST NOT WORKED");
		}
		   
	}
	public static void main(String args[]) throws IOException {
		System.out.println("enter 1 for get and 2 for post");
		Scanner sc= new Scanner(System.in);
		int a= sc.nextInt();
		App h=new App();
		if(a==1)
			h.GetMethod();
		else if(a==2)
			h.PostMethod();
		else
			System.out.println("Enter Valid Entry");
		sc.close();
	}
}
