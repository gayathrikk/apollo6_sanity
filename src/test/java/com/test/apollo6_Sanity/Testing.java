package com.test.apollo6_Sanity;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Testing {
	 private RemoteWebDriver driver;
		
		@BeforeTest
		
		public void setup() throws MalformedURLException 
		{
			
			  DesiredCapabilities dc = DesiredCapabilities.chrome();
		        URL url = new URL("http://172.20.23.7:5555/wd/hub");
		        driver = new RemoteWebDriver(url, dc);
		
		       
		}
		//@Parameters("URL")
		@Test(priority=1)
		//public void login(@Optional("defaultURL") String URL) throws InterruptedException
		public void login()throws InterruptedException
		{
			//driver.get(URL);
			driver.get("https://apollo2.humanbrain.in/viewer/annotation/portal");
			driver.manage().window().maximize();
	        String currentURL = driver.getCurrentUrl();
	        System.out.println("Current URL: " + currentURL);
			WebDriverWait wait = new WebDriverWait(driver, 10);
	    	driver.switchTo().defaultContent(); // Switch back to default content
	    	WebElement viewerElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Viewer']")));
	    	if (viewerElement.isEnabled() && viewerElement.isDisplayed()) {
	    	    viewerElement.click();
	    	    System.out.println("Viewer icon is clicked");
	    	} else {
	    	    System.out.println("Viewer icon is not clickable");
	    	}
	    	checkConsoleLog();
	
	        String parentWindow = driver.getWindowHandle();
	        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Log In ']")));
	        if (loginButton != null) {
	            loginButton.click();
	            System.out.println("Login button clicked successfully.");
	        } else {
	            System.out.println("Login button is not clicked.");
	        }
	        checkConsoleLog();
		  wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		  Set<String> allWindows = driver.getWindowHandles();
	        for (String window : allWindows) {
	            if (!window.equals(parentWindow)) {
	                driver.switchTo().window(window);
	                break;
	            }
	        }
	        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
	        if (emailInput != null && emailInput.isDisplayed()) {
	            emailInput.sendKeys("teamsoftware457@gmail.com");
	            System.out.println("Email was entered successfully.");
	        } else {
	           System.out.println("Email was not entered.");
	        }
	        checkConsoleLog();
	
	        WebElement nextButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
	        if (nextButton1 != null) {
	            nextButton1.click();
	            System.out.println("Next button 1 is clicked.");
	        } else {
	            System.out.println("Next button 1 is not clicked.");
	        }
	        checkConsoleLog();
	        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Enter your password']")));
	        passwordInput.sendKeys("Health#123");
	        if (passwordInput.getAttribute("value").equals("Health#123")) {
	            System.out.println("Password was entered successfully.");
	        } else {
	            System.out.println("Password was not entered.");
	        }
	        checkConsoleLog();
	        
	        WebElement nextButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
	        if (nextButton2 != null) {
	            nextButton2.click();
	            System.out.println("Next button 2 is clicked.");
	        } else {
	            System.out.println("Next button 2 is not clicked.");
	        }
	        checkConsoleLog();
	
	        driver.switchTo().window(parentWindow);
	        System.out.println("Login successfully");
	        checkConsoleLog();
	        
	        System.out.println("************************Login validation done***********************");
		        
		}
		
		@Test(priority=2)
		public void series_set() throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait(driver, 30); 
			driver.switchTo().defaultContent();
	
			
	    	 try {
	    		    WebElement Human = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='cdk-table nb-tree-grid']//tr[5]")));
	    		    Human.click();
	    		    System.out.println("Human brain clicked successfully.");
	    		    Thread.sleep(2000);
	    		} catch (Exception e) {
	    		    System.out.println("Human Brain not clicked: " + e.getMessage());
	    		}
	    	 checkConsoleLog();
	    	 
	    	 try {
	    		    WebElement Brain = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='cdk-table nb-tree-grid']//tr[6]//td[2]")));
	    		    Brain.click();
	    		    System.out.println(" Brain clicked successfully.");
	    		    Thread.sleep(2000);
	    		} catch (Exception e) {
	    		    System.out.println("Brain not clicked: " + e.getMessage());
	    		}
	    	 checkConsoleLog();
	    	 
	    	 try {
	 		    WebElement MTB_10 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='cdk-table nb-tree-grid']//tr[11]//td[3]")));
	 		    MTB_10.click();
	 		    System.out.println("Human-44 clicked successfully.");
	 		    Thread.sleep(2000);
	 		} catch (Exception e) {
	 		    System.out.println("Human-44 not clicked: " + e.getMessage());
	 		}
	    	 checkConsoleLog();
	    	
	    	 System.out.println("************************************Series set validation done********************************");
	
	    	 
		}
		
		 @Test(priority=3)
		    public void HD() throws InterruptedException
		    {
		    	WebDriverWait wait = new WebDriverWait(driver, 10);
		    	driver.switchTo().defaultContent(); // Switch back to default content
		    	WebElement section = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[text()='1261'])[1]")));
		    	if (section.isEnabled() && section.isDisplayed()) {
		    	    section.click();
		    	    System.out.println("section is selected");
		    	} else {
		    	    System.out.println("section is not selected");
		    	}
		    	Thread.sleep(3000);
		    	checkConsoleLog();
		    
		    	WebElement hd = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='View High Resolution Image']")));
		    	if (hd.isEnabled() && hd.isDisplayed()) {
		    	    hd.click();
		    	    System.out.println("High resolution page is opened");
		    	} else {
		    	    System.out.println("High resolutin page is not opened");
		    	}
		    	Thread.sleep(5000);
		    	checkConsoleLog();
		    
		    	WebElement back = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='back']")));
		     	if (back.isEnabled() && back.isDisplayed()) {
		     	    back.click();
		     	    System.out.println("Back to viewer page");
		     	} else {
		     	    System.out.println("Back to viewer page");
		     	}
		     	Thread.sleep(6000);
		     	checkConsoleLog();
		     	HD_API();
		     	
		     	 System.out.println("********************************Hd page validation done*****************************");
		    	
		    }
		    @Test(priority=4)
		    public void Atlas_Editor() throws InterruptedException
		    {
		    	WebDriverWait wait = new WebDriverWait(driver, 10);
		    	driver.switchTo().defaultContent(); // Switch back to default content
		    	WebElement series = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='NISSL']")));
		    	    if (series.isEnabled() && series.isDisplayed()) {
		        	    series.click();
		        	    System.out.println("series is selected");
		        	} else {
		        	    System.out.println("series is not selected");
		        	}
		    	WebElement section = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[text()='1261'])[1]")));
		    	if (section.isEnabled() && section.isDisplayed()) {
		    	    section.click();
		    	    System.out.println("section is selected");
		    	} else {
		    	    System.out.println("section is not selected");
		    	}
		    	Thread.sleep(3000);
		    	checkConsoleLog();
		    
		    	WebElement atlas = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Atlas Editor']")));
		    	if (atlas.isEnabled() && atlas.isDisplayed()) {
		    	    atlas.click();
		    	    System.out.println("Atlas Editor page is opened");
		    	} else {
		    	    System.out.println("Atlas Editor page is not opened");
		    	}
		    	Thread.sleep(5000);
		    	checkConsoleLog();
		    	
		    	WebElement back = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Back']")));
		     	if (back.isEnabled() && back.isDisplayed()) {
		     	    back.click();
		     	    System.out.println("Back to viewer page");
		     	} else {
		     	    System.out.println("Back to viewer page");
		     	}
		     	Thread.sleep(5000);
		     	checkConsoleLog();
		     	Atlas_API();
		     	
		     	System.out.println("*******************************Atlas editor validation done*****************************");
		     	
		    	
		    }
		    
		    @Test(priority=5)
		    public void Cell_annotation() throws InterruptedException
		    {
		    	WebDriverWait wait = new WebDriverWait(driver, 10);
		    	driver.switchTo().defaultContent(); // Switch back to default content
		    	WebElement series = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='NISSL']")));
			    if (series.isEnabled() && series.isDisplayed()) {
		    	    series.click();
		    	    System.out.println("series is selected");
		    	} else {
		    	    System.out.println("series is not selected");
		    	}
		    	WebElement section = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[text()='1261'])[1]")));
		    	if (section.isEnabled() && section.isDisplayed()) {
		    	    section.click();
		    	    System.out.println("section is selected");
		    	} else {
		    	    System.out.println("section is not selected");
		    	}
		    	Thread.sleep(3000);
		    	checkConsoleLog();
		    
		    	WebElement atlas = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Cell Annotation']")));
		    	if (atlas.isEnabled() && atlas.isDisplayed()) {
		    	    atlas.click();
		    	    System.out.println("Cell annotation page is opened");
		    	} else {
		    	    System.out.println("Cell annotation page is not opened");
		    	}
		    	Thread.sleep(5000);
		    	checkConsoleLog();
		    	
		    	WebElement back = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Back']")));
		     	if (back.isEnabled() && back.isDisplayed()) {
		     	    back.click();
		     	    System.out.println("Back to viewer page");
		     	} else {
		     	    System.out.println("Back to viewer page");
		     	}
		     	Thread.sleep(5000);
		     	checkConsoleLog();
		     	Cell_API();
		     	
		     	System.out.println("*******************************Cell annotation validation done*****************************");
		    	
		    	
		    }
		    
		    @Test(priority=6)
		    public void Manual_Registration() throws InterruptedException
		    {
		    	WebDriverWait wait = new WebDriverWait(driver, 10);
		    	driver.switchTo().defaultContent(); // Switch back to default content
		    	WebElement series = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='NISSL']")));
			    if (series.isEnabled() && series.isDisplayed()) {
		    	    series.click();
		    	    System.out.println("series is selected");
		    	} else {
		    	    System.out.println("series is not selected");
		    	}
		    	WebElement section = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[text()='1261'])[1]")));
		    	if (section.isEnabled() && section.isDisplayed()) {
		    	    section.click();
		    	    System.out.println("section is selected");
		    	} else {
		    	    System.out.println("section is not selected");
		    	}
		    	Thread.sleep(3000);
		    	checkConsoleLog();
		    
		    	WebElement atlas = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Manual Registration']")));
		    	if (atlas.isEnabled() && atlas.isDisplayed()) {
		    	    atlas.click();
		    	    System.out.println("Manual Registration page is opened");
		    	} else {
		    	    System.out.println("Manual Registration page is not opened");
		    	}
		    	Thread.sleep(8000);
		    	checkConsoleLog();
		    	
		    	WebElement back = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Back']")));
		     	if (back.isEnabled() && back.isDisplayed()) {
		     	    back.click();
		     	    System.out.println("Back to viewer page");
		     	} else {
		     	    System.out.println("Back to viewer page");
		     	}
		     	Thread.sleep(5000);
		     	checkConsoleLog();
		     	Reg_API();
		     	
		     	System.out.println("*******************************Manual Registration validation done*****************************");
		    	
		    }
		private void checkConsoleLog() {
	        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
	        List<LogEntry> logs = logEntries.filter(Level.SEVERE);
	
	        int severeLogCount = logs.size();
	        System.out.println("Number of SEVERE-level logs: " + severeLogCount);
	
	        for (LogEntry log : logs) {
	            System.out.println("Level is : \n" + log.getLevel());
	            System.out.println("Message is : \n" + log.getMessage());
	        }
	        }
		 private void HD_API()
		    {
		    	//iipsrv
		    	Response response1 = RestAssured.get("https://ap3.humanbrain.in/iipsrv/fcgi-bin/iipsrv.fcgi?FIF=/apollo6/storageIIT/humanbrain/analytics/44/NISL/B_44_HB1RC-SL_421-ST_NISL-SE_1261_compressed.jp2&WID=1024&GAM=1.4&MINMAX=1:0,255&MINMAX=2:0,255&MINMAX=3:0,255&JTL=0,0");
		        int statusCode1 = response1.getStatusCode();
		        if (statusCode1 == 200) {
		            System.out.println("API request to the iipsrv  passed. Status code: " + statusCode1);
		        } else {
		            System.out.println("API request to the iipsrv failed. Status code: " + statusCode1);
		        }
		        Assert.assertEquals(statusCode1, 200, "API request to the iipsrv failed");
		    }
		 private void Atlas_API()
		    {
		    	//iipsrv
		    	Response response1 = RestAssured.get("https://ap3.humanbrain.in/iipsrv/fcgi-bin/iipsrv.fcgi?FIF=/apollo6/storageIIT/humanbrain/analytics/44/NISL/B_44_HB1RC-SL_421-ST_NISL-SE_1261_compressed.jp2&WID=1024&GAM=1.4&MINMAX=1:0,255&MINMAX=2:0,255&MINMAX=3:0,255&JTL=0,0");
		        int statusCode1 = response1.getStatusCode();
		        if (statusCode1 == 200) {
		            System.out.println("API request to the iipsrv  passed. Status code: " + statusCode1);
		        } else {
		            System.out.println("API request to the iipsrv failed. Status code: " + statusCode1);
		        }
		        Assert.assertEquals(statusCode1, 200, "API request to the iipsrv failed");
		    }
		 private void Cell_API()
		    {
		    	//section iipsrv
		    	Response response1 = RestAssured.get("https://ap3.humanbrain.in/iipsrv/fcgi-bin/iipsrv.fcgi?FIF=/apollo6/storageIIT/humanbrain/analytics/44/NISL/B_44_HB1RC-SL_421-ST_NISL-SE_1261_compressed.jp2&WID=1024&RGBGAMA&JTL=0,0");
		        int statusCode1 = response1.getStatusCode();
		        if (statusCode1 == 200) {
		            System.out.println("API request to the iipsrv of section passed. Status code: " + statusCode1);
		        } else {
		            System.out.println("API request to the iipsrv of section failed. Status code: " + statusCode1);
		        }
		        Assert.assertEquals(statusCode1, 200, "API request to the iipsrv of section failed");
		        
		      //Tile iipsrv
		    	Response response2 = RestAssured.get("https://ap3.humanbrain.in/iipsrv/fcgi-bin/iipsrv.fcgi?FIF=/apollo6/storageIIT/humanbrain/analytics/289/NISL/B_289_MT1-SL_15-ST_NISL-SE_441_lossless.jp2&GAM=1.5&WID=512&RGN=0.5854432595150865,0.3832887046154732,0.011947821622756866,0.014741873254441278&CVT=jpeg");
		        int statusCode2 = response1.getStatusCode();
		        if (statusCode2 == 200) {
		            System.out.println("API request to the iipsrv of tile  passed. Status code: " + statusCode1);
		        } else {
		            System.out.println("API request to the iipsrv of tile failed. Status code: " + statusCode1);
		        }
		        Assert.assertEquals(statusCode1, 200, "API request to the iipsrv of tile failed");
		        
		     }
		 private void Reg_API()
		    {
		    	//iipsrv
		    	Response response1 = RestAssured.get("https://ap3.humanbrain.in/iipsrv/fcgi-bin/iipsrv.fcgi?FIF=/apollo6/storageIIT/humanbrain/analytics/44/NISL/B_44_HB1RC-SL_421-ST_NISL-SE_1261_compressed.jp2&WID=1024&RGBGAMA&JTL=0,0");
		        int statusCode1 = response1.getStatusCode();
		        if (statusCode1 == 200) {
		            System.out.println("API request to the iipsrv  passed. Status code: " + statusCode1);
		        } else {
		            System.out.println("API request to the iipsrv failed. Status code: " + statusCode1);
		        }
		        Assert.assertEquals(statusCode1, 200, "API request to the iipsrv failed");
		    }
		 
		 
		 
		 
		 
	
		@AfterTest
		public void close() throws Exception
		{
			
			driver.quit();
	
	}

}
