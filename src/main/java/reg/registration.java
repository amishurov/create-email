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
    WebDriver driver = new FirefoxDriver();
    String domain = args[0];
    //System.out.print(args[1]);
    if (domain.equals("-t")) {
      editFormTutBy(driver,args[1],"qwerty12", "Номер паспорта", "123456", "Имя","Фамилия", "1" , "января", "1970" );
    } else if (domain.equals("-m")) {
      editFormMailru(driver, "Имя", "Фамилия", "1", "январь", "1970", args[1], "qwerty12", "Номер паспорта", "123456");
    } else if (domain.equals("-a")) {
      editFormMailinator ();      
    } else {
      System.out.println("add help message");
      driver.close();
      driver.close();
    }
    
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

  private static void editFormMailinator() {
  }

  public static void editFormTutBy (WebDriver driver, String login, String password, String question, String answer, String firstname, String secondname, String day, String month, String year) {
    driver.get("http://profile.tut.by/");

    By submitXpath = By.xpath("//html/body/table[2]/tbody/tr[2]/td[2]/div/form/p/input[2]");
    By loginId = By.id("Username");
    By checkFreeUserId = By.id("checkFreeUserBtn");
    By password1Id = By.id("Password1");
    By password2Id = By.id("Password2");
    By questionId = By.id("Question");
    By answerId = By.id("Answer");
    By firstNameId = By.id("FirstName");
    By secondtNameId = By.id("SecondName");
    By dayId = By.id("_3_1");
    By monthId = By.id("_3_2");
    By yearId = By.id("_3_3");
    By ap_wordId = By.id("ap_word");

    driver.findElement(submitXpath).click();
    driver.findElement(loginId).sendKeys(login);
    driver.findElement(checkFreeUserId).click();
    try {
      Thread.sleep(5000); //TODO worst method sad but true
      if (TextFound(driver, "Идентификатор пользователя занят")) {
        System.out.println("Email already registered, try another one");
        //driver.quit();
      }

    } catch (InterruptedException e) {
      e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    }
    driver.findElement(password1Id).sendKeys(password);
    driver.findElement(password2Id).sendKeys(password);
    driver.findElement(questionId).sendKeys(question);
    driver.findElement(answerId).sendKeys(answer);
    driver.findElement(firstNameId).sendKeys(firstname);
    driver.findElement(secondtNameId).sendKeys(secondname);
    driver.findElement(dayId).sendKeys(day);
    driver.findElement(monthId).sendKeys(month);
    driver.findElement(yearId).sendKeys(year);
    driver.findElement(ap_wordId).click();

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

    driver.findElement(nameXpath).sendKeys(name);
    driver.findElement(surnameXpath).sendKeys(surname);
    driver.findElement(dayXpath).sendKeys(day);
    driver.findElement(monthXpath).sendKeys(month);
    driver.findElement(yearXpath).sendKeys(year);
    driver.findElement(genderXpath).click();
    driver.findElement(emailXpath).sendKeys(email);
    try {
      Thread.sleep(5000); //TODO worst method sad but true
      if (TextFound(driver, "Ящик с таким именем уже существует")) {
        System.out.println("Email already registered, try another one");
        //driver.quit();
      }

    } catch (InterruptedException e) {
      e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    }
    driver.findElement(passwordXpath).sendKeys(password);
    driver.findElement(passwordRepeatXpath).sendKeys(password);
    driver.findElement(noMobileLinkXpath).click();
    driver.findElement(questionXpath).sendKeys(question);
    driver.findElement(answerXpath).sendKeys(answer);
    driver.findElement(submitXpath).click();


  }

  public static boolean TextFound (WebDriver driver, String text ) {
      return driver.findElement(By.xpath("//html/body")).getText().contains(text);
  }
}
