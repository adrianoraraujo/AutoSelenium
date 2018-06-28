package br.ucsal.testes.adriano.SeleniumTestes;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;





public class AutoSapiens {
	
	
	public static void main(String[] args) {
		WebDriver driver;
		
		WebElement element;

		WebElement senha;
		
		WebElement button;
	    	System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Daredevil\\Downloads\\chromedriver.exe");
			driver = new ChromeDriver();

			driver.get("https://sapiens.agu.gov.br/login");
	    
	    	element = driver.findElement(By.name("username"));
			senha = driver.findElement(By.name("password"));
	  
	    	element.sendKeys("xxxxxxxxx");
	    	senha.sendKeys("xxxxxxxxx");
	    	button = driver.findElement(By.id("button-1019-btnInnerEl"));
button.click();
	    }
	    
	 
	}
	

	
	

