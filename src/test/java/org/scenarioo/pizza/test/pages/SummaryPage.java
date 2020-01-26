package org.scenarioo.pizza.test.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SummaryPage {

    private SelenideElement step = $("#step-summary");
    private SelenideElement pizzaSummary = step.$("#summary_pizza");
    private SelenideElement drinksSummary = step.$("#summary_drinks");
    private SelenideElement nextButton = step.$("button.next");
    private SelenideElement processingOrderProgress = step.$("#processing-order");

    public static SummaryPage shouldDisplay() {
        SummaryPage page = new SummaryPage();
        page.shouldDisplaySummary();
        return page;
    }

    private void shouldDisplaySummary() {
        step.shouldBe(visible);
    }

    public OrderConfirmationPage confirmSummary(String pizzaText, String drinksText) {
        pizzaSummary.shouldHave(exactText(pizzaText));
        drinksSummary.shouldHave(exactText(drinksText));
        nextButton.click();
        waitForOrderProcessed();
        return OrderConfirmationPage.shouldDisplay();
        // OrderConfirmationPage.should
    }

    private void waitForOrderProcessed() {
        // This usually takes some time to process the order,
        // so here we have to explicitly wait a little bit longer ...
        processingOrderProgress.waitWhile(visible, 12 * 1000); // wait up to 10 seconds for the order to be processed
        // DONT: just increasing default timeouts for such cases is a very bad idea!
    }

}
