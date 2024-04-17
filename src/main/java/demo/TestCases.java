package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

    public TestCases() {
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

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() throws InterruptedException {
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");
        Thread.sleep(3000);
        String currentURL = driver.getCurrentUrl();
        if (currentURL.contains("google")) {
            System.out.println("Google is in the URL.");
        } else {
            System.out.println("Google is not in the URL.");
        }

        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
        searchBox.sendKeys("calculator");
        Thread.sleep(1000);
        searchBox.submit();

        // Wait for the calculator to loadcc
        Thread.sleep(3000); // Adjust wait time as necessary

        // Verify that the Google Calculator loads
        WebElement calculator = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
        if (calculator.getText().contains("calculator")) {
            System.out.println("Google Calculator loaded successfully.");
        } else {
            System.out.println("Google Calculator not loaded.");
        }

        // Confirm that the initial display shows zero(0)
        WebElement display = driver.findElement(By.xpath("//*[@id=\"cwos\"]"));
        if (display.getText().contains("0")) {
            System.out.println("Initial display shows zero(0).");
        } else {
            System.out.println("Initial display does not show zero(0).");
        }

        System.out.println("end Test case: testCase01");
    }

    public void testCase02() throws InterruptedException {
        System.out.println("Start Test case: testCase02");

        Thread.sleep(3000); // Adjust wait time as necessary

        // Perform addition operation: 5 + 7
        WebElement addButton = driver.findElement(By.xpath(
                "//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[3]/td[2]/div/div"));
        addButton.click();
        Thread.sleep(1000);
        WebElement plusButton = driver.findElement(By.xpath(
                "//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[5]/td[4]/div/div"));
        plusButton.click();
        Thread.sleep(1000);
        WebElement secondNumber = driver.findElement(By.xpath(
                "//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[2]/td[1]/div/div"));
        secondNumber.click();
        Thread.sleep(1000);
        WebElement equalsButton = driver.findElement(By.xpath(
                "//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[5]/td[3]/div/div"));
        equalsButton.click();
        Thread.sleep(2000);

        // Verify the result of addition operation
        WebElement additionResult = driver.findElement(By.className("qv3Wpe"));
        if (additionResult.getText().contains("12")) {
            System.out.println("Addition operation result is correct: 5 + 7 = 12");
        } else {
            System.out.println("Addition operation result is incorrect.");
        }

        // Perform subtraction operation: 15 - 8
        WebElement clearButton = driver.findElement(By.xpath(
                "//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[1]/td[4]/div/div[1]"));
        clearButton.click();
        Thread.sleep(1000);
        WebElement firstNumber = driver.findElement(By.xpath(
                "//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[4]/td[1]/div/div"));
        firstNumber.click();
        // Thread.sleep(1000);
        WebElement fiveButton = driver.findElement(By.xpath(
                "//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[3]/td[2]/div/div"));
        fiveButton.click();
        Thread.sleep(1000);
        WebElement minusButton = driver.findElement(By.xpath(
                "//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[4]/td[4]/div/div"));
        minusButton.click();
        Thread.sleep(1000);
        WebElement thirdNumber = driver.findElement(By.xpath(
                "//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[2]/td[2]/div/div"));
        thirdNumber.click();
        Thread.sleep(1000);
        equalsButton.click(); // a;ready found

        // Verify the result of subtraction operation
        WebElement subtractionResult = driver.findElement(By.className("qv3Wpe"));
        if (subtractionResult.getText().contains("7")) {
            System.out.println("Subtraction operation result is correct: 15 - 8 = 7");
        } else {
            System.out.println("Subtraction operation result is incorrect.");
        }

        System.out.println("End Test case: testCase02");
    }

    public void testCase03() throws InterruptedException {
        System.out.println("Start Test case: testCase03");

        WebElement clearButton = driver.findElement(By.xpath(
                "//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[1]/td[4]/div/div[1]"));
        clearButton.click();
        Thread.sleep(1000);
        WebElement firstNumber = driver.findElement(By.xpath(
                "//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[4]/td[1]/div/div"));
        firstNumber.click();
        // Thread.sleep(1000);
        WebElement zeroButton = driver.findElement(By.xpath(
                "//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[5]/td[1]/div/div"));
        zeroButton.click();
        Thread.sleep(1000);
        WebElement mulButton = driver.findElement(By.xpath(
                "//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[3]/td[4]/div/div"));
        mulButton.click();
        Thread.sleep(1000);
        WebElement thirdNumber = driver.findElement(By.xpath(
                "//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[4]/td[3]/div/div"));
        thirdNumber.click();
        Thread.sleep(1000);
        WebElement equalsButton = driver.findElement(By.xpath(
                "//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[5]/td[3]/div/div"));
        equalsButton.click();
        Thread.sleep(2000);

        // Verify the result of subtraction operation
        WebElement subtractionResult = driver.findElement(By.className("qv3Wpe"));
        if (subtractionResult.getText().contains("30")) {
            System.out.println("Multiplication operation result is correct: 10 * 3 = 30");
        } else {
            System.out.println("Multiplication operation result is incorrect.");
        }
        Thread.sleep(1000);
        clearButton.click();
        WebElement display = driver.findElement(By.xpath("//*[@id=\"cwos\"]"));
        if (display.getText().contains("0")) {
            System.out.println("After Clear display shows zero(0).");
        } else {
            System.out.println(" display does not show zero(0).");
        }

        System.out.println("End Test case: testCase03");

    }

    public void testCase04() throws InterruptedException {
        System.out.println("Start Test case: testCase04");

        Thread.sleep(1000);
        WebElement firstNumber = driver.findElement(By.xpath(
                "//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[4]/td[2]/div/div"));
        firstNumber.click();
        // Thread.sleep(1000);
        WebElement zeroButton = driver.findElement(By.xpath(
                "//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[5]/td[1]/div/div"));
        zeroButton.click();
        Thread.sleep(1000);
        WebElement divButton = driver.findElement(By.xpath(
                "//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[2]/td[4]/div/div"));
        divButton.click();
        Thread.sleep(1000);
        WebElement thirdNumber = driver.findElement(By.xpath(
                "//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[3]/td[1]/div/div"));
        thirdNumber.click();
        Thread.sleep(1000);
        WebElement equalsButton = driver.findElement(By.xpath(
                "//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[5]/td[3]/div/div"));
        equalsButton.click();
        Thread.sleep(2000);

        // Verify the result of subtraction operation
        WebElement subtractionResult = driver.findElement(By.className("qv3Wpe"));
        if (subtractionResult.getText().contains("5")) {
            System.out.println("Division operation result is correct: 20 / 4 = 5");
        } else {
            System.out.println("Division operation result is incorrect.");
        }

        System.out.println("End Test case: testCase04");

    }
}
