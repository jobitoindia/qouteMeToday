package login_SearchProductValidation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_Search_Product_Validation 
{
	static WebDriver driver;  
	static WebElement userName,ValidateuserName,continueBtn,submitBtn,password,validatePasswordBtn;
	
	static WebElement searchProduct,serachResult,searchProductList;
	
	public static Properties prop;
	
	public static void validateBlankUserName_Password_Login() //LoginFunctionalityValidation
	{	
		userName=driver.findElement(By.xpath("//input[@id='ap_email']"));
		
		continueBtn=driver.findElement(By.xpath("//input[@id='continue']"));
		continueBtn.click();

		if(driver.findElement(By.xpath("//div[contains(text(),'  Enter your email or mobile phone number')]")).isDisplayed()) 
		{
			System.out.println("Validating the userName");
		}
		
		userName=driver.findElement(By.xpath("//input[@id='ap_email']"));
		userName.sendKeys("9890713679");
		
		continueBtn=driver.findElement(By.xpath("//input[@id='continue']"));
		continueBtn.click();
		
		password=driver.findElement(By.xpath("//input[@id='ap_password']"));
	
		submitBtn=driver.findElement(By.xpath("//input[@id='signInSubmit']"));
		submitBtn.click();
		
		if(driver.findElement(By.xpath("//div[@class='a-box-inner a-alert-container']//div[contains(text(),'  Enter your password')]")).isDisplayed())
		{
			System.out.println("password field is validated");
		}

		password.sendKeys("Aditi@77");
		submitBtn=driver.findElement(By.xpath("//input[@id='signInSubmit']"));
		submitBtn.click();
		
		String CurrentUrl=driver.getCurrentUrl();
		
		if(CurrentUrl.contains("transactionapproval")) 
		{
				System.out.println("Because we are loing From the another device, security point form amazon");				
		}
		else 
		{
				System.out.println("Home page of the amazon");
		}
	}
	
	public static void ProductSearchResult()  //productSearchValidation
	{
		searchProduct=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchProduct.sendKeys("apple iphone 15");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		serachResult=driver.findElement(By.xpath("//div[text()='apple iphone 15']"));
		serachResult.click();
		
		searchProductList=driver.findElement(By.xpath("//*[text()='Apple iPhone 15 (256 GB) - Blue']"));
		
		if(searchProductList.isDisplayed()) 
		{
			System.out.println("Product appeared in search rresult");
		}
			
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\softwares\\chromedriver-win64\\chromedriver.exe"); //browser propertiy
		driver=new ChromeDriver();   // initizalised chrome broswer
		
		FileInputStream fis;
		
		try {
			fis = new FileInputStream("E:\\Java_Development\\jobitoFRm\\src-main\\Config\\proper.properties");
			prop=new Properties();
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		driver.manage().window().maximize();
		
		driver.get(prop.getProperty("url"));  // visit to facebook.com		
			
		validateBlankUserName_Password_Login();

		ProductSearchResult();
		
		driver.quit();		
		
	}

}
