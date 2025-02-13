package reflex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PruebaFormulario {
	static WebDriver driver1;

	@BeforeAll
	static void setURL() {
		driver1 = new ChromeDriver();
	}

	@Test
	void comprobarTitulo() {
		// Navegamos a la URL
		driver1.get("http://localhost:3000/formulario");

	    
	    
		
		// Comprobamos si el título de la página web coincide con lo que queremos
		assertEquals("Formulario de registro - Mi web", driver1.getTitle());
	}

	@Test
	void comprobarNombre() {
		// Navegamos a la URL
		driver1.get("http://localhost:3000/formulario");

	    WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(10));

		// Encontramos los diferentes campos de escritura
		WebElement nombre = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nombre")));

		/* Escribimos una cadena de 51 carácteres. Si el campo sólo tiene de límite
		 * 50 letras, debería dejarnos escribir el texto entero menos la letra S,
		 * dejando por lo tanto únicamente 50 carácteres. */
		String textoPrueba = "Este es un texto de prueba con 51 letraaaaaaaaaaaas";

		nombre.sendKeys(textoPrueba);

		int longitudTexto = nombre.getAttribute("value").length();

		assertEquals(50, longitudTexto);

	}

	@Test
	void comprobarApellidos() {
		// Navegamos a la URL
		driver1.get("http://localhost:3000/formulario");

	    WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(10));
		
		// Encontramos los diferentes campos de escritura
		WebElement nombre = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("apellidos")));

		final String textoPrueba = "Este es un texto de prueba con 51 letraaaaaaaaaaaas";

		nombre.sendKeys(textoPrueba);

		int longitudTexto = nombre.getAttribute("value").length();

		assertEquals(50, longitudTexto);

	}
	
	
	@Test
	void comprobarMasculino() {
		driver1.get("http://localhost:3000/formulario");
		
		 WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(10));

		
		
		
		// Encontramos los elementos
		WebElement masculino = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@value='Hombre']")));

		
		masculino.click();
		
		assertNotNull(masculino);
		
		
		
	}
	
	@Test
	void comprobarFemenino() {
		driver1.get("http://localhost:3000/formulario");
		
		 WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(10));

	
		
		
		// Encontramos los elementos
		WebElement femenino = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@value='Mujer']")));
		

	
		
		femenino.click();

		assertNotNull(femenino);
		
		
		
	}
	
	
	@Test
	void comprobarCorreo() {
		driver1.get("http://localhost:3000/formulario");
		
	    WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(10));
		
		// Comprobamos que esté el correo y que el input sea de tipo texto
		WebElement correo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		
		final String tipo = correo.getAttribute("type");

		assertEquals("text", tipo);
	}
	
	
	@Test
	void comprobarOfertas() {
		// Navegamos a la URL
		driver1.get("http://localhost:3000/formulario");

	    WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(10));

		
		WebElement checkboxOfertas = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("check-ofertas")));

		// Comprobamos que esté marcada la casilla por defecto sin hacer nada
		assertEquals("true", checkboxOfertas.getAttribute("aria-checked"));

		

	}
	
	

	@Test
	void comprobarCondiciones() {
		driver1.get("http://localhost:3000/formulario");
		WebElement checkboxCondiciones = driver1.findElement(By.id("check-condiciones"));

		// Comprobamos que el checkbox esté presente
		assertNotNull(checkboxCondiciones);
	}
	
	
	

	@Test
	void comprobarBoton() {
		driver1.get("http://localhost:3000/formulario");
		WebElement btnEnviar = driver1.findElement(By.id("submit"));

		assertNotNull(btnEnviar);
	}


}
