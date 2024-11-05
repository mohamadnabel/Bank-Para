package signUp;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Parameters {
	WebDriver driver = new ChromeDriver();
	
	Actions actions = new Actions(driver);


	Random rand = new Random();

	String[] firstNames = { "mohammad", "ahmad", "easaa", "mousaa", "alaa" };
	String[] lastNames = { "smith", "johnson", "williams", "jones", "brown" };
	String[] streets = { "123 Main St", "456 Oak St", "789 Pine St", "101 Maple St", "202 Elm St" };
	String[] cities = { "Springfield", "Shelbyville", "Ogdenville", "North Haverbrook", "Capital City" };
	String[] states = { "IL", "CA", "NY", "TX", "FL" };
	String[] zipCodes = { "62701", "94101", "10001", "73301", "33101" };
	String[] phoneNumbers = { "555-1234", "555-5678", "555-9101", "555-1122", "555-3344" };
	String[] usernames = { "mohammad123", "ahmad456", "easaa789", "mousaa101", "alaa202" };

}
