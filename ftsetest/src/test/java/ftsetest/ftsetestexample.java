package ftsetest;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ftsetestexample {


	WebElement we;
	static WebDriver driver;
	String url = "https://www.hl.co.uk/shares/stock-market-summary/ftse-100/risers";


	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Drivers\\chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public static void teardown() throws InterruptedException {
	}

	
	@Test
	public void test1() throws InterruptedException { 
		driver.get(url);
		we = driver.findElement(By.className("stockTable"));
		List<WebElement> tableRows = we.findElements(By.tagName("tr"));
		System.out.println("LARGEST RISER IS");
		System.out.println(tableRows.get(1).getText());
		driver.navigate().to("https://www.hl.co.uk/shares/stock-market-summary/ftse-100/fallers");
		we = driver.findElement(By.className("stockTable"));
		tableRows = we.findElements(By.tagName("tr"));
		System.out.println("LARGEST FALLER IS");
		System.out.println(tableRows.get(1).getText());
	}

}
