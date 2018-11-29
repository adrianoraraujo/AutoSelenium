package br.ucsal.testes.adriano.SeleniumTestes;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.jar.asm.commons.TryCatchBlockSorter;

public class AutoSapiens
{

	public static void main(String[] args) throws AWTException, InterruptedException
	{
		WebDriver driver;

		WebElement element;
		WebElement element2;
		WebElement element3;

		WebElement senha;

		WebElement button;
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://sapiens.agu.gov.br/login");
		element = driver.findElement(By.name("username"));
		senha = driver.findElement(By.name("password"));

		element.sendKeys("xxxx");
		senha.sendKeys("xxxx");
		driver.findElement(By.id("button-1019-btnInnerEl")).click();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("splitbutton-1011")));
		button = driver.findElement(By.id("splitbutton-1011"));
		Actions act = new Actions(driver);
		Thread.sleep(8000);
		act.moveToElement(button).moveByOffset(40, 0).click().perform();
		driver.findElement(By.id("menuitem-1016-textEl")).click();
		element3 = driver.findElement(By.id("combobox-2013-inputEl"));
		element3.sendKeys("07.338.114/0001-95");
		Thread.sleep(5000);
		element3.sendKeys(Keys.ENTER);
		
		driver.findElement(By.id("fieldset-2035-legendToggle-toolEl")).click();

		element2 = driver.findElement(By.id("combobox-2052-inputEl"));
		element2.sendKeys("PESQUISA PATRIMO");
		Thread.sleep(5000);
		element2.sendKeys(Keys.ENTER);
		
		driver.findElement(By.id("button-2111-btnInnerEl")).click();
		//messagebox-1001_header--> caixa de mensagem --->  button-1005-btnIconEl --> o ok de não encontrado
	//String retorno = driver.findElement(By.id("	")).getText();
	act.moveToElement(button).moveByOffset(40, 700).click().perform();
	Thread.sleep(5000);

try
{
String test =driver.findElement(By.xpath("//*[@id=\"gridview-2090-record-10076678\"]/td[3]/div/a")).getText();
	
	System.out.println(test);
} catch (Exception e)
{
System.out.println(" Dossiê não econtrado ");}

	}

}
