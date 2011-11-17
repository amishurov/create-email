package reg;

/**
 * Created by IntellijJ IDEA.
 * User: doc
 * Date: 15.11.11
 * Time: 9:05
 * To change this template use File | Settings | File Templates.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class registration {
  public static void main(String[] args) {
    // Create a new instance of the Firefox driver
    // Notice that the remainder of the code relies on the interface,
    // not the implementation.
    WebDriver driver = new FirefoxDriver();

    // And now use this to visit Google
    driver.get("http://e.mail.ru/cgi-bin/signup");
    editForm(driver, "Имя", "Фамилия", "1", "январь", "1970", "master.of.puppets");

    // Alternatively the same thing can be done like this
    // driver.navigate().to("http://www.google.com");

    // Find the text input element by its name
    // WebElement element = driver.findElement(By.name("q"));

    // Enter something to search for
    // element.sendKeys("Cheese!");

    // Now submit the form. WebDriver will find the form for us
    // from the element
    // element.submit();

    // Check the title of the page
    // System.out.println("Page title is: " + driver.getTitle());

    // Google's search is rendered dynamically with JavaScript.
    // Wait for the page to load, timeout after 10 seconds
    /*(new WebDriverWait(driver, 10)).until(new
    ExpectedCondition<Boolean>() {
        public Boolean apply(WebDriver d) {
            return d.getTitle().toLowerCase().startsWith("cheese!");
        }
    });
     */
    // Should see: "cheese! - Google Search"

    System.out.println("Page title is: " + driver.getTitle());

    // Close the browser
    // driver.quit();
  }

  public static void editForm(WebDriver driver, String name, String surname, String day, String month, String year, String email) {
    By nameXpath = By.xpath("//form/div[2]/span[2]/input[1]");
    By surnameXpath = By.xpath("//form/div[3]/span[2]/input[1]");
    By dayXpath = By.xpath("//form/div[4]/span[2]/select[1]");
    By monthXpath = By.xpath("//form/div[4]/span[2]/select[2]");
    By yearXpath = By.xpath("//form/div[4]/span[2]/select[3]");
    By genderXpath = By.xpath("//form/div[6]/span[2]/label[1]");
    By emailXpath = By.xpath("//form/div[7]/span[2]/input");

    WebElement inputName = driver.findElement(nameXpath);
    WebElement inputSurname = driver.findElement(surnameXpath);
    WebElement inputDay = driver.findElement(dayXpath);
    WebElement inputMonth = driver.findElement(monthXpath);
    WebElement inputYear = driver.findElement(yearXpath);
    WebElement inputGender = driver.findElement(genderXpath);
    WebElement inputEmail = driver.findElement(emailXpath);

    inputName.sendKeys(name);
    inputSurname.sendKeys(surname);
    inputDay.sendKeys(day);
    inputMonth.sendKeys(month);
    inputYear.sendKeys(year);
    inputGender.click();
    inputEmail.sendKeys(email);
    try {
      Thread.sleep(10000); //TODO worst method sad but true

    } catch (InterruptedException e) {
      e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    }
    TextFound(driver, "Ящик с таким именем уже существует");
  }
  public static void TextFound (WebDriver driver, String text ) {
     WebElement myDynamicElement = (new WebDriverWait(driver, 10))
  .until(new ExpectedCondition<WebElement>(){
	@Override
	public WebElement apply(WebDriver d) {
		return d.findElement(By.id("myDynamicElement"));
	}});
    if (driver.findElement(By.xpath("//html/body")).getText().contains(text)) {
    System.out.println("email already registered");
    } else {
    System.out.println("fuckup");
    }
    ;


  }


}
