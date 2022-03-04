package wrapper;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Reports;

public class GenericWrapper extends Reports implements Wrapper{

	public RemoteWebDriver driver;
	

	public void invokeBrowser(String browser, String url) {
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); // 123
		} else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if(browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("The Browser "+browser+" launched Successfully");
	}

	public WebElement locSelector(String selectorType, String selValue) {
		switch (selectorType.toLowerCase()) {
		case "id": return driver.findElement(By.id(selValue));
		case "name": return driver.findElement(By.name(selValue));
		case "class": return driver.findElement(By.className(selValue));
		case "link": return driver.findElement(By.linkText(selValue));
		case "partiallink": return driver.findElement(By.partialLinkText(selValue));
		case "css": return driver.findElement(By.cssSelector(selValue));
		case "tagname": return driver.findElement(By.tagName(selValue));
		case "xpath": return driver.findElement(By.xpath(selValue));	
		}
		return null;
	}

	public List<WebElement> locSelectors(String selectorType, String selValue) {
		switch (selectorType.toLowerCase()) {
		case "id": return driver.findElements(By.id(selValue));
		case "name": return driver.findElements(By.name(selValue));
		case "class": return driver.findElements(By.className(selValue));
		case "link": return driver.findElements(By.linkText(selValue));
		case "partiallink": return driver.findElements(By.partialLinkText(selValue));
		case "css": return driver.findElements(By.cssSelector(selValue));
		case "tagname": return driver.findElements(By.tagName(selValue));
		case "xpath": return driver.findElements(By.xpath(selValue));	
		}
		return null;
	}

	public void click(WebElement ele) {
		String text = null;
		try {
			text = ele.getText();
			ele.click();
			//System.out.println("The Element "+text+" clicked");
			reportStep("The Element "+text+" clicked", "PASS");
		} catch (Exception e) {
			reportStep("The Element "+text+" couldn't click", "FAIL");
		} 
	}

	public void clickWithNoSnap(WebElement ele) {	
		ele.click();
		System.out.println("The Element "+ele+" clicked");
	}

	public void append(WebElement ele, String data) {
		ele.sendKeys(data);
		System.out.println("The data "+ data+" entered successfully");
	}

	public void clear(WebElement ele) {
		ele.clear();
		System.out.println("The field is cleared Successfully");
	}

	public void clearAndType(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			reportStep("The Data :"+data+" entered Successfully", "PASS");
		} catch (Exception e) {
			reportStep("", "FAIL");
		}
	}

	public String getElementText(WebElement ele) {
		String text = ele.getText();
		return text;
	}

	public String getBackgroundColor(WebElement ele) {
		String cssValue = ele.getCssValue("color");
		return cssValue;
	}

	public String getTypedText(WebElement ele) {
		String attributeValue = ele.getAttribute("value");
		return attributeValue;
	}

	public void selectDropDownUsingText(WebElement ele, String value) {
		new Select(ele).selectByVisibleText(value);
	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		new Select(ele).selectByIndex(index);
	}

	public void selectDropDownUsingValue(WebElement ele, String value) {
		new Select(ele).selectByValue(value);
	}

	public boolean verifyExactText(WebElement ele, String expectedText) {
		boolean bReturn = false;
		if(ele.getText().equals(expectedText)) {
			System.out.println("The expected text contains the actual "+expectedText);
			bReturn = true;
		}else {
			System.out.println("The expected text doesn't contain the actual "+expectedText);
		}
		return bReturn;
	}

	public boolean verifyPartialText(WebElement ele, String expectedText) {
		boolean bReturn = false;
		if(ele.getText().contains(expectedText)) {
			System.out.println("The expected text contains the actual "+expectedText);
			bReturn = true;
		}else {
			System.out.println("The expected text doesn't contain the actual "+expectedText);
		}
		return bReturn;
	}

	public boolean verifyExactAttribute(WebElement ele, String attribute, String value) {
		boolean bReturn = false;
		if(ele.getAttribute(attribute).equals(value)) {
			System.out.println("The expected attribute :"+attribute+" value contains the actual "+value);
			bReturn = true;
		}else {
			System.out.println("The expected attribute :"+attribute+" value does not contains the actual "+value);
		}
		return bReturn;
	}

	public boolean verifyPartialAttribute(WebElement ele, String attribute, String value) {
		boolean bReturn = false;
		if(ele.getAttribute(attribute).contains(value)) {
			System.out.println("The expected attribute :"+attribute+" value contains the actual "+value);
			bReturn = true;
		}else {
			System.out.println("The expected attribute :"+attribute+" value does not contains the actual "+value);
		}
		return bReturn;
	}

	public boolean verifyDisplayed(WebElement ele) {
		boolean bReturn = false;
		if(ele.isDisplayed()) {
			System.out.println("The element "+ele+" is visible");
			bReturn = true;
		} else {
			System.out.println("The element "+ele+" is not visible");
		}
		return bReturn;
	}

	public boolean verifyEnabled(WebElement ele) {
		boolean bReturn = false;
		if(ele.isEnabled()) {
			System.out.println("The element "+ele+" is Enabled");
			bReturn = true;
		} else {
			System.out.println("The element "+ele+" is not Enabled");
		}
		return bReturn;
	}

	public boolean verifySelected(WebElement ele) {
		boolean bReturn = false;
		if(ele.isSelected()) {
			System.out.println("The element "+ele+" is selected");
			bReturn = true;
		} else {
			System.out.println("The element "+ele+" is not selected");
		}
		return bReturn;
	}

	public void switchToAlert() {
		driver.switchTo().alert();
		System.out.println("Control switch from HTML to alert");
	}

	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		alert.accept();
		System.out.println("The alert "+text+" is accepted.");
	}

	public void dismissAlert() {
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		alert.dismiss();
		System.out.println("The alert "+text+" is accepted.");
	}

	public String getAlertText() {
		String text = driver.switchTo().alert().getText();
		System.out.println("Control switch from HTML to alert and fetched the Text: "+text);
		return text;
	}

	public void enterAlertText(String data) {
		driver.switchTo().alert().sendKeys(data);
		System.out.println("Control switch from HTML to alert and entered the given data is "+data);
	}

	public void switchToWindow(int index) {
		Set<String> allWin = driver.getWindowHandles();
		List<String> lst = new ArrayList<String>(allWin);
		driver.switchTo().window(lst.get(index));
		System.out.println("The Window With index: "+index+ "switched successfully");
	}

	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
		System.out.println("The frame using index: "+index+ "switched successfully");
	}

	public void switchToFrame(WebElement ele) {
		driver.switchTo().frame(ele);
		System.out.println("The frame using element: "+ele+ "switched successfully");
	}

	public void switchToFrame(String idOrName) {
		driver.switchTo().frame(idOrName);
		System.out.println("The frame using idOrName: "+idOrName+ "switched successfully");
	}

	public void switchOutFrame() {
		driver.switchTo().defaultContent();
		System.out.println("Came out from all frames Successfully");	
	}

	public boolean verifyUrl(String url) {
		boolean bReturn = false;
		if (driver.getCurrentUrl().equals(url)) {
			System.out.println("The url: "+url+" matched successfully");
			bReturn = true;
		} else {
			System.out.println("The url: "+url+" not matched");
		}
		return bReturn;
	}

	public boolean verifyTitle(String title) {
		boolean bReturn = false;
		if (driver.getTitle().equals(title)) {
			System.out.println("Page title: "+title+" matched successfully");
			bReturn = true;
		} else {
			System.out.println("Page url: "+title+" not matched");
		}
		return bReturn;
	}

	public void close() {
		driver.close();
		System.out.println("Browser closed Successfully");
	}

	public void quit() {
		driver.quit();
		System.out.println("Browser closed Successfully");
	}

	@Override
	public long takeSnap() {
		long number = (long)Math.floor((Math.random() * 900000000L)) + 1000000000L;
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE), new File("./reports/images/"+number+".png"));
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return number;
	}
}
