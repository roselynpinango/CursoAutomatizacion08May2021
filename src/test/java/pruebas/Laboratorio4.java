package pruebas;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Utilidades.CapturaEvidencia;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Laboratorio4 {
	String url = "http://automationpractice.com/index.php";
	String driverPath = "..\\EducacionITSabado\\Drivers\\chromedriver.exe";
	String rutaDocumento = "..\\EducacionITSabado\\Evidencias\\AutomationPractice-Login.docx";
	String rutaImagen = "..\\EducacionITSabado\\Evidencias\\imagen.png";
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	@Test(priority=0)
	public void login() throws Exception, IOException, InterruptedException {
		CapturaEvidencia.escribirTituloEnDocumento(rutaDocumento, "Evidencias de Prueba - Login", 18);
		CapturaEvidencia.capturarPantallaEnDocumento(driver, rutaImagen, rutaDocumento, "Pantalla Principal");
		
		// Utilizando el objeto PaginInicio, hacer clic en SignIn
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.clicEnSignIn();

		CapturaEvidencia.capturarPantallaEnDocumento(driver, rutaImagen, rutaDocumento, "Pantalla Login");
		
		// Utilizando el objeto PaginaLogin, llenar las credenciales y hacer clic en el boton
		PaginaLogin login = new PaginaLogin(driver);
		login.llenarFormulario("correo9876@correo.com", "123456");
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, rutaImagen, rutaDocumento, "Credenciales a utilizar");
		
		login.clicEnSignIn();
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, rutaImagen, rutaDocumento, "Resultado Obtenido");
	}
	
	@Test(priority=1)
	public void buscar() throws InvalidFormatException, IOException, InterruptedException {
		CapturaEvidencia.escribirTituloEnDocumento(rutaDocumento, "Evidencias de Prueba - Buscar", 18);
		CapturaEvidencia.capturarPantallaEnDocumento(driver, rutaImagen, rutaDocumento, "Pantalla Principal");
		
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.ingresarBusqueda("dress");
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, rutaImagen, rutaDocumento, "Luego de ingresar el valor a buscar");
		
		inicio.clicEnBuscar();
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, rutaImagen, rutaDocumento, "Resultados de la Búsqueda");
	}
}
