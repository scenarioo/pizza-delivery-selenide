package org.scenarioo.pizza.test.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class NewCustomerAddressPage {

    private SelenideElement step = $("#step-enterAddress");
    private SelenideElement streetInput = step.$("#streetAndHouseNumber");
    private SelenideElement zipAndCityInput = step.$("#zipCodeAndCity");
    private SelenideElement nextButton = step.$("button.next");

    static NewCustomerAddressPage shouldDisplay() {
        NewCustomerAddressPage page = new NewCustomerAddressPage();
        page.shouldBeVisible();
        return page;
    }

    private void shouldBeVisible() {
        step.shouldBe(visible);
    }

    public SelectPizzaPage withAddress(String street, String zipAndCity) {
        streetInput.setValue(street);
        zipAndCityInput.setValue(zipAndCity);
        nextButton.click();
        return SelectPizzaPage.shouldDisplay();
    }

}
