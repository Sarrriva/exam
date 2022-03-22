import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.MyStorePages;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@Feature("Добавление товара в корзину")
@Owner("Sarrriva")

public class AddItemToCartTest {

    @BeforeEach
    public void before() {
        step("Открыть страницу http://automationpractice.com/index.php", () -> {
            open("http://automationpractice.com/index.php?id_product=2&controller=product&search_query=Blouse&results=1");
        });
    }

    @Test
    @Story("Добавление товара в корзину")
    public void AddToCart() {
        step("Проверка добавления товара в корзину", () -> {

            MyStorePages.myStorePage.addToCartButton()
                    .click();
            MyStorePages.myStorePage.layerCart()
                    .shouldBe(Condition.visible);
        });
    }

    @Test
    @Story("Проверка ссылок")
    @ParameterizedTest
    @MethodSource("sizes")
    public void LinkSkuTest(@Param String size,
                            @Param String value) {
        step("Проверка ссылки СКУ", () -> {
            open("http://automationpractice.com/index.php?id_product=7&controller=product#/color-yellow/size-" + size);
            MyStorePages.myStorePage.sizeInput()
                    .shouldBe(Condition.exactValue(value));
        });
    }


    static Stream<Arguments> sizes() {
        return Stream.of(
                arguments("l", "3"),
                arguments("m", "2"),
                arguments("s", "1")
        );
    }
}
