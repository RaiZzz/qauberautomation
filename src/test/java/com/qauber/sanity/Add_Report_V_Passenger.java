import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by San Jose on 12/13/2016.
 */
public class Add_Report_V_Passenger {

    @Test
    public void SAU() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testwave.qabidder.net/#/page/login");
        Thread.sleep(5000);
        WebElement searchField = driver.findElement(By.xpath("//*[@id=\"exampleInputEmail1\"]"));
        searchField.clear();
        searchField.sendKeys("ramazan@bigmir.net");
        WebElement Password = driver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]"));
        Password.sendKeys("password");
        WebElement Login = driver.findElement(By.xpath("//button[contains(@type,'submit')]"));
        Login.click();
        Thread.sleep(5000);
        WebElement AddReport = driver.findElement(By.xpath("//span[contains(.,'Add Report')]"));
        AddReport.click();
        Thread.sleep(5000);
        WebElement Choose = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[2]/fieldset/div[2]/div/div/label/span"));
        Choose.click();
        WebElement ChTransport = driver.findElement(By.xpath("//div[contains(@class,'fa fa-automobile size')]"));
        ChTransport.click();
        Thread.sleep(5000);
        WebElement Passenger = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[1]/div[2]/div/label/span" + ""));
        Passenger.click();
        //WebElement NextButton = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/ul/li[2]/a/span"));
        //NextButton.click();


    }
}
