package wrappers;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import utils.Reporter;



public class GenericWrappers extends Reporter implements Wrappers{
	public RemoteWebDriver driver;
	int i=1;

	/**
	 * This method will launch the given browser and maximise the browser and set the
	 * wait for 30 seconds and load the url
	 * @author Babu - TestLeaf
	 * @param browser - The browser of the application to be launched
	 * @param url - The url with http or https
	 * @throws IOException 
	 * @ 
	 * 
	 */
	public void invokeApp(String browser, String url)  {		
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver_64bit.exe");
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			logSteps("PASS","The browser : "+browser+" is launched Successfully" );
			
			System.out.println("The browser : "+browser+" is launched Successfully");
		} catch (WebDriverException e) {
			System.out.println("WebDriverException");
		}
		finally {
			takeSnap();
		}

	}

	/**
	 * This method will enter the value to the text field using id attribute to locate
	 * 
	 * @param idValue - id of the webelement
	 * @param data - The data to be sent to the webelement
	 * @author Babu - TestLeaf
	 * @return 
	 * @ 
	 */

	public void enterById(String idValue, String data) {		
		try {
			driver.findElementById(idValue).clear();
			driver.findElementById(idValue).sendKeys(data);
			logSteps("PASS", "The Value "+data+" has been entered successfully in : "+idValue);
			System.out.println("The Value "+data+" has been entered successfully in : "+idValue);
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException");
		}
		catch (WebDriverException e) {
			System.out.println("WebDriverException");
			e.printStackTrace();
		}		
		finally {
			takeSnap();
		}
	}

	public void enterByName(String nameValue, String data) {
		try {
			driver.findElementByName(nameValue).clear();
			driver.findElementByName(nameValue).sendKeys(data);
			logSteps("PASS", "The Value" + data + "has been entered succcessfully in:"+nameValue);
			System.out.println("The Value" + data + "has been entered succcessfully in:"+nameValue);
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException");
		}
		catch (WebDriverException e) {
			System.out.println("WebDriverException");
			e.printStackTrace();
		}		
		catch (Exception e) {
			System.out.println("Unkown Exception");
			e.printStackTrace();
		}

		finally {
			takeSnap();
		}
	}

	public void enterByXpath(String xpathValue, String data) {
		try {
			driver.findElementByXPath(xpathValue).clear();
			driver.findElementByXPath(xpathValue).sendKeys(data);
			logSteps("PASS", "The Value "+ data +" has been entered successfully in:"+xpathValue);
			System.out.println("The Value "+ data +" has been entered successfully in:"+xpathValue);
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException");
		}
		catch (WebDriverException e) {
			System.out.println("WebDriverException");
			e.printStackTrace();
		}		
		catch (Exception e) {
			System.out.println("Unkown Exception");
			e.printStackTrace();
		}
		finally {
			takeSnap();
		}
	}
	
	

	public boolean verifyTitle(String title) {
		try {
			if(driver.getTitle().equalsIgnoreCase(title)) {
				logSteps("PASS", "Title has been verifyed successfully:"+title);
				System.out.println("Title has been verifyed successfully:"+title);
			}
			else if (!driver.getTitle().equalsIgnoreCase(title)) {
				logSteps("FAIL", "Could not find:"+title);
				System.out.println("Could not find:"+title);
			}
			
		} catch (WebDriverException e) {
			System.out.println("WebDriverException");
			e.printStackTrace();
		}
		finally {
			takeSnap();
		}
		return false;
	}

	public boolean verifyTextById(String id, String text) {
		try {
			if (driver.findElementById(id).getText().contains(text)) {
				logSteps("PASS", "The text has been verifyied : "+text);
				System.out.println("The text has been verifyied : "+text);
			} else {
				logSteps("FAIL", "The"+text+"did not matched");
				System.out.println("The"+text+"did not matched");

			}

		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException");
			e.printStackTrace();
		}

		catch (WebDriverException e) {
			System.out.println("WebDriverException");
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("Unkown Exception");
			e.printStackTrace();
		}
		finally {
			takeSnap();
		}
		return false;
	}

	public void verifyTextByXpath(String xpath, String text) {
		try {
			if (driver.findElementByXPath(xpath).getText().equalsIgnoreCase(text)) {

				logSteps("PASS", "The text is Verifyed  by xpath successfully : "+text);
				System.out.println("The text is Verifyed  by xpath successfully : "+text);

			}
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException");
			e.printStackTrace();
		}
		catch (WebDriverException e) {
			System.out.println("WebDriverException");
			e.printStackTrace();
		}
		finally {
			takeSnap();
		}
	}

	public void verifyTextContainsByXpath(String xpath, String text) {

		try {
			if (driver.findElementByXPath(xpath).getText().contains(text)) {
				logSteps("PASS", "The Given Text has been Matched : "+text);
				System.out.println("The Given Text has been Matched : "+text);
			}
		} 
		catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException");
			e.printStackTrace();
		}
		catch (WebDriverException e) {
			System.out.println("WebDriverException");
			e.printStackTrace();
		}
		
		catch (Exception e) {
			System.out.println("Unkown Exception");
			e.printStackTrace();
		}
		finally {
			takeSnap();
		}

	}

	public void clickById(String id) {
		try {
			driver.findElementById(id).click();
			logSteps("PASS", "The Button "+id+" Clicked Successfully");
			System.out.println("The Button "+id+" Clicked Successfully");
		}
		catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException");
			e.printStackTrace();
		}
		catch (WebDriverException e) {
			System.out.println("WebDriverException");
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("Unkown Exception");
			e.printStackTrace();
		}

		finally {
			takeSnap();
		}

	}

	public void clickByClassName(String classVal) {

		try {
			driver.findElementByClassName(classVal).click();
			logSteps("PASS", "The Button "+classVal+" Clicked Successfully");
			System.out.println("The Button "+classVal+" Clicked Successfully");
		} catch (WebDriverException e) {
			System.out.println("WebDriverException");
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("Unkown Exception");
			e.printStackTrace();
		}
		finally {
			takeSnap();
		}
	}

	public void clickByName(String name) {
		try {
			driver.findElementByName(name).click();
			logSteps("PASS", "The Button "+name+" Clicked Successfully");
			System.out.println("The Button "+name+" Clicked Successfully");
		} 
		catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException");
			e.printStackTrace();
		}
		catch (WebDriverException e) {
			System.out.println("NoSuchElementException");
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("Unkown Exception");
			e.printStackTrace();
		}

		finally {
			takeSnap();
		}
	}

	public void clickByLink(String name) {
		try {
			driver.findElementByLinkText(name).click();
			logSteps("PASS", "The "+name+" Clicked Sucessfully");
			System.out.println("The "+name+" Clicked Sucessfully");
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException");
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("Unkown Exception");
			e.printStackTrace();
		}

		finally {
			takeSnap();
		}
	}

	public void clickByLinkNoSnap(String name) {
		try {
			driver.findElementByLinkText(name).click();
			logSteps("PASS", "The "+name+" Clicked Sucessfully");
			System.out.println("The "+name+" Clicked Sucessfully");
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException");
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("Unkown Exception");
			e.printStackTrace();
		}
		

	}

	public void clickByXpath(String xpathVal) {
		try {
			driver.findElementByXPath(xpathVal).click();
			logSteps("PASS", "The "+xpathVal+" has been clicked Sucessfully");
			System.out.println("The "+xpathVal+" has been clicked Sucessfully");
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException");
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("Unkown Exception");
			e.printStackTrace();
		}
		finally {
			takeSnap();
		}

	}

	public void clickByXpathNoSnap(String xpathVal) {
		try {
			driver.findElementByXPath(xpathVal).click();
			logSteps("PASS", "The "+xpathVal+" has been clicked Sucessfully");
			System.out.println("The "+xpathVal+" has been clicked Sucessfully");
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException");
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("Unkown Exception");
			e.printStackTrace();
		}
		
	}

	public String getTextById(String idVal) {
		String str="No text is copied";
		try {
			str = driver.findElementById(idVal).getText();
			logSteps("PASS", str);
			System.out.println(str);
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException");
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("Unkown Exception");
			e.printStackTrace();
		}
		finally {
			takeSnap();
		}
		return str;
	}

	public String getTextByXpath(String xpathVal) {
		String str="No value is not copied";
		try {
			str =driver.findElementByXPath(xpathVal).getText();
			logSteps("PASS", str);
			System.out.println(str);
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException");
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("Unkown Exception");
			e.printStackTrace();
		}
		finally {
			takeSnap();
		}
		return str;
	}

	public void selectVisibileTextById(String id, String value) {
		try {
			Select oSelect = new Select(driver.findElementById(id));
			oSelect.selectByVisibleText(value);
			logSteps("PASS", "The dropdown list is selected successfully: "+value);
			System.out.println("The dropdown list is selected successfully: "+value);
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException");
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("Unkown Exception");
			e.printStackTrace();
		}
		finally {
			takeSnap();
		}

	}

	public void selectIndexById(String id, int value) {
		try {
			Select sel =  new Select(driver.findElementById(id));
			sel.selectByIndex(value);
			logSteps("PASS", "The is selected successfully :"+value);
			System.out.println("The is selected successfully :"+value);
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException");
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("Unkown Exception");
			e.printStackTrace();
		}
		finally {
			takeSnap();
		}

	}

	public void switchToParentWindow() {
		Set<String> ParentWindow;
		try {
			ParentWindow = driver.getWindowHandles();
			for (String windows : ParentWindow) {
				driver.switchTo().window(windows);
				break;
			}
			logSteps("PASS", "Switched to "+ParentWindow);
			System.out.println("Switched to "+ParentWindow);
		}
		catch (NoSuchWindowException e) {
			System.out.println("WebDriverException");
			e.printStackTrace();
		}
		catch (WebDriverException e) {
			System.out.println("WebDriverException");
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("Unkown Exception");
			e.printStackTrace();
		}


	}

	public void switchToLastWindow() {
		Set<String> switchToLastWindow;
		try {
			switchToLastWindow = driver.getWindowHandles();
			for (String LastWindow : switchToLastWindow) {
				driver.switchTo().window(LastWindow);
			}
			logSteps("PASS", "Switched to "+switchToLastWindow);
			System.out.println("Switched to "+switchToLastWindow);
		} 
		catch (NoSuchWindowException e) {
			System.out.println("WebDriverException");
			e.printStackTrace();
		}
		
		catch (WebDriverException e) {
			System.out.println("WebDriverException");
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("Unkown Exception");
			e.printStackTrace();
		}

	}

	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
			logSteps("PASS", "The alert has been accepted Successfully");
			System.out.println("The alert has been accepted Successfully");
		} catch (NoAlertPresentException e) {
			System.out.println("NoSuchElementException");
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("Unkown Exception");
			e.printStackTrace();
		}
		finally {
			takeSnap();
		}

	}

	public void dismissAlert() throws IOException {
		try {
			driver.switchTo().alert().dismiss();
			logSteps("PASS", " The alert has beeen dismissed Successfully");
			System.out.println(" THe alert has beeen dismissed Successfully");
		} catch (NoAlertPresentException e) {
			System.out.println("NoSuchElementException");
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("Unkown Exception");
			e.printStackTrace();
		}

		finally {
			takeSnap();
		}

	}

	public String getAlertText() {
		try {
			String str = driver.switchTo().alert().getText();
			logSteps("PASS", str);
			System.out.println(str);
		} catch(WebDriverException e) {
			System.out.println("WebDriverException");
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("Unkown Exception");
			e.printStackTrace();
		}
		return null;
	}

	public void takeSnap()  {
		try {
			File src = driver.getScreenshotAs(OutputType.FILE);
			File desc = new File("E:images/image"+i+".jpg");
			FileUtils.copyFile(src, desc);
		} catch (WebDriverException e) {
			System.out.println("WebDriverException");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException");
			e.printStackTrace();
		}
		i++;
	}

	public void closeBrowser() {
		try {
			driver.close();
			logSteps("PASS", "The current broswer is closed Successfully");
			System.out.println("The current broswer is closed Successfully");
		} catch (Exception e) {
			System.out.println("No broswer found");
			e.printStackTrace();
		}
		
	}

	public void closeAllBrowsers() {
		try {
			driver.quit();
			logSteps("PASS", "All broswers has been closed Successfully");
			System.out.println("All broswers has been closed Successfully");
		} catch (WebDriverException e) {
			System.out.println("WebDriverException");
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("Unkown Exception");
			e.printStackTrace();
		}

		finally {
			takeSnap();
		}

	}

}
