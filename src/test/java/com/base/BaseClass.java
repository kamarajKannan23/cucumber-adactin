package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
		
	protected static WebDriver driver;
	
	
	public static void getDriver() {
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Raj\\Downloads\\workspace\\MavenDemo\\Lib\\chromedriver.exe");

		driver=new ChromeDriver();
	}
	public static void enterUrl (String url) {
		driver.get(url);
	}
	public static void maximize() {
		driver.manage().window().maximize();
	}
	public static WebElement findElementById(String id) {
		WebElement element = driver.findElement(By.id(id));
		return element;
		
	}
	public static WebElement findElementByName(String name) {
		WebElement element = driver.findElement(By.name(name));
		return element;
		
	}
	public static WebElement findElementByClassName(String className) {
	    WebElement element = driver.findElement(By.className(className));
	    return  element;
	}
	public static WebElement findElementByXpath(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}
	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	public static String geturl() {
		String url = driver.getCurrentUrl();
		return url;
		
	}
	
	public static void elementSendKeys(WebElement element, String data) {
		element.sendKeys(data);
	}
	
	public static void elementClear(WebElement element) {
		element.clear();

	}
	
	
	public static void elementClick(WebElement element ) {
		element.click();
	}
	
	public static void closeAllWindow() {
		driver.quit();
	}
	
	
	public static String getText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public static String elementGetAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}
	
	public static String getAttribute(WebElement element,String attributename ) {
		String attribute = element.getAttribute(attributename);
		return attribute;
	}
	public static void selectOptionByText(WebElement element,String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	public static void selectOptionByAttribute(WebElement element,String value) {	
	Select select = new Select(element);
	select.selectByValue(value);
	}
	public static void selectOptionByIndex(WebElement element,int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	public static void typeJs(WebElement element,String text) {
		JavascriptExecutor executor =(JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','"+text+"')",element);
	}
	public static void moveToElement(WebDriver driver,WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}
	public static WebElement dragandDrop(String source,String destination) {
		WebElement element = driver.findElement(By.id(source));
		WebElement element2 = driver.findElement(By.id(destination));
		Actions actions = new Actions(driver);
		actions.dragAndDrop(element, element2).perform();
		return element;	
	}

	public static void navigateurl(String url) {
		driver.navigate().to(url);
	}
	public static void navigateBack() {
		driver.navigate().back();
	}
	public static void navigateForward() {
		driver.navigate().forward();
	}
	public static void navigateFresh() {
		driver.navigate().refresh();
	}

	public static void rightClick(WebElement element) {
	       Actions actions = new Actions(driver);
	    actions.contextClick(element).perform();
	    
	}
	public static void keyUpKeyDown(WebElement element,String text ) {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.SHIFT).sendKeys(element,text).keyUp(Keys.SHIFT).perform();
	}
	public static void doubleClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}
	public Alert alertOK() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		return alert;
	}
	public Alert alertDismiss() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		return alert;
	}
	public Alert alertPrompt(String  text) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(text);
		return alert;
	}
	public String alertGetText() {
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		return text;
		
	}
	private File getScreenShot(String path) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File destination= new File(path);
		FileUtils.copyFile(source, destination);
		return source;
		
	}
	public Object getJs(WebElement element) {
		JavascriptExecutor executor =(JavascriptExecutor) driver;
		Object object = executor.executeScript("return arguments[0].getAttribute('value')", element);
	return object;
	}
	public static void clickJs(WebElement element) {
		JavascriptExecutor executor =(JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);
	}
	public static void scrollDown(WebElement element) {
		JavascriptExecutor executor =(JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	public static void scrollUp(WebElement element) {
		JavascriptExecutor executor =(JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(false)", element);
	}
	
	public static void frame(int index) {
		driver.switchTo().frame(index);
	}
	public static void frame1(String name) {
		driver.switchTo().frame(name);
	}
	public static void frame2(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	public static void parentFrame() {
		driver.switchTo().parentFrame();
	}
	public static void defaultFrame() {
		driver.switchTo().defaultContent();
	}
	

	public String parentWindow() {
		String handle = driver.getWindowHandle();
		return handle;
	}
	public Set<String> allWindow() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}
	public boolean selectIsMultiple(WebElement element) {
		Select select = new Select(element);
		boolean b = select.isMultiple();
		return b;
	}
	public static void deselectAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}
	public static void deselectOptionIndex(WebElement element,int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}
	public static void deselectOptionvalue(WebElement element,String value) {
		Select select = new Select(element);
	    select.deselectByValue(value);
	}
	public static void deselectOptionVisibleText(WebElement element,String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}
	public WebElement getFirstSelectedOption(WebElement element) {
		Select select = new Select(element);
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		return firstSelectedOption;	
	}
	public List allSelectedOption(WebElement element) {
		Select select = new Select(element);
		List allSelectedOptions = (List) select.getAllSelectedOptions();
		return allSelectedOptions;		
	}
	public List<WebElement> getOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		return options;
	}
	
	
	public static String readValueExcel(String path, String sheetName,int rowNum, int cellNum) throws IOException {
		//path ="C:\\Users\\Raj\\Downloads\\workspace\\MavenDemo\\Excel Sheets\\WorkSheeOne.xlsx"
		
		String res=null;
		
		File file =new File(path);
		FileInputStream stream =new FileInputStream(file);
		Workbook workbook =new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		CellType type = cell.getCellType();
		switch (type) {
		case STRING:
			res= cell.getStringCellValue();
			
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat= new SimpleDateFormat("dd/mm/yy");
				res=dateFormat.format(dateCellValue);
			}else {
				double d = cell.getNumericCellValue();
				long check = Math.round(d);
				
				if(check==d) {
					res= String.valueOf(d);
				}
					res= String.valueOf(check);	
			}
			break;
		default:
			break;
		}
		workbook.close();
		return res;
	}
	
	public static void update(String path, String sheetName, int rowNum, int cellNum, String olddata, String newData) throws IOException {
		//path ="C:\\Users\\Raj\\Downloads\\workspace\\MavenDemo\\Excel Sheets\\WorkSheeOne.xlsx"
		
		File file = new File(path);
		FileInputStream stream =new FileInputStream(file);
		Workbook workbook =new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		
		String value = cell.getStringCellValue();
		
		if(value.equals(olddata)) {
			cell.setCellValue(newData);
			
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
		}
	}
	
	/* Assume Row Already created */
	public static void writeData(String path, String sheetName, int rowNum, int cellNum, String newData) throws IOException {
		//path ="C:\\Users\\Raj\\Downloads\\workspace\\MavenDemo\\Excel Sheets\\WorkSheeOne.xlsx"
		
		File file = new File(path);
		FileInputStream stream =new FileInputStream(file);
		Workbook workbook =new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		
		Row row = sheet.getRow(rowNum);
		Cell cell = row.createCell(cellNum);
		
		//set Value
		cell.setCellValue(newData);
			
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
	}
}
	
	
	
	