package com.example.reportingcrb.control;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class FetchData {

	public int test() {

		FirefoxProfile myprofile = new FirefoxProfile();
		myprofile.setPreference("browser.download.folderList", 2);
		myprofile.setPreference("browser.download.manager.showWhenStarting", false);
		myprofile.setPreference("browser.download.dir", "C:\\selenium");
		myprofile.setPreference("browser.helperApps.neverAsk.openFile",
				"application/msword, application/csv, application/ris, text/csv, image/png, application/pdf, text/html, text/plain, application/zip, application/x-zip, application/x-zip-compressed, application/download, application/octet-stream");
		myprofile.setPreference("browser.helperApps.neverAsk.saveToDisk",
				"application/msword, application/csv, application/ris, text/csv, image/png, application/pdf, text/html, text/plain, application/zip, application/x-zip, application/x-zip-compressed, application/download, application/octet-stream");
		myprofile.setPreference("browser.helperApps.alwaysAsk.force", false);
		myprofile.setPreference("browser.download.manager.showAlertOnComplete", false);
		myprofile.setPreference("browser.download.manager.closeWhenDone", false);

		WebDriver driver = new FirefoxDriver();
		// Wait For Page To Load
		// Put a Implicit wait, this means that any search for elements on the
		// page
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Navigate to URL
		driver.get("https://fh-dortmund.sciebo.de/");
		// Maximize the window.
		// Enter UserName
		driver.findElement(By.id("user")).sendKeys("datak001@fh-dortmund.de");
		// Enter Password
		driver.findElement(By.id("password")).sendKeys("Romario54321");
		// Click on 'Sign In' button
		driver.findElement(By.id("submit")).click();
		driver.findElement(By.id("select-files-15651661")).click();
		return 10;
	}

}
