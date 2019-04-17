package controller.sein.Selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.JOptionPane;

import org.apache.commons.collections4.functors.WhileClosure;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.jar.asm.commons.TryCatchBlockSorter;

public class PesqDossieAuto
{

	public static void tete( String user, String password, String endereco, String endereco2) throws AWTException, InterruptedException, IOException
	{
		WebDriver driver;
		int ts,te;
		WebElement element;
		WebElement element2;
		WebElement element3;

		WebElement senha;

		WebElement button;
		//File file = new File("Lista.txt");
    	String nome = "";
    	String conteudo;
		String test = null;
		ArrayList<String> cpfcnpj = new ArrayList<String>();
		ArrayList<String> resposta = new ArrayList<String>();
	 String loginuser, pass;
	 
 
	loginuser=  user;
	pass = password;
	
try {
    FileReader arq = new FileReader(endereco);
    BufferedReader lerArq = new BufferedReader(arq);

    String linha = lerArq.readLine(); // lê a primeira linha
// a variável "linha" recebe o valor "null" quando o processo
// de repetição atingir o final do arquivo texto
    cpfcnpj.add(linha);

    while (linha != null) {
      System.out.printf("%s\n", linha);

      linha = lerArq.readLine(); // lê da segunda até a última linha
      cpfcnpj.add(linha);
    }

    arq.close();
  } catch (IOException e) {
      System.err.printf("Erro na abertura do arquivo: %s.\n",
        e.getMessage());
  }
	/**do 
	{
		contin = JOptionPane.showConfirmDialog(null,"deseja inserir outro CPF/CNPJ? ");
		f = JOptionPane.showInputDialog(null, "insira outro CPF/CNPJ a ser pesquisado: ");
		cpfcnpj.add(f);
	}while (contin == 0);*/
	System.out.println(cpfcnpj.size());
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		
		ChromeOptions chrome = new ChromeOptions();
		chrome.setHeadless(false);
		driver = new ChromeDriver(chrome);

		driver.get("https://sapiens.agu.gov.br/login");
		element = driver.findElement(By.name("username"));
		senha = driver.findElement(By.name("password"));

		element.sendKeys(loginuser);
		senha.sendKeys(pass);
		driver.findElement(By.id("button-1019-btnInnerEl")).click();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("splitbutton-1011")));
		button = driver.findElement(By.id("splitbutton-1011"));
		Actions act = new Actions(driver);
		Thread.sleep(8000);
		FileWriter arq2 = new FileWriter(endereco2);

		for (int i = 0; i < cpfcnpj.size()-1; i++)
		{Thread.sleep(5000);
		act.moveToElement(button).moveByOffset(40, 0).click().perform();
		
		driver.findElement(By.id("menuitem-1016-textEl")).click();
		
		

		
			element3 = driver.findElement(By.id("combobox-2013-inputEl"));
			element3.clear();
			element3.sendKeys(cpfcnpj.get(i));
			Thread.sleep(5000);
			element3.sendKeys(Keys.ENTER);
			
			driver.findElement(By.id("fieldset-2035-legendToggle-toolEl")).click();
if(i==0) {
			element2 = driver.findElement(By.id("combobox-2052-inputEl"));
			element2.sendKeys("PESQUISA PATRIMO");
			Thread.sleep(5000);
			element2.sendKeys(Keys.ENTER);}
			
			driver.findElement(By.id("button-2111-btnInnerEl")).click();
			//messagebox-1001_header--> caixa de mensagem --->  button-1005-btnIconEl --> o ok de não encontrado
		//String retorno = driver.findElement(By.id("	")).getText();
		act.moveToElement(button).moveByOffset(40, 700).click().perform();
		Thread.sleep(5000);

		try
		{
			boolean exist = driver.findElement(By.xpath("//*[@id=\"gridview-2090\"]")).isEnabled();
			//*[@id="PPastaResultadoFC"]
			if(exist==true) {
				//*[@id="gridview-2090-record-12351705"]/td[3]/div
				//
				
				//*[@id="gridview-2090-record-10076678"]/td[3]/div
				//gridcolumn-2073-titleEl
				//*[@id="gridview-2090-record-12351705"]/td[3]
				//gridview-2090
			//driver.findElement(By.xpath("//*[@id=\"gridview-2090-record-10076678\"]/td[3]/div/a")).get;
			//	System.out.println(te);
				// te =driver.findElement(By.xpath("//*[@id=\"gridview-2090-record-10076678\"]/td[3]/div/a")).getLocation().y;
				//test= act.moveToElement(button).moveByOffset(177, 814).getClass().getName();
				test=  driver.findElement(By.xpath("//*[@id=\"gridview-2090\"]")).getText();
					//System.out.println(test);
				test = test.substring(10, 31);
				String esta = test.replace("\n","");  
				//System.out.println(test);
				 
			System.out.println(test);
				 resposta.add(esta);
				

				 //------------------------->>> colocar para salvar o arquivo aqui
			}
			else if (exist==false) {
				driver.findElement(By.id("button-1005-btnIconEl")).click();
				System.out.println("dossiê não encontrado");
				
				//00411.134723/2017-26
			}
			
			//System.out.println(test);
		} catch (Exception e)
		{
		System.out.println(" Dossiê não econtrado ");
		driver.findElement(By.id("button-1005-btnIconEl")).click();
//		act.moveToElement(button).moveByOffset(40, 0).click().perform();
		
		//*[@id="acervoNovo-itemEl"]
		//te =driver.findElement(By.xpath("//*[@id=\"acervoNovo-arrowEl\"]")).getLocation().y;
		//ts =driver.findElement(By.xpath("//*[@id=\"acervoNovo-arrowEl\"]")).getLocation().x;
//System.out.println(te);
//System.out.println(ts);
		/**
		button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("splitbutton-1011")));
		act = new Actions(driver);
		Thread.sleep(8000);
		act.moveToElement(button).moveByOffset(40, 0).click().perform();
		Thread.sleep(2000);
		act.moveByOffset(0, 30).perform();
		Thread.sleep(2000);
		driver.findElement(By.id("menuitem-1014-textEl")).click();
		Thread.sleep(2000);
		//driver.findElement(By.id("radiofield-2253-inputEl")).click(); mudou a variável
		driver.findElement(By.xpath("//*[@id=\"radiofield-2457-inputEl\"]")).click();
		//element3 = driver.findElement(By.id("combobox-2254-inputEl"));
		element3 = driver.findElement(By.xpath("//*[@id=\"combobox-2458-inputEl\"]"));
		element3.sendKeys("00411.134723/2017-26");
		Thread.sleep(2000);
		element3.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		
		driver.findElement(By.id("button-2286-btnInnerEl")).click();

		Thread.sleep(5000);
		driver.findElement(By.id("button-1535")).click();
		Thread.sleep(2000);
		
		element3 = driver.findElement(By.id("combobox-2361-inputEl"));
		element3.sendKeys(cpfcnpj.get(i));
		Thread.sleep(2000);
		element3.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		element2= driver.findElement(By.id("combobox-2367-inputEl"));
		element2.click();
		element2.sendKeys("REQUERIDO (PÓLO PASSIVO)");
		Thread.sleep(2000);
		element2.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.id("button-2371-btnInnerEl")).click();
		Thread.sleep(5000);

		driver.findElement(By.id("button-2372-btnInnerEl")).click();
		
		
		test=  driver.findElement(By.xpath("//*[@id=\"displayfield-1448-bodyEl\"]")).getText();
		System.out.println(test);
		resposta.add(test);
		}**/
		resposta.add("sem dossie SEIN");
		

		}
		 conteudo = resposta.get(i);
		    conteudo += "\r\n";
		    arq2.write(conteudo);
        
			}
		 /**try	{
//FileWriter arq2 = new FileWriter(endereco2);
	           
	            
	            for (int i=0; i<resposta.size();i++)
	    		{
	    		
	    		
	            
	           
	    conteudo = resposta.get(i);
	    conteudo += "\r\n";
	    arq2.write(conteudo);
	    		}
	            	
	            
	            arq2.close();
	        }catch (IOException e)  {
	                e.printStackTrace();
	        }*/
			
		 arq2.close();	
JOptionPane.showMessageDialog(null, "A Pesquisa foi concluída, favor verificar o arquivo de pesquisa", "CAMALEÃO SEIN", JOptionPane.WARNING_MESSAGE);
	driver.close();
	}
		
}
