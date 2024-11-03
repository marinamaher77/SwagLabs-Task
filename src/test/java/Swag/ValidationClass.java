package Swag;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.time.Duration;
public class ValidationClass extends BaseClass {
    @Test(priority = 1)
    public void verify_elements() {
        Login login = new Login(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Assert.assertTrue(login.is_user_name_displayed(), "the user name element is not displayed");
        Assert.assertTrue(login.is_password_displayed(), "the password element is not displayed");
        Assert.assertTrue(login.login_button_displayed(), "the login button is not displayed");
    }
    //Data Provider provides test data
    @DataProvider(name = "login_data")
    public Object[][] login_data() {
        return new Object[][]{
                {"standard_user", "secret_sauce", true}
        };
    }
    @Test(dataProvider = "login_data", priority = 2)
    public void test_valid_data(String user_name, String password, boolean expected_data) throws InterruptedException {
        Login login = new Login(driver);
        login.enter_username(user_name);
        login.enter_password(password);
        login.click_button();
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)) ;
        Assert.assertTrue(login.title_displayed(), "the user failed to login");
        driver.navigate().back();
    }
    @DataProvider(name = "invalid_login")
    public Object[][] invalid_login() {
        return new Object[][]
                {{"marina", "12345678"}
                };
    }
    @Test(dataProvider = "invalid_login", priority = 3)
    public void enter_invalid_data(String user_name, String Password){
        Login login = new Login(driver);
        login.enter_username(user_name);
        login.enter_password(Password);
        login.click_button();
        Assert.assertEquals(login.error_message_text(), "Epic sadface: Username and password do not match any user in this service");
    }
    @DataProvider(name = "empty_username")
    public Object[][] empty_username() {
        return new Object[][]{
                {"  ", "secret_sauce"}
        };
    }
    @Test(dataProvider = "empty_username" , priority = 4)
    public void enter_empty_username(String username ,  String password){
        Login log = new Login(driver);
        log.clear_elements();
        log.enter_username(username);
        log.enter_password(password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        log.click_button();
        Assert.assertEquals(log.error_message_text() , "Epic sadface: Username and password do not match any user in this service");
    }
    @DataProvider(name = "empty_password")
    public Object [][] empty_password() {
        return new Object[][]{
                {"standard_user","  "}
        };
    }
    @Test (dataProvider = "empty_password" , priority = 5)
    public void enter_empty_pass(String username  , String Password) {
        Login log = new Login(driver);
        log.clear_elements();
        log.enter_username(username);
        log.enter_password(Password);
        log.click_button();
        Assert.assertEquals(log.error_message_text() , "Epic sadface: Username and password do not match any user in this service");
    }
}