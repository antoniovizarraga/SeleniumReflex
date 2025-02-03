package reflex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Prueba3 {
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
	void testRedesCabecera() {
		/* He tenido que poner como URL: "/redessociales" porque en Reflex
		 * al llamar la página: "/redes_sociales" me salta un error 404 al
		 * intentar acceder a la página. Tampoco admite guiones, por lo
		 * que tuve que ponerlo todo junto. */
		driver1.get("http://localhost:3000/redessociales");
		WebElement cabecera = driver1.findElement(By.id("cabecera"));

		// Resultado esperado: Redes sociales
		String textoCabecera = cabecera.getText();
		assertEquals("Redes sociales", textoCabecera);

	}

	@Test
	void testRedesInstagram() {
		driver1.get("http://localhost:3000/redessociales");
		WebElement enlaceInstagram = driver1.findElement(By.id("instagram"));

		// Resultado esperado: https://www.instagram.com/
		String textoInstagram = enlaceInstagram.getAttribute("href");
		assertEquals("https://www.instagram.com/", textoInstagram);

		enlaceInstagram.click();
	}

	@Test
	void testRedesTiktok() {
		driver1.get("http://localhost:3000/redessociales");
		WebElement enlaceTiktok = driver1.findElement(By.id("tiktok"));

		// Resultado esperado: https://www.tiktok.com/
		String textoTiktok = enlaceTiktok.getAttribute("href");
		assertEquals("https://www.tiktok.com/", textoTiktok);

		enlaceTiktok.click();
	}

	@Test
	void testRedesFacebook() {
		driver1.get("http://localhost:3000/redessociales");
		WebElement enlaceFacebook = driver1.findElement(By.id("facebook"));

		// Resultado esperado: https://www.facebook.com/
		String textoFacebook = enlaceFacebook.getAttribute("href");
		assertEquals("https://www.facebook.com/", textoFacebook);

		enlaceFacebook.click();
	}

	@Test
	void testRedesAtras() {
		driver1.get("http://localhost:3000/redessociales");
		WebElement volver = driver1.findElement(By.id("volver"));
		
		String direccionAtras = volver.getAttribute("href");
		
		assertEquals("http://localhost:3000/", direccionAtras);

		volver.click();
	}
}
