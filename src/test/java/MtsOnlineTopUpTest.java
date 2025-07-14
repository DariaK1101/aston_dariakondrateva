import io.qameta.allure.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Epic("Онлайн пополнение MTS")
@Feature("Форма оплаты")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
    @AllureId("101")
    @DisplayName("Проверка заголовка блока оплаты")
    @Severity(SeverityLevel.NORMAL)
    void testBlockTitle() {
        mtsPage.checkBlockTitle();
    }

    @Test
    @AllureId("102")
    @DisplayName("Проверка логотипов платёжных систем")
    @Severity(SeverityLevel.NORMAL)
    void testPaymentLogos() {
        mtsPage.checkPaymentLogos();
    }

    @Test
    @AllureId("103")
    @DisplayName("Проверка ссылки 'Подробнее о сервисе'")
    @Severity(SeverityLevel.MINOR)
    void testMoreAboutServiceLink() {
        mtsPage.checkMoreAboutServiceLink();
    }

    @Test
    @AllureId("104")
    @DisplayName("Проверка формы 'Услуги связи' и кнопки 'Продолжить'")
    @Severity(SeverityLevel.CRITICAL)
    void testTopUpForm() {
        mtsPage.scrollToConnectionForm();
        mtsPage.fillConnectionFormAndCheckButtonState("297777777", "5");
    }

    @Test
    @AllureId("105")
    @DisplayName("Проверка плейсхолдеров и валидаций во всех формах")
    @Severity(SeverityLevel.NORMAL)
    void testPlaceholdersInAllForms() {
        mtsPage.checkValidationMessagesInAllForms();
    }

    @Test
    @AllureId("106")
    @DisplayName("Проверка данных в окне подтверждения оплаты")
    @Severity(SeverityLevel.CRITICAL)
    public void testConfirmationDetailsForConnection() {
        String testPhone = "297777777";
        String testAmount = "200.00";

        mtsPage.testConnectionConfirmationDetails(testPhone, testAmount);
    }
}

//cd /Users/kdaria1101/IdeaProjects/aston_dariakondrateva/Lesson_11
//mvn clean test
//allure serve allure-results
