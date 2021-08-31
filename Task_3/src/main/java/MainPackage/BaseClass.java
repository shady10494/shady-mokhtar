package MainPackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass extends Variables{


	protected static WebDriver driver;

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	    driver.get(FacebookUrl); // open facebook website
	    driver.manage().window().maximize();
	    WaitXpath(10, NewAccountXpath);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	//This method to locate elemnt by xpath(x) and returns it
	public static WebElement findXpath(String x) {
		return driver.findElement(By.xpath(x));
	}

	//This method to locate elemnt by Xpath(x) and send keys(y)
	public static void findXpath_SendKeys(String x , String string) {
		 driver.findElement(By.xpath(x)).sendKeys(string);
	}
	
	//This method to locate elemnt by Xpath(x) and Clicks it
	public static void findXpath_Click(String x) {
		driver.findElement(By.xpath(x)).click();
	}
	
	//this function is to select from drop down menu using xpath(x) and choose (y)
	public static void selectDropdownMenu(String x , String y) throws InterruptedException {
		Select s = new Select(findXpath(x));
	    Thread.sleep(1000);
	    s.selectByVisibleText(y);
	}
	
	//this function is used to wait appearnace of element located by Id(y) for (x) seconds
	public static void WaitId(int x , String y) {
		WebDriverWait wait = new WebDriverWait(driver, x);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(y)));
	}
	
	//this function is used to wait appearnace of element located by Xpath(y) for (x) seconds
	public static void WaitXpath(int x , String y) {
		WebDriverWait wait = new WebDriverWait(driver, x);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(y)));
	}
}
