package wrapper;


import java.util.List;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;


public interface Wrapper {

	/**
	 * This method will launch the any browser, load the url, 
	 * maximise the browser and set the wait for 30 seconds
	 * 
	 * @param browser 	- This will load the specified browser
	 * @param url 		- This will load the specified url 
	 * @author Anish 	- PreachTech
	 * 
	 * @throws WebDriverException 
	 */
	public void invokeBrowser(String browser, String url);

	/**
	 * This method will find the element using any given Selector.
	 * 
	 * @param selType  	- The selector by which the element to be found
	 * @param selValue 	- The selector value by which the element to be found
	 * @author Anish 	- PreachTech
	 * 
	 * @throws NoSuchElementException
	 * @return The first matching element on the current context.
	 */
	public WebElement locSelector(String selType, String selValue);	
	
	
	/**
	 * This method will find all matching element using any given Selector.
	 * 
	 * @param selType  		- The selector by which the element to be found
	 * @param selValue 		- The selector value by which the element to be found
	 * @author Anish 		- PreachTech
	 * 
	 * @return A list of all WebElements, or an empty list if nothing matches.
	 */
	public List<WebElement> locSelectors(String selType, String selValue);
	
	/**
	 * This method will click the element and take snap
	 * 
	 * @param ele   	- The Webelement (button/link/element) to be clicked
	 * @author Anish 	- PreachTech
	 * 
	 * @throws StaleElementReferenceException
	 */
	public void click(WebElement ele);
	
	
	/**
	 * This method will enter the value in the given text field 
	 * 
	 * @param ele   	- The Webelement (text field) in which the data to be entered
	 * @param data  	- The data to be sent to the webelement
	 * @author Anish 	- PreachTech
	 * 
	 * @throws ElementNotInteractable,IllegalArgumentException(throws if keysToSend is null)	
	 */
	public void append(WebElement ele, String data);
	
	/**
	 * This method will clear the value in the given text field 
	 * 
	 * @param ele   	- The Webelement (text field) in which the data to be entered
	 * @author Anish 	- PreachTech
	 * 
	 * @throws InvalidElementStateException	(throws if not user-editable element)	 
	 */
	public void clear(WebElement ele);
	
	/**
	 * This method will clear and type the value in the given text field 
	 * 
	 * @param ele   	- The Webelement (text field) in which the data to be entered
	 * @param data  	- The data to be sent to the webelement
	 * @author Anish 	- PreachTech
	 * 
	 * @throws ElementNotInteractable,IllegalArgumentException(throws if keysToSend is null)		 
	 */
	public void clearAndType(WebElement ele,String data);
	
	/**
	 * This method will get the visible text of the element
	 * 
	 * @param ele   	- The Webelement (button/link/element) in which text to be retrieved
	 * @author Anish 	- PreachTech
	 */
	public String getElementText(WebElement ele);	
	
	/**
	 * This method will get the Color values of the element
	 * 
	 * @param ele   	- The Webelement (button/link/element) in which text to be retrieved
	 * @author Anish 	- PreachTech
	 * 
	 * @return The visible text of this element.
	 */
	public String getBackgroundColor(WebElement ele);
	
	/**
	 * This method will get the text of the element textbox
	 * 
	 * @param ele   	- The Webelement (button/link/element) in which text to be retrieved
	 * @author Anish 	- PreachTech
	 * 
	 * @return The attribute/property's current value (or) null if the value is not set.
	 */
	public String getTypedText(WebElement ele);
	

	/**
	 * This method will select the drop down visible text
	 * 
	 * @param ele   	- The Webelement (dropdown) to be selected
	 * @param value 	- The value to be selected (visibletext) from the dropdown
	 * @author Anish 	- PreachTech
	 * 
	 * @throws NoSuchElementException
	 */
	public void selectDropDownUsingText(WebElement ele, String value) ;
	
	/**
	 * This method will select the drop down using index
	 * 
	 * @param ele   	- The Webelement (dropdown) to be selected
	 * @param index 	- The index to be selected from the dropdown
	 * @author Anish 	- PreachTech
	 * 
	 * @throws NoSuchElementException
	 */
	public void selectDropDownUsingIndex(WebElement ele, int index) ;
	
	/**
	 * This method will select the drop down using index
	 * 
	 * @param ele   	- The Webelement (dropdown) to be selected
	 * @param value 	- The value to be selected (value) from the dropdown 
	 * @author Anish 	- 	PreachTech
	 * 
	 * @throws NoSuchElementException
	 */
	public void selectDropDownUsingValue(WebElement ele, String value) ;
	
	/**
	 * This method will verify exact given text with actual text on the given element
	 * 
	 * @param ele   		- The Webelement in which the text to be need to be verified
	 * @param expectedText  - The expected text to be verified
	 * @author Anish 		- PreachTech
	 * 
	 * @return true if the given object represents a String equivalent to this string, false otherwise
	 */
	public boolean verifyExactText(WebElement ele, String expectedText);
	
	/**
	 * This method will verify given text contains actual text on the given element
	 * 
	 * @param ele  			- The Webelement in which the text to be need to be verified
	 * @param expectedText  - The expected text to be verified
	 * @author Anish 		- PreachTech
	 * 
	 * @return true if this String represents the same sequence of characters as the specified string, false otherwise
	 */
	public boolean verifyPartialText(WebElement ele, String expectedText);

	/**
	 * This method will verify exact given attribute's value with actual value on the given element
	 * 
	 * @param ele   	- The Webelement in which the attribute value to be need to be verified
	 * @param attribute - The attribute to be checked (like value, href etc)
	 * @param value  	- The value of the attribute
	 * @author Anish 	- PreachTech
	 * 
	 * @return true if this String represents the same sequence of characters as the specified value, false otherwise
	 */
	public boolean verifyExactAttribute(WebElement ele, String attribute, String value);
	
	/**
	 * This method will verify partial given attribute's value with actual value on the given element
	 * 
	 * @param ele   	- The Webelement in which the attribute value to be need to be verified
	 * @param attribute - The attribute to be checked (like value, href etc)
	 * @param value  	- The value of the attribute
	 * @author Anish 	- PreachTech
	 * 
	 * @return true if this String represents the same sequence of characters as the specified value, false otherwise
	 * 
	 */
	public boolean verifyPartialAttribute(WebElement ele, String attribute, String value);
	
	/**
	 * This method will verify if the element is visible in the DOM
	 * 
	 * @param ele   	- The Webelement to be checked
	 * @author Anish 	- PreachTech
	 * 
	 * @return true if the element is displayed or false otherwise
	 */
	public boolean verifyDisplayed(WebElement ele);
	
	/**
	 * This method will verify if the input element is Enabled
	 * 
	 * @param ele   	- The Webelement (Radio button, Checkbox) to be verified
	 * @return true 	- if the element is enabled else false
	 * @author Anish 	- PreachTech
	 * 
	 * @return True if the element is enabled, false otherwise.
	 */
	public boolean verifyEnabled(WebElement ele);	
	
	/**
	 * This method will verify if the element (Radio button, Checkbox) is selected
	 * 
	 * @param ele   	- The Webelement (Radio button, Checkbox) to be verified
	 * @author Anish 	- PreachTech
	 * 
	 * @return True if the element is currently selected or checked, false otherwise.
	 */
	public boolean verifySelected(WebElement ele);

	/**
	 * This method will switch to the Alert
	 * 
	 * @author Anish - PreachTech
	 * 
	 * @throws NoAlertPresentException
	 */
	public void switchToAlert();

	/**
	 * This method will accept the alert opened
	 * 
	 * @author Anish - PreachTech
	 * 
	 * @throws NoAlertPresentException
	 */
	public void acceptAlert();

	/**
	 * This method will dismiss the alert opened
	 * 
	 * @author Anish 	- PreachTech
	 * 
	 * @throws NoAlertPresentException
	 */
	public void dismissAlert();

	/**
	 * This method will return the text of the alert
	 * 
	 * @author Anish 	- PreachTech
	 * 
	 * @throws NoAlertPresentException
	 */
	public String getAlertText();

	/**
	 * This method will enter the value in the alert
	 * 
	 * @author Anish 	- PreachTech
	 * @param  data		- the data to be entered in alert
	 * 
	 * @throws NoAlertPresentException
	 */
	public void enterAlertText(String data);

	/**
	 * This method will switch to the Window of interest
	 * 
	 * @param index The window index to be switched to. 0 -> first window 
	 * @author Anish 	- PreachTech
	 * 
	 * @throws NoSuchWindowException
	 */
	public void switchToWindow(int index);

	/**
	 * This method will switch to the specific frame using index
	 * 
	 * @param  index   	- The int (frame) to be switched
	 * @author Anish 	- PreachTech
	 * 
	 * @throws NoSuchFrameException 
	 */
	public void switchToFrame(int index);	

	/**
	 * This method will switch to the specific frame
	 * 
	 * @param  ele   	- The Webelement (frame) to be switched
	 * @author Anish 	- PreachTech
	 * 
	 * @throws NoSuchFrameException, StaleElementReferenceException 
	 */
	public void switchToFrame(WebElement ele);

	/**
	 * This method will switch to the specific frame using Id (or) Name
	 * 
	 * @param idOrName   - The String (frame) to be switched
	 * @author Anish 	 - PreachTech
	 * 
	 * @throws NoSuchFrameException 
	 */
	public void switchToFrame(String idOrName);

	/**
	 * This method will switch to the first frame on the page
	 * 
	 * @author Anish 	- PreachTech
	 * 
	 * @return This driver focused on the top window/first frame.
	 */
	public void switchOutFrame();

	/**
	 * This method will verify browser actual url with expected
	 * 
	 * @param url   	- The url to be checked
	 * @author Anish 	- PreachTech
	 * 
	 * @return true if the given object represents a String equivalent to this url, 
	 * false otherwise
	 */
	public boolean verifyUrl(String url);

	/**
	 * This method will verify browser actual title with expected
	 * 
	 * @param title 	- The expected title of the browser
	 * @author Anish 	- PreachTech
	 * 
	 * @return true if the given object represents a String equivalent to this title, 
	 * false otherwise
	 */
	public boolean verifyTitle(String title);

	/**
	 * This method will take snapshot of the browser
	 * 
	 * @author Anish 	- PreachTech
	 * 
	 * @return Object in which is stored information about the screenshot.
	 * @throws WebDriverException
	 */

	/**
	 * This method will close the active browser
	 * 
	 * @author Anish 	- PreachTech
	 */
	public void close();

	/**
	 * This method will close all the browsers
	 * 
	 * @author Anish 	- PreachTech
	 */
	public void quit();

}
