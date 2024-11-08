package signUp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class OpenNewaccount extends Mainpage {

//	Test Scenario: Open New Account
//	Navigate to the "Open New Account" page.
//	Open Savings Account
	@Test(priority = 5)
	public void navigate() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Thread.sleep(2000);
		WebElement nav = driver.findElement(By.cssSelector("a[href='openaccount.htm']"));
		nav.click();
		Thread.sleep(2000);
	}

//	Select "Checking" account type.
	@Test(priority = 6)
	public void selectAccountType() throws InterruptedException {
		

		WebElement accountTypy = driver.findElement(By.id("type"));
		Select dropdown = new Select(accountTypy);
		dropdown.selectByIndex(1);

		Thread.sleep(2000);
		WebElement submit = driver.findElement(By.cssSelector("input[value='Open New Account']"));

		Thread.sleep(1000);
		submit.click();

		Thread.sleep(3000);
		WebElement messageElement = driver.findElement(By.cssSelector(
				"body > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > p:nth-child(2)"));
		String expectedMessage = "Congratulations, your account is now";
		String actualMessage = messageElement.getText().trim();
		Assert.isTrue(actualMessage.contains(expectedMessage), "The account open message is incorrect.");
		Thread.sleep(2000);
	}

	@Test(priority = 7)
	public void cheackStatus() throws InterruptedException {

		Thread.sleep(1000);
		WebElement acNumber = driver.findElement(By.cssSelector("#newAccountId"));
		acNumber.click();
	}
	
	
//	Test Case : Transfer Between Own Accounts
//	Navigate to transfer Funds
	@Test(priority = 8)
	public void navigate1() throws InterruptedException {
		WebElement nav = driver.findElement(By.cssSelector("a[href='transfer.htm']"));
		nav.click();
		Thread.sleep(2000);
	}

//	Happy scenario transfer successfully  
	@Test(priority = 9)
	public void transferFunds() throws InterruptedException {
		WebElement amount = driver.findElement(By.cssSelector("#amount"));
		WebElement transferTo = driver.findElement(By.cssSelector("#toAccountId"));
		WebElement submitBtn = driver.findElement(By.cssSelector("input[value='Transfer']"));

		int amountNum = rand.nextInt(500);
		String amountNumS = Integer.toString(amountNum);
		amount.sendKeys(amountNumS);
		Select dropDownList = new Select(transferTo);
		dropDownList.selectByIndex(1);
		Thread.sleep(2000);
		submitBtn.click();

	}

}
