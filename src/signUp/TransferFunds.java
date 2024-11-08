package signUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TransferFunds extends OpenNewaccount {

//	Test Case : Transfer Between Own Accounts
//	Navigate to transfer Funds
	@Test(priority = 8, enabled = false)
	public void navigate() throws InterruptedException {
		WebElement nav = driver.findElement(By.cssSelector("a[href='transfer.htm']"));
		nav.click();
		Thread.sleep(2000);
	}

//	Happy scenario transfer successfully  
	@Test(priority = 9, enabled = false)
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
