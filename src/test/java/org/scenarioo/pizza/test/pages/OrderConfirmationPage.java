package org.scenarioo.pizza.test.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OrderConfirmationPage {

    private SelenideElement step = $("#step-confirmation");
    private SelenideElement pizzaConfirmation = step.$("#confirmation_pizza");
    private SelenideElement drinksConfirmation = step.$("#confirmation_drinks");

    public static OrderConfirmationPage shouldDisplay() {
        OrderConfirmationPage page = new OrderConfirmationPage();
        page.shouldBeVisible();
        return page;
    }

    private void shouldBeVisible() {
        step.shouldBe(visible);
    }

    public void shouldDisplayConfirmation(String pizzaText, String drinksText) {
        pizzaConfirmation.shouldHave(exactText(pizzaText));
        drinksConfirmation.shouldHave(exactText(drinksText));
    }

}
