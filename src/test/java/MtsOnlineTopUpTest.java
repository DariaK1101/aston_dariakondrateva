import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MtsOnlineTopUpTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private MtsOnlineTopUpPage mtsPage;

    @BeforeEach
    void beforeEach() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        mtsPage = new MtsOnlineTopUpPage(driver, wait);
        mtsPage.acceptCookiesIfPresent();
    }

    @AfterEach
    void afterEach() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Название блока")
    void testBlockTitle() {
        mtsPage.checkBlockTitle();
    }

    @Test
    @DisplayName("Логотипы платёжных систем")
    public void testPaymentLogos() {
        mtsPage.checkPaymentLogos();
    }

    @Test
    @DisplayName("Подробнее о сервисе")
    void testMoreAboutServiceLink() {
        mtsPage.checkMoreAboutServiceLink();
    }

    @Test
    @DisplayName("Кнопка 'Продолжить'")
    void testTopUpForm() {
        mtsPage.scrollToConnectionForm();
        mtsPage.fillConnectionFormAndCheckButtonState("297777777", "5");
    }

    @Test
    @DisplayName("Проверка полей")
    void testPlaceholdersInAllForms() {
        mtsPage.checkValidationMessagesInAllForms();
    }

    @Test
    @DisplayName("Проверека 'Услуги связи'")
    public void testConfirmationDetailsForConnection() {
        String testPhone = "297777777";
        String testAmount = "200.00";

        mtsPage.testConnectionConfirmationDetails(testPhone, testAmount);
    }
}
