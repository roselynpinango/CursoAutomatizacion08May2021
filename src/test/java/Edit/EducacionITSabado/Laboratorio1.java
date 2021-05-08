package Edit.EducacionITSabado;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Laboratorio1 {
	@Test
	public void lab1_E1() {
		// 1. Indicar donde tenemos nuestro archivo driver.exe
		System.setProperty("webdriver.chrome.driver", "..\\EducacionITSabado\\Drivers\\chromedriver.exe");
		
		// 2. Crear el objeto WebDriver asociado al navegador que queremos usar
		WebDriver driver = new ChromeDriver();
				
		// 3. Abrir un navegador en la URL selenium.dev
		driver.get("https://www.selenium.dev/");
		
		// 4. Maximizar la ventana
		driver.manage().window().maximize();		
		
		// 5. Cerrar el navegador
		driver.close();
	}	
	
	@Test
	public void lab1_E2() {
		// 1. Indicar donde tenemos nuestro archivo driver.exe
		System.setProperty("webdriver.gecko.driver", "..\\EducacionITSabado\\Drivers\\geckodriver.exe");
		
		// 2. Crear el objeto WebDriver asociado al navegador que queremos usar
		WebDriver driver = new FirefoxDriver();
				
		// 3. Abrir un navegador en la URL selenium.dev
		driver.get("https://www.selenium.dev/");
		
		// 4. Maximizar la ventana
		driver.manage().window().maximize();
		
		// 5. Cerrar el navegador
		driver.close();
	}	
	
	@Test
	public void lab1_E3() {
		// 1. Indicar donde tenemos nuestro archivo driver.exe
		System.setProperty("webdriver.chrome.driver", "..\\EducacionITSabado\\Drivers\\chromedriver.exe");
		
		// 2. Crear el objeto WebDriver asociado al navegador que queremos usar
		WebDriver driver = new ChromeDriver();
				
		// 3. Abrir un navegador en la URL selenium.dev
		driver.get("https://www.selenium.dev/");
		
		// 4. Maximizar la ventana
		driver.manage().window().maximize();
		
		// 5. Identifico un elemento por ID, envío texto y presiono la tecla ENTER
		WebElement txtSearch = driver.findElement(By.id("gsc-i-id1"));
		txtSearch.sendKeys("Java");
		txtSearch.sendKeys(Keys.ENTER);
		
		// 6. Cerrar el navegador
		//driver.close();
	}	
	
}



