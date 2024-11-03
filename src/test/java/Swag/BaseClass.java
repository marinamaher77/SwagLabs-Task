package Swag;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
public class BaseClass {
   protected  WebDriver driver ;
    @BeforeTest
    void SetupPage()
    {
      driver=new EdgeDriver();
      driver.get("https://www.saucedemo.com/v1/");
      driver.manage().window().maximize();
    }
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
