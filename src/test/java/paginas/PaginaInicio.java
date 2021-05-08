package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaInicio {
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement lnkSignIn;
	
	@FindBy(xpath="//input[@id='search_query_top']")
	WebElement txtBuscador;
	
	@FindBy(xpath="//header/div[3]/div[1]/div[1]/div[2]/form[1]/button[1]")
	WebElement btnBuscar;
	
	WebDriver driver;
	
	public PaginaInicio(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clicEnSignIn() {
		lnkSignIn.click();
	}
	
	public void ingresarBusqueda(String aBuscar) {
		txtBuscador.sendKeys(aBuscar);
	}
	
	public void clicEnBuscar() {
		btnBuscar.click();
	}
}
