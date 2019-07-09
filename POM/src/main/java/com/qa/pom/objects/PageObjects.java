package com.qa.pom.objects;

import org.openqa.selenium.WebDriver;

import com.qa.pom.classes.BasicCookiePage;
import com.qa.pom.classes.BasicDragPage;
import com.qa.pom.classes.BasicFrameDungeonPage;
import com.qa.pom.classes.BasicGridGatePage;
import com.qa.pom.classes.BasicWindowsPage;
import com.qa.pom.classes.BasicWindowsPopupPage;
import com.qa.pom.classes.TatocPage;

public class PageObjects {
	public TatocPage TatocPage_object;
	public BasicGridGatePage BasicGridGatePage_object;
	public BasicFrameDungeonPage BasicFrameDungeonPage_object;
	public BasicDragPage BasicDragPage_object;
	public BasicWindowsPage BasicWindowsPage_object;
	public BasicWindowsPopupPage BasicWindowsPopupPage_object;
	public BasicCookiePage BasicCookiePage_object;
	
	public PageObjects(WebDriver driver)
	{
		TatocPage_object  = new TatocPage(driver);
		BasicGridGatePage_object = new BasicGridGatePage(driver);
		BasicFrameDungeonPage_object = new BasicFrameDungeonPage(driver);
		BasicDragPage_object = new BasicDragPage(driver);
		BasicWindowsPage_object = new BasicWindowsPage(driver);
		BasicWindowsPopupPage_object = new BasicWindowsPopupPage(driver);
		BasicCookiePage_object = new BasicCookiePage(driver);
	}
}
