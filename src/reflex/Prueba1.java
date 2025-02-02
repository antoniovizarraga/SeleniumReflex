package reflex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Prueba1 {
	static WebDriver driver1;

	@BeforeAll
	static void setURL() {
		// Uso Firefox porque con Edge y Chrome me salta un error, no sé porqué. Creo
		// que es algo de la versión que tiene
		// Selenium guardada que no es compatible con esta versión de Selenium o algo
		// así.
		driver1 = new FirefoxDriver();
	}

	/*
	 * IMPORTANTE: A veces una prueba puede fallar porque no es capaz de hacer click
	 * a un enlace. Hay veces que te dice que falla porque no pudo hacer click,
	 * cuando hay otras que te dice que está bien todo. Pues eso es debido a la
	 * línea de código que se encarga de hacer click a un botón. Probablemente
	 * Selenium intente hacer click al botón cuando aún no ha cargado la página.
	 */

	@Test
	void testIndexCabecera() {
		driver1.get("http://localhost:3000");
		WebElement cabecera = driver1.findElement(By.id("cabecera"));

		// Resultado esperado: Enlaces favoritos
		String textoCabecera = cabecera.getText();
		assertEquals("Enlaces favoritos", textoCabecera);

	}

	@Test
	void testIndexBuscadores() {
		driver1.get("http://localhost:3000");
		WebElement enlaceBuscadores = driver1.findElement(By.id("buscadores"));

		// Resultado esperado: http://localhost:3000/buscadores
		String textoBuscadores = enlaceBuscadores.getAttribute("href");
		assertEquals("http://localhost:3000/buscadores/", textoBuscadores);

		enlaceBuscadores.click();

	}

	@Test
	void testIndexRedes() {
		driver1.get("http://localhost:3000");
		WebElement enlaceRedes = driver1.findElement(By.id("redes"));

		// Resultado esperado: http://localhost:3000/redes_sociales
		String textoRedes = enlaceRedes.getAttribute("href");
		assertEquals("http://localhost:3000/redes_sociales/", textoRedes);

		enlaceRedes.click();
	}

}
