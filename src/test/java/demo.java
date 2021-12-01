

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.*;

public class demo {

    WebDriver driver;
    public void browserActivity(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\uswa.shamim\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        //driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
        driver.get("http://automationpractice.com/index.php");

    }


    public void logIn() throws InterruptedException {
        WebElement signIn;
        signIn = driver.findElement(By.linkText("Sign in"));
        signIn.click();
        //driver.findElement(By.xpath("//input[@name='email_create']")).sendKeys("uswashahmim777@gmail.com");
        //".cssSelector("[id='email_create']")).click();

        //create account(email enter)
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        driver.findElement(By.cssSelector("[name='email_create']")).sendKeys("uswashahmim778@gmail.com");
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[1]/form/div/div[3]/button/span")).click();
        sleep(2000);
        //create account(registration form)
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        driver.findElement(By.xpath("//*[@id='account-creation_form']/div[1]/div[1]/div[2]/label")).click();
        driver.findElement(By.name("customer_firstname")).sendKeys("uswah");
        driver.findElement(By.name("customer_lastname")).sendKeys("shamim");
        driver.findElement(By.name("passwd")).sendKeys("48900uswah");
        //driver.findElement(By.id("days")).click();
        Select drpDay = new Select(driver.findElement(By.name("days")));
        drpDay.selectByValue("17");
        Select drpMonth = new Select(driver.findElement(By.name("months")));
        drpMonth.selectByValue("3");
        Select drpYear = new Select(driver.findElement(By.name("years")));
        drpYear.selectByValue("1999");
        driver.findElement(By.id("optin")).click();
        driver.findElement(By.id("company")).sendKeys("10pearls");
        driver.findElement(By.id("address1")).sendKeys("PECHS block 6 parsa tower 9th floor");
        driver.findElement(By.id("address2")).sendKeys("PECHS block 6 parsa tower 8th floor");
        driver.findElement(By.id("city")).sendKeys("karachi");
        Select drpState = new Select(driver.findElement(By.name("id_state")));
        drpState.selectByValue("9");
        driver.findElement(By.id("postcode")).sendKeys("74600");
        //Select drpCountry = new Select(driver.findElement(By.name("id_country")));
        //drpCountry.selectByVisibleText("United State");
        driver.findElement(By.id("other")).sendKeys("abc");
        driver.findElement(By.id("phone")).sendKeys("03152914647");
        driver.findElement(By.id("phone_mobile")).sendKeys("03320374386");
        driver.findElement(By.id("alias")).sendKeys("PECHS block 6 karachi");
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[4]/button/span")).click();
        sleep(2000);
        driver.findElement(By.name("submitAccount")).click();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        //String userText=driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).getText();
        String userText = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).getText();

        // Validate that user has created
        if (userText.contains("uswahshamim")) {
            System.out.println("User Verified,Test case Passed");
        } else {
            System.out.println("User Verification Failed,Test case Failed");
        }
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
        //signout
        // driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
        //driver.findElement(By.linkText("Sign out")).click();
        //driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
        //signup(enter email and password)
        //WebElement email;
        //driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
        //email = driver.findElement(By.id("email"));
        //email.sendKeys("uswahshamim772@gmail.com");
        //driver.findElement(By.id("passwd")).sendKeys("48900uswah");
        //Thread.sleep(2000);
        //driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[2]/form/div/p[2]/button/span")).click();
        //driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
        //forgot password
        //driver.navigate().back();
        //driver.findElement(By.linkText("Forgot your password?")).click();
        //email.sendKeys("uswahshamim770@gmail.com");
        //driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/fieldset/p/button/span")).click();
        //driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/ul/li/a/span")).click();
        //}
    }
    public void searchItem()throws InterruptedException{
        sleep(2000);
        driver.findElement(By.name("search_query")).sendKeys("Printed");
        sleep(5000);
        List<WebElement> list = driver.findElements(By.xpath("//ul//li[contains(@class, 'ac_')]"));
        //System.out.println(list.size());
        for (int i = 0; i< list.size(); i++){
            driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
            String listItem = list.get(i).getText();
            //element.get(index) get elements 1 by 1 from array
            //getText() returns String value of text associated to that swing object, GetText returns the text from the single-line text field
            //System.out.println(listItem);
            if (listItem.contains("Printed Chiffon Dress")) {
                driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
                //ArrayList contains() method in Java is used for checking if the specified element exists in the given list or not.
                list.get(i).click();
                break;
            }

        }
    }

    public void fetchAndPrint()throws InterruptedException{
        String fetchPrice=driver.findElement(By.id("our_price_display")).getText();
        System.out.println(fetchPrice);
        String expPrice = "$16.40";
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        Assert.assertEquals(expPrice,fetchPrice);
    }
    public void addToCart()throws InterruptedException{
        //Change quantity by 2
        driver.findElement(By.id("quantity_wanted")).clear();
        driver.findElement(By.id("quantity_wanted")).sendKeys("3");
        sleep(2000);

        //Select size as M
        Select drpSize = new Select(driver.findElement(By.name("group_1")));
        drpSize.selectByValue("2");
        sleep(2000);

        //Select Color
        driver.findElement(By.id("color_15")).click();

        //Click on add to cart

        driver.findElement(By.xpath("//*[@id='add_to_cart']/button/span")).click();
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
        //Click on proceed
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")).click();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        //1st step of Checkout page Proceed
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/p[2]/a[1]/span")).click();
        driver.findElement(By.name("messgae")).sendKeys("abc");
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
        //2nd step of signin
        //WebElement email;
        sleep(2000);
        driver.findElement(By.id("email")).sendKeys("uswahshamim777@gmail.com");
        sleep(2000);
        driver.findElement(By.id("passwd")).sendKeys("48900uswah");
        sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[2]/form/div/p[2]/button/span")).click();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        //3rd step of Agree terms&Conditions
        driver.findElement(By.name("cgv")).click();
        driver.findElement(By.xpath("//*[@id='form']/p/button/span")).click();
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);

        //4th step of Click on Payby Check
        driver.findElement(By.linkText("Pay by check.")).click();
        //5th step of order confirmation
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/form/p/button/span")).click();
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);

        //Get Text and store it in a astring
        String ConfirmationText = driver.findElement(By.xpath("//div[@id='center_column']/p[@class='alert alert-success']")).getText();
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
        // Verify that Product is being ordered
        if (ConfirmationText.contains("complete")) {
            System.out.println("Order Completed: Test Case Passed");

        } else {
            System.out.println("Order Not Successfull: Test Case Failed");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        demo obj= new demo();
        obj.browserActivity();
        //obj.logIn();
        obj.searchItem();
        obj.fetchAndPrint();
        obj.addToCart();
    }
}
