package Swag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Login {
  WebDriver driver;
  //Locators
 By username_element = By.id("user-name");
 By password_element = By.id("password");
 By login_element = By.id("login-button");
 By error_message = By.xpath("//*[@id=\"login_button_container\"]/div/form/h3");
 By page_title = By.className("app_logo");
 //Constructor
 public Login(WebDriver driver)
 {
     this.driver = driver;
 }
 //Actions
public void enter_username(String username )
{
driver.findElement(username_element).sendKeys(username);
}
public void enter_password(String password)
    {
        driver.findElement(password_element).sendKeys(password);
    }
    public void click_button()
    {
     driver.findElement(login_element).click();
    }
    public void get_title()
    {
      System.out.println(  driver.findElement(page_title).getText());
    }
    public boolean is_user_name_displayed()
    {
        return driver.findElement(username_element).isDisplayed();
    }
    public boolean is_password_displayed()
    {
        return driver.findElement(password_element).isDisplayed();
    }
    public boolean login_button_displayed()
    {
        return driver.findElement(login_element).isDisplayed();
    }
    public boolean title_displayed()
    {
        return driver.findElement(page_title).isDisplayed();
    }
    public String error_message_text()
    {
        return driver.findElement(error_message).getText();
    }
    public void clear_elements()
    {
        driver.findElement(username_element).clear();
        driver.findElement(password_element).clear();
    }
}
