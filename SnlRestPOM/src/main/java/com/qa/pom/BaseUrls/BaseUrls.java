package com.qa.pom.BaseUrls;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BaseUrls {
	int i = 0;
	String data;

	public String read() {
		StringBuffer sb = new StringBuffer();
		File f = new File("BaseUrls.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String s;

			while ((s = br.readLine()) != null) {
				sb.append(s);
				sb.append("->");
			}

		} catch (IOException e) {
			System.out.println(e);
		}

		return sb.toString();
	}

	public String getBaseUrl(String name) throws FileNotFoundException {
		if (i == 0) {
			data = read();
			i++;
		}
		String[] dataArray = data.split("->");
		String locatorPath = "";
		String locatorType = "";
		for (int i = 0; i < dataArray.length; i++) {
			if (dataArray[i].split(": ")[0].equalsIgnoreCase(name)) {
				locatorType = dataArray[i].split(": ")[1];
				locatorPath = dataArray[i].split(": ")[2];
				// System.out.println(locatorType);
				// System.out.println(locatorPath);
				break;
			}
		}
		return  "";
	}
}