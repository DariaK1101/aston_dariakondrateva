import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class MtsOnlineTopUpPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public MtsOnlineTopUpPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void acceptCookiesIfPresent() {
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

    public void checkBlockTitle() {
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='pay__wrapper']//h2")
        ));
        Assertions.assertTrue(title.getText().contains("Онлайн пополнение"),
                "Заголовок блока не найден или некорректный!");
    }

    public void checkPaymentLogos() {
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

    public void checkMoreAboutServiceLink() {
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

    public void scrollToConnectionForm() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                driver.findElement(By.id("pay-connection")));
    }

    public void fillConnectionFormAndCheckButtonState(String phone, String amount) {
        WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("connection-phone")));
        WebElement sumInput = driver.findElement(By.id("connection-sum"));
        WebElement continueButton = driver.findElement(
                By.xpath("//form[@id='pay-connection']//button[contains(text(),'Продолжить')]"));

        phoneInput.clear();
        phoneInput.sendKeys(phone);
        sumInput.clear();
        sumInput.sendKeys(amount);

        Assertions.assertTrue(continueButton.isEnabled(),
                "Кнопка 'Продолжить' не активна!");
    }

    public void checkValidationMessagesInAllForms() {
        Map<String, String[]> formPlaceholders = Map.of(
                "Услуги связи", new String[]{"connection-phone", "connection-sum", "connection-email"},
                "Домашний интернет", new String[]{"internet-phone", "internet-sum", "internet-email"},
                "Рассрочка", new String[]{"score-instalment", "instalment-sum", "instalment-email"},
                "Задолженность", new String[]{"score-arrears", "arrears-sum", "arrears-email"}
        );

        for (String optionText : formPlaceholders.keySet()) {
            if (!optionText.equals("Услуги связи")) {
                WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".select__header")));
                dropdown.click();

                WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//ul[contains(@class,'select__list')]//p[text()='" + optionText + "']")));
                option.click();
            }

            String[] fieldIds = formPlaceholders.get(optionText);
            for (String fieldId : fieldIds) {
                WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(fieldId)));
                String placeholder = input.getAttribute("placeholder");
                Assertions.assertFalse(placeholder == null || placeholder.isEmpty(),
                        "Плейсхолдер отсутствует у поля с id: " + fieldId + " для формы: " + optionText);
                System.out.println(optionText + " → " + fieldId + " → placeholder='" + placeholder + "'");
            }
        }
    }

    public void testConnectionConfirmationDetails(String phone, String amount) {
        scrollToConnectionForm();

        WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("connection-phone")));
        WebElement sumInput = driver.findElement(By.id("connection-sum"));
        WebElement continueButton = driver.findElement(By.xpath("//form[@id='pay-connection']//button[contains(text(),'Продолжить')]"));

        phoneInput.clear();
        phoneInput.sendKeys(phone);
        sumInput.clear();
        sumInput.sendKeys(amount);

        System.out.println("Нажимаем 'Продолжить' для формы 'Услуги связи'");
        continueButton.click();

        System.out.println("Ожидаем появления iframe с формой оплаты...");
        WebDriverWait extendedWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement iframe = extendedWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("iframe.bepaid-iframe")));

        driver.switchTo().frame(iframe);

        System.out.println("Внутри iframe — проверяем отображение данных");

        WebElement paymentTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Оплата: Услуги связи')]")));
        WebElement phoneText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + phone + "')]")));
        WebElement amountText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + amount + "')]")));
        WebElement payButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'" + amount + "')]")));

        Assertions.assertTrue(paymentTitle.isDisplayed(), "Текст 'Оплата: Услуги связи' не найден");
        Assertions.assertTrue(phoneText.isDisplayed(), "Номер телефона не найден");
        Assertions.assertTrue(amountText.isDisplayed(), "Сумма не найдена");
        Assertions.assertTrue(payButton.isDisplayed(), "Кнопка с суммой не найдена");

        // Проверка лейблов реквизитов карты
        Assertions.assertTrue(driver.getPageSource().contains("Номер карты"), "Лейбл 'Номер карты' не найден");
        Assertions.assertTrue(driver.getPageSource().contains("Срок действия"), "Лейбл 'Срок действия' не найден");
        Assertions.assertTrue(driver.getPageSource().contains("Имя и фамилия на карте"), "Лейбл 'Имя и фамилия на карте' не найден");
        Assertions.assertTrue(driver.getPageSource().contains("CVC"), "Лейбл 'CVC' не найден");

        // Проверка иконок платёжных систем
        List<WebElement> icons = driver.findElements(By.cssSelector("img[src*='visa'], img[src*='mastercard'], img[src*='belkart'], img[src*='maestro']"));
        Assertions.assertFalse(icons.isEmpty(), "Иконки платёжных систем не найдены");

        // Вернуться обратно на основной документ
        driver.switchTo().defaultContent();
    }


}
