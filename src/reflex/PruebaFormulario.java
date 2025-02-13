package reflex;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PruebaFormulario {
	static WebDriver driver1;

	@BeforeAll
	static void setURL() {
		driver1 = new ChromeDriver();
	}
	
	
	@Test
	void comprobarElementos() {
		// Navegamos a la URL
		driver1.get("http://localhost:3000/formulario");
		
		// Encontramos los diferentes campos de escritura
		WebElement nombre = driver1.findElement(By.id("nombre"));
		
		WebElement apellidos = driver1.findElement(By.id("apellidos"));
		
		WebElement sexo = driver1.findElement(By.id("sexo"));
		
		WebElement correo = driver1.findElement(By.id("email"));
		
		WebElement ofertas = driver1.findElement(By.id("nombre"));
		
		
	}

}
