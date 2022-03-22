package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MyStore {

    public SelenideElement layerCart() {
        return $("#layer_cart").as("модалка корзины");
    }

    public SelenideElement addToCartButton() {
        return $("#add_to_cart button").as("кнопка добавления в корзину");
    }

    public SelenideElement sizeInput() { return $("#group_1").as("Поле выбора размера");
    }
}
