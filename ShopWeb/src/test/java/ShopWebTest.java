import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopWebTest {

	WebElement we;
	static WebDriver driver;
	String url = "http://automationpractice.com/index.php";
	String email= "asdasdasd@asdasdasdasdsszzzssd.com";
	String username = "user1";
	String password="password";

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
		Actions action = new Actions(driver);
		we = driver.findElement(By.xpath("//*[@id=\"search_query_top\"]"));
		action.moveToElement(we).click().perform();
		we.sendKeys("dress");
		we.submit();
		we = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/h5/a"));
		action.moveToElement(we).click().perform();
		we = driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span"));
		action.moveToElement(we).click().perform();
		we = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a"));
		WebElement myDynamicElement =  (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(we));
		action.moveToElement(myDynamicElement).click().perform();
		we = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span"));
		action.moveToElement(we).click().perform();
		we = driver.findElement(By.xpath("//*[@id=\"email_create\"]"));
		action.moveToElement(we).click().perform();
		we.sendKeys(email);
		we = driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span"));
		action.moveToElement(we).click().perform();
		Thread.sleep(4000);
		we = driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]"));
		action.moveToElement(we).click().perform();
		we.sendKeys("a");
		we = driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]"));
		action.moveToElement(we).click().perform();
		we.sendKeys("a");
		we = driver.findElement(By.xpath("//*[@id=\"passwd\"]"));
		action.moveToElement(we).click().perform();
		we.sendKeys(password);
		we = driver.findElement(By.xpath("//*[@id=\"address1\"]"));
		action.moveToElement(we).click().perform();
		we.sendKeys("a");
		we = driver.findElement(By.xpath("//*[@id=\"city\"]"));
		action.moveToElement(we).click().perform();
		we.sendKeys("a");
		we = driver.findElement(By.xpath("//*[@id=\"id_state\"]"));
		action.moveToElement(we).click().perform();
		we.sendKeys(Keys.ARROW_DOWN);
		we.sendKeys(Keys.ENTER);
		we = driver.findElement(By.xpath("//*[@id=\"postcode\"]"));
		action.moveToElement(we).click().perform();
		we.sendKeys("02030");
		we = driver.findElement(By.xpath("//*[@id=\"phone\"]"));
		action.moveToElement(we).click().perform();
		we.sendKeys("012390123089");
		we = driver.findElement(By.xpath("//*[@id=\"phone_mobile\"]"));
		action.moveToElement(we).click().perform();
		we.sendKeys("0");
		we = driver.findElement(By.xpath("//*[@id=\"submitAccount\"]/span"));
		action.moveToElement(we).click().perform();
		Thread.sleep(4000);
		we = driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button/span"));
		action.moveToElement(we).click().perform();
		Thread.sleep(4000);
		we = driver.findElement(By.xpath("//*[@id=\"cgv\"]"));
		action.moveToElement(we).click().perform();
		we = driver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span"));
		action.moveToElement(we).click().perform();
		Thread.sleep(4000);
		we = driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a"));
		action.moveToElement(we).click().perform();
		Thread.sleep(4000);
		we = driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button/span"));
		action.moveToElement(we).click().perform();
		//Thread.sleep(8000);
	//	assertEquals("Your order on My Store is complete.", "");
	}
}
