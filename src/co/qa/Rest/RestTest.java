package co.qa.Rest;

import java.io.IOException;

import org.testng.annotations.Test;

public class RestTest {
  @Test
  public void a() throws IOException {
	  RestProject rp=new RestProject();
	  String str="http://10.0.1.86/snl/rest/v1/board/new.json";
	  rp.GetMethod(str);
	  
  }
}
