package regressionTest;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import framework.WebDriverFactory;

import org.testng.annotations.Test;

public class UpdateInfoTest extends WebDriverFactory {

	@Test
	public void updateInfo() throws InterruptedException {
		getDriver();

		By loginButton = By.xpath("//optimum-login/button");
		By userName = By.id("username");
		By passWord = By.id("password");
		By submitLogin = By.id("submitLogin");
		By myProfile = By.xpath("//*[@id=\"side-menu\"]/li[2]/a");
		By editDetails = By.xpath("//*[@id='content']/div[2]/form/div[5]/div/button");
		By homePhone = By.id("HomePhone");
		By mobilePhone = By.id("MobilePhone");
		By occupation = By.id("PreferredOccupation");
		By listL = By.xpath("/html/body/div[1]/div/div/form/div[1]/div/div[5]/div[1]/div[2]/div/input");
		By update = By.xpath("/html/body/div[1]/div/div/form/div[2]/button[1]");
		By language = By.xpath("//*[@id=\"LanguagePreference\"]");
		By languageList = By.xpath("//*[@id='LanguagePreference']/div[2]");

		WebElement webElement = driver.findElement(loginButton);

		Actions builder = new Actions(driver);
		builder.moveToElement(webElement).click(webElement);
		builder.perform();
		Thread.sleep(1000);
		driver.findElement(loginButton).click();

		driver.findElement(userName).sendKeys("lobid2");

		driver.findElement(passWord).sendKeys("Test@1234");

		driver.findElement(submitLogin).click();

		driver.findElement(myProfile).click();

		driver.findElement(editDetails).click();
		Thread.sleep(1000);

		for (String windowName : getDriver().getWindowHandles()) {
			getDriver().switchTo().window(windowName);

			driver.findElement(homePhone).sendKeys("1233456789");
			driver.findElement(mobilePhone).sendKeys("1233456349");

			driver.findElement(occupation).sendKeys("Software");

			String expected = "Software Developers, Applications";

			List<WebElement> listItems = driver.findElements(listL);
			for (int i = 0; i < listItems.size(); i++) {
				String option = listItems.get(i).getText();
				if (expected.equals(option)) {
					listItems.get(i).click();
				}
			}

			driver.findElement(language).click();
			String expected1 = "English";

			List<WebElement> listItems1 = driver.findElements(languageList);
			for (int i = 0; i < listItems1.size(); i++) {
				String option = listItems1.get(i).getText();
				System.out.println(option);
				if (expected1.equals(option)) {
					listItems1.get(i).click();
				}
			}

			// driver.findElement(update).click();
			break;
		}

	}
}
