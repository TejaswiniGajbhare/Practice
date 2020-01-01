package test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.xml.ws.handler.Handler;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowseWindowHandlePopup {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:/Eclipse_Workspace/AutomationPracticeTest/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	
		driver.get("http://www.popuptest.com/goodpopups.html");
		
		driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/font/b/a[3]")).click();
		
		Set<String> handler=driver.getWindowHandles();
		Iterator<String> it= handler.iterator();
		
		String parentWindowId=it.next();
		System.out.println("Parent Window Id:: "+parentWindowId);
		
		String childWindowId=it.next();
		System.out.println("Child Window Id::"+childWindowId);
		
		driver.switchTo().window(childWindowId);
		System.out.println("Tittle of Child window"+driver.getTitle());
		driver.close();
		
		driver.switchTo().window(parentWindowId);
		System.out.println("Tittle of parent window"+driver.getTitle());
	
		driver.quit();
		
		
		/*	
		//	to handle File Upload Popups
		driver.get("https://html.com/input-type-file/");
		Thread.sleep(4000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,700)");
		Thread.sleep(6000);

		driver.findElement(By.xpath("//*[@id=\\'fileupload\\']")).sendKeys("D:/hello/imp_link.txt");
		Thread.sleep(4000);

		driver.close();*/
		
		
		
	}

}
