package reflex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.ArrayList;

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
		driver1 = new ChromeDriver();
	}

	/*
	 * IMPORTANTE: A veces una prueba puede fallar porque no es capaz de hacer click
	 * a un enlace. Hay veces que te dice que falla porque no pudo hacer click,
	 * cuando hay otras que te dice que está bien todo. Pues eso es debido a la
	 * línea de código que se encarga de hacer click a un botón. Probablemente
	 * Selenium intente hacer click al botón cuando aún no ha cargado la página.
	 * 
	 * También un dato a tener en cuenta es que las pruebas sólo funcionan si al
	 * hacer click en un enlace, dicho enlace no se abre en una pestaña nueva.
	 */

	@Test
	void testBuscadoresCabecera() {

		// Navegamos a la URL
		driver1.get("http://localhost:3000/buscadores");

		// Esperamos 5 segundos a que cargue el sitio web
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Encontramos la cabecera
		WebElement cabecera = driver1.findElement(By.id("cabecera"));

		// Resultado esperado: Buscadores
		String textoCabecera = cabecera.getText();
		assertEquals("Buscadores", textoCabecera);

	}

	@Test
	void testBuscadoresGoogle() {

		// Cargamos el sitio web
		driver1.get("http://localhost:3000/buscadores");
		WebElement enlaceGoogle = driver1.findElement(By.id("google"));

		// Esperamos 5 segundos
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Cogemos la URL de la página web original donde estamos ahora
		String antiguaVentana = driver1.getWindowHandle();

		// Hacemos click al elemento
		enlaceGoogle.click();

		// Esperar hasta que haya más de una pestaña abierta.
		/*
		 * Pongo esta espera porque el código no hace caso a la espera de 5 segundos e
		 * intenta acceder a la URL de la pestaña a pesar de que aún no ha cargado la
		 * página.
		 */
		WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(5));
		wait.until(driver -> driver.getWindowHandles().size() > 1);

		// Obtenemos la nueva pestaña
		ArrayList<String> nuevaVentana = new ArrayList<String>(driver1.getWindowHandles());
		nuevaVentana.remove(antiguaVentana);

		// Nos movemos a la pestaña nueva
		driver1.switchTo().window(nuevaVentana.get(0));

		// Ahora obtenemos la URL de la nueva pestaña
		String url = driver1.getCurrentUrl();
		assertEquals("https://www.google.com/", url);

		// Cerramos la pestaña
		driver1.close();
		// Nos movemos a la pestaña antigua
		driver1.switchTo().window(antiguaVentana);

		// Espero 5 segundos por si otra prueba que venga delante tiene que cargar algo
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test
	void testBuscadoresBing() {
		driver1.get("http://localhost:3000/buscadores");
		WebElement enlaceBing = driver1.findElement(By.id("bing"));

		// Esperamos 5 segundos
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Cogemos la URL de la página web original donde estamos ahora
		String antiguaVentana = driver1.getWindowHandle();

		// Hacemos click al elemento
		enlaceBing.click();

		// Esperar hasta que haya más de una pestaña abierta.
		/*
		 * Pongo esta espera porque el código no hace caso a la espera de 5 segundos e
		 * intenta acceder a la URL de la pestaña a pesar de que aún no ha cargado la
		 * página.
		 */
		WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(5));
		wait.until(driver -> driver.getWindowHandles().size() > 1);

		// Obtenemos la nueva pestaña
		ArrayList<String> nuevaVentana = new ArrayList<String>(driver1.getWindowHandles());
		nuevaVentana.remove(antiguaVentana);

		// Nos movemos a la pestaña nueva
		driver1.switchTo().window(nuevaVentana.get(0));

		// Do what you want here, you are in the new tab
		// Ahora obtenemos la URL de la nueva pestaña
		String url = driver1.getCurrentUrl();

		if (url.contains("https://www.bing.com/")) {
			url = "https://www.bing.com/";
		}

		assertEquals("https://www.bing.com/", url);
		// Cerramos la pestaña
		driver1.close();
		// Nos movemos a la pestaña antigua
		driver1.switchTo().window(antiguaVentana);

		// Espero 5 segundos por si otra prueba que venga delante tiene que cargar algo
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test
	void testBuscadoresBaidu() {
		driver1.get("http://localhost:3000/buscadores");
		WebElement enlaceBaidu = driver1.findElement(By.id("baidu"));

		// Esperamos 5 segundos
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Cogemos la URL de la página web original donde estamos ahora
		String antiguaVentana = driver1.getWindowHandle();

		// Hacemos click al elemento
		enlaceBaidu.click();

		// Esperar hasta que haya más de una pestaña abierta.
		/*
		 * Pongo esta espera porque el código no hace caso a la espera de 5 segundos e
		 * intenta acceder a la URL de la pestaña a pesar de que aún no ha cargado la
		 * página.
		 */
		WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(5));
		wait.until(driver -> driver.getWindowHandles().size() > 1);

		// Obtenemos la nueva pestaña
		ArrayList<String> nuevaVentana = new ArrayList<String>(driver1.getWindowHandles());
		nuevaVentana.remove(antiguaVentana);

		// Nos movemos a la pestaña nueva
		driver1.switchTo().window(nuevaVentana.get(0));

		// Ahora obtenemos la URL de la nueva pestaña
		String url = driver1.getCurrentUrl();
		assertEquals("https://www.baidu.com/", url);

		// Cerramos la pestaña
		driver1.close();
		// Nos movemos a la pestaña antigua
		driver1.switchTo().window(antiguaVentana);

		// Espero 5 segundos por si otra prueba que venga delante tiene que cargar algo
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test
	void testBuscadoresAtras() {
		driver1.get("http://localhost:3000/buscadores");
		WebElement volver = driver1.findElement(By.id("volver"));

		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		volver.click();

	}

}
