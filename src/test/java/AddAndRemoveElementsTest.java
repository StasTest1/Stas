import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddAndRemoveElementsTest {

  @Test
  public void addAndRemoveElementTest() {

    System.setProperty("webdriver.chrome.driver", "C:\\Users\\stas3\\Downloads\\chromedriver.exe");
    ChromeDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
    WebElement addElementBtn = driver.findElement(By.xpath("//input[@type]"));
    addElementBtn.click();
    addElementBtn.click();
    driver.findElement(By.xpath("//button[@onclick='addElement()']"));
    int deleteBtnsBeforeRemoval = driver.findElements(By.xpath("//button[@onclick='deleteElement()']")).size();
    driver.findElements(By.xpath("//button[@onclick='deleteElement()']")).get(0).click();
    int deleteBtnsAfterRemoval = driver.findElements(By.xpath("//button[@onclick='deleteElement()']")).size();
    Assert.assertNotEquals(deleteBtnsBeforeRemoval,deleteBtnsAfterRemoval,"Button have not been removed");
    
  }

}
