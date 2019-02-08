package framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class WebDriverFactory {
	
	protected static WebDriver driver = null;
	
	private String uRL = "https://claimant-portal.opt-qa2.optimumui.com/#!/login";

	public static WebDriver getDriver() {
		return driver;
	}

	@BeforeClass
	public void initializeDriver() {
		
		System.setProperty("webdriver.chrome.driver", "/home/lobid/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(uRL);
		getDriver().manage().window().maximize();

	}

	@AfterClass
	public void tearDown() throws InterruptedException {

		if (driver != null) {
			driver.manage().deleteAllCookies();
			//Thread.sleep(3000);
			driver.quit();
		}

	}

}
