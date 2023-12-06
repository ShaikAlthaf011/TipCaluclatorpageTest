package TipcaluclatorpageTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TipCaluclatorTestPage {
    @Test
	public void performcalculation(){
		   System.setProperty("webdriver.chrome.driver","C://chromedriver.exe");
	        WebDriver driver=new ChromeDriver();
	        driver.get("https://qatipcalc.ccbp.tech/");
	        driver.manage().window().maximize();
	        //Test the tip calculation.:
	        driver.findElement(By.cssSelector("input[id^='bill']")).sendKeys("1000");
	        driver.findElement(By.cssSelector("input[id^='percentage']")).sendKeys("12");
	        driver.findElement(By.cssSelector("button[class^='btn']")).click();
	        WebElement el1=driver.findElement(By.cssSelector("p[id*='tip']"));
	        boolean text1=el1.getText().contains("120.0");
	        WebElement el2=driver.findElement(By.cssSelector("p[id*='total']"));
	        boolean text2= el2.getText().contains("1120.00");
	        if(text1&&text2){
	            System.out.println("Tip Calculated Correctly");
	        }else{
	            System.out.println("Tip Calculated Incorrectly");
	        }
	        //Test the display of error message for no inputs.
	        driver.findElement(By.cssSelector("input[id^='percentage']")).clear();
	        driver.findElement(By.cssSelector("button[class^='btn']")).click();
	       WebElement el7 =driver.findElement(By.cssSelector("p[class='error-message text-center']"));
	       String Str1=el7.getText();
	       String Str2="Please Enter a Valid Input.";
	       if(Str1.equals(Str2)){
	           System.out.println("Error message displayed for no input");
	       }else{
	           System.out.println("Error message missing for no input.");
	       }
	       driver.findElement(By.cssSelector("input[id^='percentage']")).sendKeys("10f.0");
	        driver.findElement(By.cssSelector("button[class^='btn']")).click();
	        WebElement elj=driver.findElement(By.cssSelector("p[id='errorMessage']"));
	        String stre= elj.getText();
	        String Str12="Please Enter a Valid Input.";
	        if(stre.equals(Str12)){
	            System.out.println("Error message displayed for invalid input");
	        }else{
	            System.out.println("Error message missing for invalid input");
	        }
	        driver.quit();

	}

}
