package reflex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Prueba2 {
	static WebDriver driver1;

	@BeforeAll
	static void setURL() {
		driver1 = new FirefoxDriver();
	}

	/*
	 * IMPORTANTE: A veces una prueba puede fallar porque no es capaz de hacer click
	 * a un enlace. Hay veces que te dice que falla porque no pudo hacer click,
	 * cuando hay otras que te dice que está bien todo. Pues eso es debido a la
	 * línea de código que se encarga de hacer click a un botón. Probablemente
	 * Selenium intente hacer click al botón cuando aún no ha cargado la página.
	 * 
	 * También un dato a tener en cuenta es que las pruebas sólo funcionan si
	 * al hacer click en un enlace, dicho enlace no se abre en una pestaña
	 * nueva.
	 */

	@Test
	void testBuscadoresCabecera() {
		driver1.get("http://localhost:3000/buscadores");
		WebElement cabecera = driver1.findElement(By.id("cabecera"));

		// Resultado esperado: Buscadores
		String textoCabecera = cabecera.getText();
		assertEquals("Buscadores", textoCabecera);

	}

	@Test
	void testBuscadoresGoogle() {
		driver1.get("http://localhost:3000/buscadores");
		WebElement enlaceGoogle = driver1.findElement(By.id("google"));

	

		enlaceGoogle.click();
		
		 // Guardar el ID de la pestaña original
	    String originalWindow = driver1.getWindowHandle();

	    // Esperar hasta que haya más de una pestaña abierta
	    WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(5));
	    wait.until(driver -> driver.getWindowHandles().size() > 1);

	    // Cambiar a la nueva pestaña
	    for (String windowHandle : driver1.getWindowHandles()) {
	        if (!windowHandle.equals(originalWindow)) {
	            driver1.switchTo().window(windowHandle);
	            break;
	        }
	    }

	    // Esperar hasta que la URL de la nueva pestaña sea la de Google
	    wait.until(ExpectedConditions.urlToBe("https://www.google.com/"));

	    // Ahora obtenemos la URL de la nueva pestaña
	    String url = driver1.getCurrentUrl();
	    assertEquals("https://www.google.com/", url);
	    
	 // Cerrar la nueva pestaña y volver a la original
	    driver1.close();
	    driver1.switchTo().window(originalWindow);
	}

	@Test
	void testBuscadoresBing() {
		driver1.get("http://localhost:3000/buscadores");
		WebElement enlaceBing = driver1.findElement(By.id("bing"));



		enlaceBing.click();
		
		// Guardar el ID de la pestaña original
	    String originalWindow = driver1.getWindowHandle();

	    // Esperar hasta que haya más de una pestaña abierta
	    WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(5));
	    wait.until(driver -> driver.getWindowHandles().size() > 1);

	    // Cambiar a la nueva pestaña
	    for (String windowHandle : driver1.getWindowHandles()) {
	        if (!windowHandle.equals(originalWindow)) {
	            driver1.switchTo().window(windowHandle);
	            break;
	        }
	    }

	    // Esperar hasta que la URL de la nueva pestaña sea la de Google
	    wait.until(ExpectedConditions.urlToBe("https://www.bing.com/"));

	    // Ahora obtenemos la URL de la nueva pestaña
	    String url = driver1.getCurrentUrl();
	    assertEquals("https://www.bing.com/", url);
	    
	 // Cerrar la nueva pestaña y volver a la original
	    driver1.close();
	    driver1.switchTo().window(originalWindow);
	}

	@Test
	void testBuscadoresBaidu() {
		driver1.get("http://localhost:3000/buscadores");
		WebElement enlaceBaidu = driver1.findElement(By.id("baidu"));


		enlaceBaidu.click();
		
		// Guardar el ID de la pestaña original
	    String originalWindow = driver1.getWindowHandle();

	    // Esperar hasta que haya más de una pestaña abierta
	    WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(5));
	    wait.until(driver -> driver.getWindowHandles().size() > 1);

	    // Cambiar a la nueva pestaña
	    for (String windowHandle : driver1.getWindowHandles()) {
	        if (!windowHandle.equals(originalWindow)) {
	            driver1.switchTo().window(windowHandle);
	            break;
	        }
	    }

	    // Esperar hasta que la URL de la nueva pestaña sea la de Google
	    wait.until(ExpectedConditions.urlToBe("https://www.baidu.com/"));

	    // Ahora obtenemos la URL de la nueva pestaña
	    String url = driver1.getCurrentUrl();
	    assertEquals("https://www.baidu.com/", url);
	    
	 // Cerrar la nueva pestaña y volver a la original
	    driver1.close();
	    driver1.switchTo().window(originalWindow);
	}

	@Test
	void testBuscadoresAtras() {
		driver1.get("http://localhost:3000/buscadores");
		WebElement volver = driver1.findElement(By.id("volver"));
		

		volver.click();
		
		
	}

}
