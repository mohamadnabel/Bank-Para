package signUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Mainpage extends Parameters {
	WebDriver driver = new ChromeDriver();
	String URL = "https://parabank.parasoft.com/parabank";

	@BeforeTest
	public void setUp() {

//		driver.get(URL);
		driver.manage().window().maximize();
	}

	@Test(invocationCount = 5, enabled = false)
	public void testSuite() {

		WebElement registerButton = driver.findElement(By.cssSelector("a[href='register.htm']"));
		registerButton.click();

		WebElement firstName = driver.findElement(By.id("customer.firstName"));
		WebElement lastName = driver.findElement(By.id("customer.lastName"));
		WebElement addressStreet = driver.findElement(By.id("customer.address.street"));
		WebElement addressCity = driver.findElement(By.id("customer.address.city"));
		WebElement addressState = driver.findElement(By.id("customer.address.state"));
		WebElement zipCode = driver.findElement(By.id("customer.address.zipCode"));
		WebElement phoneNumber = driver.findElement(By.id("customer.phoneNumber"));
		WebElement custumerssn = driver.findElement(By.id("customer.ssn"));
		WebElement username = driver.findElement(By.id("customer.username"));
		WebElement password = driver.findElement(By.id("customer.password"));
		WebElement rePassword = driver.findElement(By.id("repeatedPassword"));
		WebElement submitButton = driver.findElement(By.cssSelector("input[value='Register']"));

		firstName.sendKeys("mohammad");
		lastName.sendKeys("Hussein");
		addressStreet.sendKeys("qandahar street");
		addressCity.sendKeys("Riyadh");
		addressState.sendKeys("Riyadh");
		zipCode.sendKeys("23568");
		phoneNumber.sendKeys("+966500937936");
		custumerssn.sendKeys("123456");
		username.sendKeys("alnobll");
		password.sendKeys("123456789@ALNOBl");
////		rePassword.sendKeys (randomID);
//		System.out.println(randomID);
		submitButton.submit();
	}

}
