package reflex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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

		// Resultado esperado: https://www.google.com/
		String textoGoogle = enlaceGoogle.getAttribute("href");
		assertEquals("https://www.google.com/", textoGoogle);

		enlaceGoogle.click();
	}

	@Test
	void testBuscadoresBing() {
		driver1.get("http://localhost:3000/buscadores");
		WebElement enlaceBing = driver1.findElement(By.id("bing"));

		// Resultado esperado: https://www.bing.com/
		String textoBing = enlaceBing.getAttribute("href");
		assertEquals("https://www.bing.com/", textoBing);

		enlaceBing.click();
	}

	@Test
	void testBuscadoresBaidu() {
		driver1.get("http://localhost:3000/buscadores");
		WebElement enlaceBaidu = driver1.findElement(By.id("baidu"));

		// Resultado esperado: https://www.baidu.com/
		String textoBaidu = enlaceBaidu.getAttribute("href");
		assertEquals("https://www.baidu.com/", textoBaidu);

		enlaceBaidu.click();
	}

	@Test
	void testBuscadoresAtras() {
		driver1.get("http://localhost:3000/buscadores");
		WebElement volver = driver1.findElement(By.id("volver"));
		
		String direccionAtras = volver.getAttribute("href");
		
		assertEquals("http://localhost:3000/", direccionAtras);

		volver.click();
	}

}
