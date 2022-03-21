package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MyStore {

    public SelenideElement addToCartButton() {
        return $(".ajax_add_to_cart_button").as("кнопка добавления в корзину");     }




}
