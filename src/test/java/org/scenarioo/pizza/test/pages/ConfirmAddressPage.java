package org.scenarioo.pizza.test.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ConfirmAddressPage {

    private SelenideElement step = $("#step-confirmAddress");
    private SelenideElement yesButton = step.$(".yes");
    private SelenideElement noButton = step.$(".no");

    public static ConfirmAddressPage shouldDisplay() {
        ConfirmAddressPage page = new ConfirmAddressPage();
        page.shouldBeVisible();
        return page;
    }

    private void shouldBeVisible() {
        step.shouldBe(visible);
    }

    public SelectPizzaPage withExistingRegisteredAddress() {
        yesButton.click();
        return SelectPizzaPage.shouldDisplay();
    }

    public NewCustomerAddressPage withDifferentAddress() {
        noButton.click();
        return NewCustomerAddressPage.shouldDisplay();
    }

}

