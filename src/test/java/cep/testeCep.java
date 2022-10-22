package cep;


import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;
import java.time.Duration;

public class testeCep {
    WebDriver driver;

    @Test
    public void testecep()  {
        driver = new ChromeDriver();
        driver.get("https://buscacepinter.correios.com.br/app/endereco/index.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("endereco")).sendKeys("06070130");
        Select select = new Select(driver.findElement(By.id("tipoCEP")));
        select.selectByVisibleText("Localidade/Logradouro");
        driver.findElement(By.id("btn_pesquisar")).click();

        String txt = driver.findElement(By.xpath("//*[@id=\"resultado-DNEC\"]/tbody/tr/td[1]")).getText();

        Assert.assertEquals("texto invalido", "Rua Joaquim Jacinto", txt);

    }
//    @After
//    public void fechar(){
//        driver.quit();
    }


