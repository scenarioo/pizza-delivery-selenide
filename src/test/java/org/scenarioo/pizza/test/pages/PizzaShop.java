package org.scenarioo.pizza.test.pages;

import com.codeborne.selenide.SelenideElement;
import com.sun.org.apache.bcel.internal.generic.NEW;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

/**
 * The start page of the shop, where the user has to enter his phone number first to start ordering.
 */
public class PizzaShop {

    private static final String EXISTING_CUSTOMER_PHONE_NUMBER = "0791111111";
    private static final String NEW_CUSTOMER_PHONE_NUMBER = "0792222222";

    private SelenideElement header = $(".page-header");
    private SelenideElement shopPhoneNumber = header.$("#hot-pizza-delivery-phone-number");

    private SelenideElement step = $("#step-enterPhoneNumber");
    private SelenideElement customerPhoneNumber = step.$("#phoneNumber");
    private SelenideElement nextButton = step.$("button.next");

    public static PizzaShop start() {
        open("https://scenarioo.org/pizza-delivery/pizza-shop");
        PizzaShop pizzaShop = new PizzaShop();
        pizzaShop.shouldDisplayHeaderWithPhoneNumber();
        pizzaShop.shouldDisplaySelectPhoneNumberStep();
        return pizzaShop;
    }

    private void shouldDisplayHeaderWithPhoneNumber() {
        header.shouldBe(visible);
        header.shouldHave(text("Hot Pizza Delivery"));
        header.shouldHave(text("Best pizza in town!"));
        shopPhoneNumber.shouldBe(visible);
        shopPhoneNumber.shouldHave(text("+41 11 222 33 44"));
     }

    private void shouldDisplaySelectPhoneNumberStep() {
        step.shouldBe(visible);
    }

    public NewCustomerAddressPage orderPizzaForNewCustomerPhoneNumber() {
        customerPhoneNumber.shouldBe(visible);
        customerPhoneNumber.shouldBe(empty);
        customerPhoneNumber.sendKeys(NEW_CUSTOMER_PHONE_NUMBER);
        nextButton.click();
        return NewCustomerAddressPage.shouldDisplay();
    }

    public ConfirmAddressPage orderPizzaForExistingCustomerPhoneNumber() {
        customerPhoneNumber.shouldBe(visible);
        customerPhoneNumber.shouldBe(empty);
        customerPhoneNumber.sendKeys(EXISTING_CUSTOMER_PHONE_NUMBER);
        nextButton.click();
        return ConfirmAddressPage.shouldDisplay();
    }

}
