package pruebas;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilidades.CapturaEvidencia;
import Utilidades.DatosExcel;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Laboratorio4_E2 {
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
	
	@Test(priority=0,dataProvider="Datos Prueba Login")
	public void login(String email, String password) throws Exception, IOException, InterruptedException {
		CapturaEvidencia.escribirTituloEnDocumento(rutaDocumento, "Evidencias de Prueba - Login - Dato de entrada: " + email, 18);
		CapturaEvidencia.capturarPantallaEnDocumento(driver, rutaImagen, rutaDocumento, "Pantalla Principal");
		
		// Utilizando el objeto PaginInicio, hacer clic en SignIn
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.clicEnSignIn();

		CapturaEvidencia.capturarPantallaEnDocumento(driver, rutaImagen, rutaDocumento, "Pantalla Login");
		
		// Utilizando el objeto PaginaLogin, llenar las credenciales y hacer clic en el boton
		PaginaLogin login = new PaginaLogin(driver);
		login.llenarFormulario(email, password);
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, rutaImagen, rutaDocumento, "Credenciales a utilizar");
		
		login.clicEnSignIn();
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, rutaImagen, rutaDocumento, "Resultado Obtenido");
		
		Assert.assertEquals("http://automationpractice.com/index.php?controller=my-account", driver.getCurrentUrl());
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
	
	@DataProvider(name="Datos Prueba Login")
	public Object[][] obtenerDatosEntrada() throws Exception {
		String ruta = "..\\EducacionITSabado\\Datos\\datosLab4_E2.xlsx";
		String nombreHoja = "Hoja1";
		
		return DatosExcel.leerExcel(ruta, nombreHoja);
	}
}
