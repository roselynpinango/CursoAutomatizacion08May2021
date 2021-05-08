package Edit.EducacionITSabado;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Laboratorio2 {
	@Test
	public void lab2_E1() {
		// 1. Indicar dónde está el ChromeDriver
		System.setProperty("webdriver.chrome.driver", "..\\EducacionIt\\Drivers\\chromedriver.exe");
				
		// 2. Instanciar el Driver segun el navegador a utilizar
		WebDriver driver = new ChromeDriver();
				
		// 3. Abrir el navegador en la pagina de AutomationPractice
		driver.get("http://automationpractice.com/index.php?controller=authentication#account-creation");
		
		/*Ingresar correo */
		WebElement email = driver.findElement(By.id("email_create"));
		email.sendKeys("correo2404098@prueba.com");
		
		/*Enviar correo */
		WebElement btnCreateAnAccount = driver.findElement(By.id("SubmitCreate"));
		btnCreateAnAccount.click();
		
		/*Formulario*/	
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#customer_firstname")));
		
		WebElement radio2 = driver.findElement(By.id("id_gender2"));
		radio2.click(); 
		
		WebElement Firstname = driver.findElement(By.cssSelector("#customer_firstname"));
		Firstname.sendKeys("Andreina");
		
		WebElement Lastname = driver.findElement(By.cssSelector("#customer_lastname"));
		Lastname.sendKeys("Castro");
			
		WebElement Password = driver.findElement(By.id("passwd"));
		Password.sendKeys("123456");
		
		Select day = new Select(driver.findElement(By.xpath("//select[@id='days']")));
		day.selectByValue("18");
		
		Select months 	= new Select (driver.findElement(By.xpath("//select[@id='months']")));
		months.selectByValue("6");
		
		Select years = new Select (driver.findElement(By.xpath("//select[@id='years']")));
		years.selectByValue("1990");
		
			
		WebElement check1 = driver.findElement(By.cssSelector("#newsletter"));
		check1.click();
		
		WebElement check2 = driver.findElement(By.cssSelector("#optin"));
		check2.click();
				
		WebElement Company = driver.findElement(By.cssSelector("#company"));
		Company.sendKeys("Movistar");
		
		WebElement Adrees1 = driver.findElement(By.xpath("//input[@id='address1']"));
		Adrees1.sendKeys("Avenida Paseo Colón");
		
		WebElement Adrees2 = driver.findElement(By.xpath("//input[@id='address2']"));
		Adrees2.sendKeys("3467, Piso 10 - B");
		
		WebElement City = driver.findElement(By.cssSelector("#city"));
		City.sendKeys("Miami");
		
		
		Select state = new Select (driver.findElement(By.cssSelector("#id_state")));
		state.selectByValue("10");
		
		WebElement Postcode = driver.findElement(By.id("postcode"));
		Postcode.sendKeys("33215");
		
		Select country = new Select (driver.findElement(By.xpath("//select[@id='id_country']")));
		country.selectByValue("21");
		
		WebElement TextOther = driver.findElement(By.id("other"));
		TextOther.sendKeys("Esto es una prueba automatizada");
		 
		WebElement PhoneHaouse = driver.findElement(By.id("phone"));
		PhoneHaouse.sendKeys("(001)-123-45678");
		
		WebElement Mobile = driver.findElement(By.xpath("//input[@id='phone_mobile']"));
		Mobile.sendKeys("(001)-789-45678");

		WebElement AdressAlias = driver.findElement(By.xpath("//input[@id='alias']"));
		AdressAlias.clear();
			
		AdressAlias.sendKeys("Trabajo");
		
		WebElement btnSubmitAccount = driver.findElement(By.cssSelector("#submitAccount"));
		btnSubmitAccount.click();	
	}
}
