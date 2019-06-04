import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
	public void test1() throws InterruptedException, IOException, InvalidFormatException {
		ArrayList<String> userinfo = new ArrayList<>();
		int count = 0;
		FileInputStream file = new FileInputStream(new File("userinfo.xlsx"));

		// Create Workbook instance holding reference to .xlsx file
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		// Get first/desired sheet from the workbook
		XSSFSheet sheet = workbook.getSheetAt(0);

		// Iterate through each rows one by one
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			// For each row, iterate through all the columns
			Iterator<Cell> cellIterator = row.cellIterator();

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				// Check the cell type and format accordingly
				if (count == 1) {
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
						userinfo.add("" + (int) cell.getNumericCellValue());
						break;
					case Cell.CELL_TYPE_STRING:
						userinfo.add(cell.getStringCellValue());
						break;
					}
				}
			}
			count++;
		}
		file.close();

		userinfo.stream().forEach(x -> System.out.println("    " + x));
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
		WebElement myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(we));
		action.moveToElement(myDynamicElement).click().perform();
		we = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span"));
		action.moveToElement(we).click().perform();
		we = driver.findElement(By.xpath("//*[@id=\"email_create\"]"));
		action.moveToElement(we).click().perform();
		we.sendKeys(userinfo.get(0));
		we = driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span"));
		action.moveToElement(we).click().perform();
		Thread.sleep(4000);
		we = driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]"));
		action.moveToElement(we).click().perform();
		we.sendKeys(userinfo.get(1));
		we = driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]"));
		action.moveToElement(we).click().perform();
		we.sendKeys(userinfo.get(2));
		we = driver.findElement(By.xpath("//*[@id=\"passwd\"]"));
		action.moveToElement(we).click().perform();
		we.sendKeys(userinfo.get(3));
		we = driver.findElement(By.xpath("//*[@id=\"address1\"]"));
		action.moveToElement(we).click().perform();
		we.sendKeys(userinfo.get(4));
		we = driver.findElement(By.xpath("//*[@id=\"city\"]"));
		action.moveToElement(we).click().perform();
		we.sendKeys(userinfo.get(5));
		we = driver.findElement(By.xpath("//*[@id=\"id_state\"]"));
		action.moveToElement(we).click().perform();
		we.sendKeys(Keys.ARROW_DOWN);
		we.sendKeys(Keys.ENTER);
		we = driver.findElement(By.xpath("//*[@id=\"postcode\"]"));
		action.moveToElement(we).click().perform();
		we.sendKeys(userinfo.get(6));
		we = driver.findElement(By.xpath("//*[@id=\"phone\"]"));
		action.moveToElement(we).click().perform();
		we.sendKeys(userinfo.get(7));
		we = driver.findElement(By.xpath("//*[@id=\"phone_mobile\"]"));
		action.moveToElement(we).click().perform();
		we.sendKeys(userinfo.get(8));
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
	}
}
