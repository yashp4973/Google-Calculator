package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01() throws InterruptedException {
        System.out.println("Start Test case: testCase01 - Homepage URL and Initial Display");
        driver.get("https://www.google.com");
        String url = driver.getCurrentUrl();
        if(url.contains("google")){
            System.out.println("URL contains google");
        }else{
            System.out.println("URL doesnot contains google");
        }
        WebElement searchBar = driver.findElement(By.id("APjFqb"));
        searchBar.sendKeys("calculator");
        searchBar.sendKeys(Keys.ENTER);

        WebElement zeroLocator = driver.findElement(By.id("cwos"));
        if(zeroLocator.isDisplayed()){
            System.out.println("Calculator is Displayed");
        }else{
            System.out.println("Calculator is not Displayed");
        }
        String initialDisplay = zeroLocator.getText();
        if(initialDisplay.equals("0")){
            System.out.println("Initial Displayed value is 0");
        }else{
            System.out.println("Initial Displayed value is not 0");
        }
        Thread.sleep(2000);
        System.out.println("end Test case: testCase01");
    }


    public  void testCase02() throws InterruptedException {
        System.out.println("Start Test case: testCase02 - Verify that the Google Calculator can perform addition and subtraction correctly.");
        driver.get("https://www.google.com");
        WebElement searchBar = driver.findElement(By.id("APjFqb"));
        searchBar.sendKeys("calculator");
        searchBar.sendKeys(Keys.ENTER);

        WebElement clearResult = driver.findElement(By.xpath("//table[@class='ElumCf']//div[text()='AC']"));
        clearResult.click();

        int x = 5;
        int y = 7;
        WebElement firstNumber = driver.findElement(By.xpath("//table[@class='ElumCf']//div[text()='"+x+"']"));
        firstNumber.click();
        WebElement addButton = driver.findElement(By.xpath("//table[@class='ElumCf']//div[text()='+']"));
        addButton.click();
        WebElement secondNumber = driver.findElement(By.xpath("//table[@class='ElumCf']//div[text()='"+y+"']"));
        secondNumber.click();
        WebElement equalButton = driver.findElement(By.xpath("//table[@class='ElumCf']//div[text()='=']"));
        equalButton.click();
        Thread.sleep(2000);
        
        WebElement zeroLocator = driver.findElement(By.id("cwos"));
        int expected = x+y;
        String actual = zeroLocator.getText();
        if(actual.equals(String.valueOf(expected))){
            System.out.println("Sum is coming correctly and the sum = " + expected);
        }

        clearResult.click();

        driver.findElement(By.xpath("//table[@class='ElumCf']//div[text()='1']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//table[@class='ElumCf']//div[text()='5']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@aria-label='minus']")).click();
        driver.findElement(By.xpath("//table[@class='ElumCf']//div[text()='8']")).click();
        equalButton.click();
        Thread.sleep(2000);
    
        if(zeroLocator.getText().equals("7")){
            System.out.println("Subtract is coming correctly and the subtract = " + zeroLocator.getText());
        }


        Thread.sleep(2000);
        System.out.println("end Test case: testCase02");
    }


    public  void testCase03() throws InterruptedException {
        System.out.println("Start Test case: testCase03 - Verify the Functionality of the All Clear (AC) Button and Multiplication Operation");
        driver.get("https://www.google.com");
        WebElement searchBar = driver.findElement(By.id("APjFqb"));
        searchBar.sendKeys("calculator");
        searchBar.sendKeys(Keys.ENTER);

        WebElement clearResult = driver.findElement(By.xpath("//table[@class='ElumCf']//div[text()='AC']"));
        clearResult.click();

        driver.findElement(By.xpath("//table[@class='ElumCf']//div[text()='1']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//table[@class='ElumCf']//div[text()='0']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@aria-label='multiply']")).click();
        driver.findElement(By.xpath("//table[@class='ElumCf']//div[text()='3']")).click();
        WebElement equalButton = driver.findElement(By.xpath("//table[@class='ElumCf']//div[text()='=']"));
        equalButton.click();
        Thread.sleep(2000);
        
        WebElement zeroLocator = driver.findElement(By.id("cwos"));
        if(zeroLocator.getText().equals("30")){
            System.out.println("Multiply is coming correctly and the Result is  = " + zeroLocator.getText());
        }
        Thread.sleep(2000);
        clearResult.click();
        if(zeroLocator.getText().equals("0")){
            System.out.println("Display is cleared Now !!!!");
        }

        Thread.sleep(2000);
        System.out.println("end Test case: testCase03");
    }



    public  void testCase04() throws InterruptedException {
        System.out.println("Start Test case: testCase04 - Verify that the Google Calculator can perform division correctly.");
        driver.get("https://www.google.com");
        WebElement searchBar = driver.findElement(By.id("APjFqb"));
        searchBar.sendKeys("calculator");
        searchBar.sendKeys(Keys.ENTER);

        WebElement clearResult = driver.findElement(By.xpath("//table[@class='ElumCf']//div[text()='AC']"));
        clearResult.click();

        driver.findElement(By.xpath("//table[@class='ElumCf']//div[text()='2']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//table[@class='ElumCf']//div[text()='0']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@aria-label='divide']")).click();
        driver.findElement(By.xpath("//table[@class='ElumCf']//div[text()='4']")).click();
        WebElement equalButton = driver.findElement(By.xpath("//table[@class='ElumCf']//div[text()='=']"));
        equalButton.click();
        Thread.sleep(2000);
        
        WebElement zeroLocator = driver.findElement(By.id("cwos"));
        if(zeroLocator.getText().equals("5")){
            System.out.println("Divide is coming correctly and the Result is  = " + zeroLocator.getText());
        }

        Thread.sleep(2000);
        System.out.println("end Test case: testCase04");
    }
















}
