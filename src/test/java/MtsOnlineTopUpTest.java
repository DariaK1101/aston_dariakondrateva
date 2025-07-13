import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MtsOnlineTopUpTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeAll
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        acceptCookiesIfPresent();
    }
    private void acceptCookiesIfPresent() {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement acceptButton = shortWait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(), 'Принять') or contains(text(), 'Согласен')]")
            ));
            acceptButton.click();
            System.out.println("Куки приняты");
        } catch (TimeoutException e) {
            System.out.println("Кнопка принятия куки не найдена");
        }
    }



    @AfterAll
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Название блока")
    void testBlockTitle() {
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='pay__wrapper']//h2")
        ));
        Assertions.assertTrue(title.getText().contains("Онлайн пополнение"),
                "Заголовок блока не найден или некорректный!");
    }

    @Test
    @DisplayName("Логотипы платёжных систем")
    public void testPaymentLogos() {
        List<WebElement> logos = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//div[@class='pay__partners']//img")
        ));
        Assertions.assertEquals(5, logos.size(), "Количество логотипов платёжных систем не совпадает!");

        List<String> expectedAlts = List.of(
                "Visa",
                "Verified By Visa",
                "MasterCard",
                "MasterCard Secure Code",
                "Белкарт"
        );

        List<String> actualAlts = logos.stream()
                .map(img -> img.getAttribute("alt"))
                .toList();

        for (String expectedAlt : expectedAlts) {
            Assertions.assertTrue(actualAlts.contains(expectedAlt),
                    "Логотип с alt='" + expectedAlt + "' не найден!");
        }

        for (WebElement logo : logos) {
            String src = logo.getAttribute("src");
            Assertions.assertNotNull(src, "У логотипа отсутствует атрибут src");
            Assertions.assertFalse(src.isEmpty(), "Атрибут src у логотипа пустой");
        }
    }

    @Test
    @DisplayName("Подробнее о сервисе")
    void testMoreAboutServiceLink() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(
                By.linkText("Подробнее о сервисе")
        ));
        Assertions.assertTrue(link.isDisplayed(), "Ссылка 'Подробнее о сервисе' не найдена!");

        link.click();
        wait.until(ExpectedConditions.urlContains("/help/poryadok-oplaty"));
        Assertions.assertTrue(driver.getCurrentUrl().contains("/help/poryadok-oplaty"),
                "Переход по ссылке 'Подробнее о сервисе' не сработал!");


        driver.navigate().back();
    }

    @Test
    @DisplayName("Кнопка Продолжить")
    void testTopUpForm() {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                driver.findElement(By.id("pay-connection")));

        WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("connection-phone")));
        WebElement sumInput = driver.findElement(By.id("connection-sum"));
        WebElement continueButton = driver.findElement(
                By.xpath("//form[@id='pay-connection']//button[contains(text(),'Продолжить')]")
        );

        phoneInput.clear();
        phoneInput.sendKeys("297777777");
        sumInput.clear();
        sumInput.sendKeys("5");

        Assertions.assertTrue(continueButton.isEnabled(),
                "Кнопка 'Продолжить' не активна!");
    }
}


