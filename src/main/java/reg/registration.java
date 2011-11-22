package reg;

/**
 * Created by IntellijJ IDEA.
 * User: doc
 * Date: 15.11.11
 * Time: 9:05
 * To change this template use File | Settings | File Templates.
 */

import com.sun.jna.ptr.ByteByReference;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.font.TrueTypeFont;


public class registration {
  public static void main(String[] args) {
    System.out.print(args[1]);
    // Create a new instance of the Firefox driver
    // Notice that the remainder of the code relies on the interface,
    // not the implementation.
    WebDriver driver = new FirefoxDriver();

    // And now use this to visit Google


        //editFormMailru(driver, "Имя", "Фамилия", "1", "январь", "1970", args[1], "qwerty12", "Номер паспорта", "123456");

        editFormTutBy(driver,args[1],"qwerty12", "Номер паспорта", "123456", "Имя","Фамилия");


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

    // Close the browser
    // driver.quit();
  }
  public static void editFormTutBy (WebDriver driver, String login, String password, String question, String answer, String firstname, String lastname) {
    driver.get("http://profile.tut.by/");

    By submitXpath = By.xpath("//html/body/table[2]/tbody/tr[2]/td[2]/div/form/p/input[2]");
    By loginId = By.id("Username");
    By checkFreeUserId = By.id("checkFreeUserBtn");
    By password1Id = By.id("Password1");
    By password2Id = By.id("Password2");
    By questionId = By.id("Question");
    By answerId = By.id("Answer");
    By firstNameId = By.id("FirstName");
    By secondtNameId = By.id("LastName");


    WebElement buttonSubmit = driver.findElement(submitXpath);

    buttonSubmit.click();

    WebElement inputLogin = driver.findElement(loginId);
    WebElement buttonCheckFree = driver.findElement(checkFreeUserId);
    WebElement inputPassword1 = driver.findElement(password1Id);
    WebElement inputPassword2 = driver.findElement(password2Id);
    WebElement inputQuestion = driver.findElement(questionId);
    WebElement inputAnswer = driver.findElement(answerId);
    WebElement inputFirstName = driver.findElement(firstNameId);
    WebElement inputLastName = driver.findElement(secondtNameId);

    inputLogin.sendKeys(login);
    buttonCheckFree.click();
    try {
      Thread.sleep(5000); //TODO worst method sad but true
      if (TextFound(driver, "Идентификатор пользователя занят")) {
        System.out.println("Email already registered, try another one");
        //driver.quit();
      }

    } catch (InterruptedException e) {
      e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    }
    inputPassword1.sendKeys(password);
    inputPassword2.sendKeys(password);
    inputQuestion.sendKeys(question);
    inputAnswer.sendKeys(answer);
    inputFirstName.sendKeys(firstname);
    inputLastName.sendKeys(lastname);

  }
  public static void editFormMailru(WebDriver driver, String name, String surname, String day, String month, String year, String email, String password, String question, String answer) {
    driver.get("http://e.mail.ru/cgi-bin/signup");

    By nameXpath = By.xpath("//form/div[2]/span[2]/input[1]");
    By surnameXpath = By.xpath("//form/div[3]/span[2]/input[1]");
    By dayXpath = By.xpath("//form/div[4]/span[2]/select[1]");
    By monthXpath = By.xpath("//form/div[4]/span[2]/select[2]");
    By yearXpath = By.xpath("//form/div[4]/span[2]/select[3]");
    By genderXpath = By.xpath("//form/div[6]/span[2]/label[1]");
    By emailXpath = By.xpath("//form/div[7]/span[2]/input");
    By passwordXpath = By.xpath("//form/div[8]/span[2]/input");
    By passwordRepeatXpath = By.xpath("//form/div[9]/span[2]/input");
    By noMobileLinkXpath = By.xpath("//form/div[11]/div[2]/span[2]/a");
    By questionXpath = By.xpath("//form/div[12]/div[2]/span[2]/select");
    By answerXpath = By.xpath("//form/div[12]/div[4]/span[2]/input");
    By submitXpath = By.xpath("//form/div[14]/span[2]/div/span/span/span/input");

    WebElement inputName = driver.findElement(nameXpath);
    WebElement inputSurname = driver.findElement(surnameXpath);
    WebElement inputDay = driver.findElement(dayXpath);
    WebElement inputMonth = driver.findElement(monthXpath);
    WebElement inputYear = driver.findElement(yearXpath);
    WebElement inputGender = driver.findElement(genderXpath);
    WebElement inputEmail = driver.findElement(emailXpath);
    WebElement inputPassword = driver.findElement(passwordXpath);
    WebElement inputRepeatPassword = driver.findElement(passwordRepeatXpath);
    WebElement linkNoMobile = driver.findElement(noMobileLinkXpath);
    WebElement inputQuestion = driver.findElement(questionXpath);
    WebElement inputAnswer = driver.findElement(answerXpath);
    WebElement buttonSubmit = driver.findElement(submitXpath);

    inputName.sendKeys(name);
    inputSurname.sendKeys(surname);
    inputDay.sendKeys(day);
    inputMonth.sendKeys(month);
    inputYear.sendKeys(year);
    inputGender.click();
    inputEmail.sendKeys(email);
    try {
      Thread.sleep(5000); //TODO worst method sad but true
      if (TextFound(driver, "Ящик с таким именем уже существует")) {
        System.out.println("Email already registered, try another one");
        //driver.quit();
      }

    } catch (InterruptedException e) {
      e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    }
    inputPassword.sendKeys(password);
    inputRepeatPassword.sendKeys(password);
    linkNoMobile.click();
    inputQuestion.sendKeys(question);
    inputAnswer.sendKeys(answer);
    buttonSubmit.click();


  }

  public static boolean TextFound (WebDriver driver, String text ) {
      return driver.findElement(By.xpath("//html/body")).getText().contains(text);
  }
}
