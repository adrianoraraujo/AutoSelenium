package controller.sein.Selenium;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javafx.stage.FileChooser;

public class Methods
{
	ArrayList<String> [] Login;

public void pegarUsuario( String user, String password)	{
	
	Login[0].add(user);
	Login[1].add(password);

}


public String openArquivo() {
	String endereco="C:";
	JFileChooser file = new JFileChooser(); 
    file.setFileSelectionMode(JFileChooser.FILES_ONLY);
    int i= file.showSaveDialog(null);
  if (i==1){
      
  } else {
      File arquivo = file.getSelectedFile();
      endereco = arquivo.getPath();
    System.out.println(endereco);
  }

return endereco;
}

	
	
}
