package signUp;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Mainpage extends Parameters {
	String URL = "https://parabank.parasoft.com/parabank";

	@BeforeTest
	public void setUp() {

		driver.get(URL);
		driver.manage().window().maximize();
	}

//	Test Case 1: Open Registration Page

	@Test
	public void registrationPage() {
		WebElement registerButton = driver.findElement(By.cssSelector("a[href='register.htm']"));
		registerButton.click();
	}

//	Test Case 2: Fill Registration Form with Valid Data

	String usernamelog = usernames[rand.nextInt(usernames.length)] + rand.nextInt(99);

	String pass = "mohammad123456";

	@Test(invocationCount = 1, enabled = true)
	public void testSuite() {
		System.out.println(usernamelog);
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

		firstName.sendKeys(firstNames[rand.nextInt(firstNames.length)]);
		lastName.sendKeys(lastNames[rand.nextInt(lastNames.length)]);
		addressStreet.sendKeys(streets[rand.nextInt(streets.length)]);
		addressCity.sendKeys(cities[rand.nextInt(cities.length)]);
		addressState.sendKeys(states[rand.nextInt(states.length)]);
		zipCode.sendKeys(zipCodes[rand.nextInt(zipCodes.length)]);
		phoneNumber.sendKeys(phoneNumbers[rand.nextInt(phoneNumbers.length)]);
		custumerssn.sendKeys("123456");
		username.sendKeys(usernamelog);
		password.sendKeys(pass);
		rePassword.sendKeys(pass);

		submitButton.submit();

	}

//	Test Case 3: signUp successfully status
	@Test
	public void checkstatus() throws InterruptedException {
		WebElement messageElement = driver.findElement(By.cssSelector("div[id='rightPanel'] p"));

		String expectedText = "Your account was created successfully. You are now logged in";

		boolean containsText = messageElement.getText().contains(expectedText);
		// Output the result
		if (containsText == true) {
			System.out.println("The text is present truthy.");
		} else {
			System.out.println("The text is NOT present ");
		}

	}

//	Test Case 4: Initial Login
	@Test(priority = 4)
	public void loginTest() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
		driver.findElement(By.cssSelector("a[href='logout.htm']")).click();

		WebElement username = driver.findElement(By.cssSelector("input[name='username']"));
		WebElement password = driver.findElement(By.cssSelector("input[name='password']"));

		username.sendKeys(usernamelog);
		password.sendKeys(pass);

		driver.findElement(By.cssSelector("input[value='Log In']")).click();

	}
}
