import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.MyStorePages;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Feature("Добавление товара в корзину")
@Owner("Sarrriva")

public class AddItemToCartTest {

    @BeforeEach
    public void before() {
        step("Открыть страницу http://automationpractice.com/index.php", () -> {
            open("http://automationpractice.com/index.php");
        });
    }

    @Test
    @Story("Добавление товара в корзину")
    public void AddToCart() {
        step("Кликнуть на кнопку добавления корзины", () -> {
            MyStorePages.myStorePage.addToCartButton().click();
        });
    }
}
